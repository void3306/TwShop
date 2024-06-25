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
    public PageVo<IdleItemDto> getIdleItemByPage(String findValue, Integer page, Integer size) {
        QueryWrapper<IdleItem> idleItemQuerywrapper = new QueryWrapper<>();
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        idleItemQuerywrapper.like("idle_name", findValue).
                or().like("idle_details", findValue).
                and(i -> i.eq("idle_status", 1)).
                orderByDesc("release_time").
                last("limit " + (page - 1) * size + "," + size);
        List<IdleItem> idleItems = idleItemMapper.selectList(idleItemQuerywrapper);

        idleItemQuerywrapper.clear();
        idleItemQuerywrapper.like("idle_name", findValue).
                or().like("idle_details", findValue).
                and(i -> i.eq("idle_status", 1));
        int count = idleItemMapper.selectCount(idleItemQuerywrapper);

        List<IdleItemDto> idleItemDtoList = new ArrayList<>();

        userQueryWrapper.select("id", "nickname", "avatar", "sign_in_time");

        for (IdleItem idleItem : idleItems) {
            userQueryWrapper.eq("id", idleItem.getUserId());
            User user = userMapper.selectOne(userQueryWrapper);
            IdleItemDto idleItemDto = idleItem.toDto();
            idleItemDto.setUser(user);
            idleItemDtoList.add(idleItemDto);
        }

        return new PageVo<>(idleItemDtoList, count);
    }
}
