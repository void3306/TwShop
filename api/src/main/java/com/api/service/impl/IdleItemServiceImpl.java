package com.api.service.impl;

import com.api.mapper.IdleItemMapper;
import com.api.mapper.UserMapper;
import com.api.model.dto.IdleItemDto;
import com.api.model.entity.IdleItem;
import com.api.model.entity.User;
import com.api.model.vo.PageVo;
import com.api.service.IdleItemService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
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
    public PageVo<IdleItemDto> getIdleItemByPage(String findValue, Integer page, Integer size) {
        IPage<IdleItem> idleItemPage = new Page<>(page, size);

        QueryWrapper<IdleItem> idleItemQueryWrapper = new QueryWrapper<>();
        idleItemQueryWrapper.and(wrapper ->
                        wrapper.like("idle_name", "%"+findValue+"%")
                                .or()
                                .like("idle_details", "%"+findValue+"%"))
                .eq("idle_status", 1)
                .orderByDesc();

        idleItemMapper.selectPage(idleItemPage, idleItemQueryWrapper);

        return buildIdleItemDtoPageVo(idleItemPage);
    }

    @Override
    public PageVo<IdleItemDto> getIdleItemByLabel(Integer label, Integer page, Integer size) {
        IPage<IdleItem> idleItemPage = new Page<>(page, size);

        QueryWrapper<IdleItem> idleItemQueryWrapper = new QueryWrapper<>();
        idleItemQueryWrapper.eq("idle_label", label)
                .eq("idle_status", 1)
                .orderByDesc();

        idleItemMapper.selectPage(idleItemPage, idleItemQueryWrapper);

        return buildIdleItemDtoPageVo(idleItemPage);

    }

    public PageVo<IdleItemDto> buildIdleItemDtoPageVo(IPage<IdleItem> idleItemPage) {
        List<IdleItem> idleItems = idleItemPage.getRecords();
        long count = idleItemPage.getTotal();

        List<IdleItemDto> idleItemDtoList = buildIdleItemDtoList(idleItems);

        return new PageVo<>(idleItemDtoList, (int)count);
    }

    public List<IdleItemDto> buildIdleItemDtoList(List<IdleItem> idleItems) {
        List<IdleItemDto> idleItemDtoList = new ArrayList<>();
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.select("id", "nickname", "avatar", "sign_in_time");

        for (IdleItem idleItem : idleItems) {
            userQueryWrapper.eq("id", idleItem.getUserId());
            User user = userMapper.selectOne(userQueryWrapper);
            IdleItemDto idleItemDto = idleItem.toDto();
            idleItemDto.setUser(user);
            idleItemDtoList.add(idleItemDto);
            userQueryWrapper.clear();
        }

        return idleItemDtoList;
    }
}
