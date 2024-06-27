package com.api.service.impl;

import com.api.mapper.IdleItemMapper;
import com.api.mapper.UserMapper;
import com.api.model.dto.IdleItemDto;
import com.api.model.entity.IdleItem;
import com.api.model.entity.User;
import com.api.model.vo.PageVo;
import com.api.service.IdleItemService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class IdleItemServiceImpl implements IdleItemService {

    @Resource
    private IdleItemMapper idleItemMapper;

    @Resource
    private UserMapper userMapper;

    @Override
    public PageVo<IdleItemDto> getIdleItemListByFindValue(String findValue, Integer page, Integer size) {
        QueryWrapper<IdleItem> idleItemQueryWrapper = new QueryWrapper<>();
        idleItemQueryWrapper.and(wrapper ->
                        wrapper.like("idle_name", "%"+findValue+"%")
                                .or()
                                .like("idle_details", "%"+findValue+"%"))
                .eq("idle_status", 1)
                .orderByDesc("id");
        return buildIdleItemDtoListPageVo(idleItemQueryWrapper,page,size);
    }

    @Override
    public PageVo<IdleItemDto> getIdleItemListByLabel(Integer label, Integer page, Integer size) {
        QueryWrapper<IdleItem> idleItemQueryWrapper = new QueryWrapper<>();
        idleItemQueryWrapper.eq("idle_label", label)
                .eq("idle_status", 1)
                .orderByDesc("id");
        return buildIdleItemDtoListPageVo(idleItemQueryWrapper,page,size);

    }

    @Override
    public PageVo<IdleItemDto> getIdleItemListByStatus(Integer status, Integer page, Integer size) {
        QueryWrapper<IdleItem> idleItemQueryWrapper = new QueryWrapper<>();
        idleItemQueryWrapper.eq("idle_status", status)
                .orderByDesc("id");
        return buildIdleItemDtoListPageVo(idleItemQueryWrapper,page,size);
    }

    @Override
    public int addIdleItem(IdleItem idleItem) {
        return idleItemMapper.insert(idleItem);
    }

    @Override
    public IdleItemDto getIdleItemInfo(Long idleId) {
        IdleItem idleItem = idleItemMapper.selectById(idleId);
        return buildIdleItemDto(idleItem);
    }

    @Override
    public int updateIdleStatus(Long idleId, Byte status) {
        IdleItem idleItem = idleItemMapper.selectById(idleId);
        idleItem.setIdleStatus(status);
        return idleItemMapper.updateById(idleItem);
    }

    @Override
    public List<IdleItemDto> getAllIdleItemByUid(Long shUserId) {
        QueryWrapper<IdleItem> idleItemQueryWrapper = new QueryWrapper<>();
        idleItemQueryWrapper.eq("user_id", shUserId)
                .orderByDesc("id");
        List<IdleItem> idleItems = idleItemMapper.selectList(idleItemQueryWrapper);
        return buildIdleItemDtoList(idleItems);
    }

    @Override
    public boolean updateIdleItem(IdleItem idleItem) {
        return idleItemMapper.updateById(idleItem) == 1;
    }

    public PageVo<IdleItemDto> buildIdleItemDtoListPageVo(QueryWrapper<IdleItem> wrapper, Integer page, Integer size) {
        int count = idleItemMapper.selectCount(wrapper);
        wrapper.last("limit " + (page - 1) * size + "," + size);
        List<IdleItem> idleItems = idleItemMapper.selectList(wrapper);

        List<IdleItemDto> idleItemDtoList = buildIdleItemDtoList(idleItems);

        return new PageVo<>(idleItemDtoList, count);
    }

    public List<IdleItemDto> buildIdleItemDtoList(List<IdleItem> idleItems) {
        List<IdleItemDto> idleItemDtoList = new ArrayList<>();

        for (IdleItem idleItem : idleItems)
            idleItemDtoList.add(buildIdleItemDto(idleItem));

        return idleItemDtoList;
    }

    public IdleItemDto buildIdleItemDto(IdleItem idleItem) {
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.select("id", "nickname", "avatar", "sign_in_time");
        return buildIdleItemDto(idleItem, userQueryWrapper);
    }

    public IdleItemDto buildIdleItemDto(IdleItem idleItem, QueryWrapper<User> userQueryWrapper) {
        userQueryWrapper.eq("id", idleItem.getUserId());
        User user = userMapper.selectOne(userQueryWrapper);
        user.setUserPassword(null);
        IdleItemDto idleItemDto = idleItem.toDto();
        idleItemDto.setUser(user);
        return idleItemDto;
    }

}
