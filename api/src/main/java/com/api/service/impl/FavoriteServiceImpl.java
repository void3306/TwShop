package com.api.service.impl;

import com.api.mapper.FavoriteMapper;
import com.api.mapper.IdleItemMapper;
import com.api.mapper.UserMapper;
import com.api.model.dto.FavoriteDto;
import com.api.model.dto.IdleItemDto;
import com.api.model.entity.Favorite;
import com.api.model.entity.IdleItem;
import com.api.model.entity.User;
import com.api.service.FavoriteService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class FavoriteServiceImpl implements FavoriteService {

    @Resource
    private FavoriteMapper favoriteMapper;

    @Resource
    private IdleItemMapper idleItemMapper;

    @Resource
    private UserMapper userMapper;

    @Override
    public List<FavoriteDto> getMyFavorite(Long userId) {
        QueryWrapper<Favorite> wrapper = new QueryWrapper<>();
        wrapper.eq("user_id", userId);
        return buildDtoList(favoriteMapper.selectList(wrapper));
    }

    @Override
    public boolean add(Favorite favorite) {
        QueryWrapper<Favorite> wrapper = new QueryWrapper<>();
        wrapper.eq("user_id", favorite.getUserId());
        wrapper.eq("idle_id", favorite.getIdleId());
        if (favoriteMapper.selectOne(wrapper) != null)
            return false;

        return favoriteMapper.insert(favorite) == 1;
    }

    @Override
    public boolean delete(Long id) {
        return favoriteMapper.deleteById(id) == 1;
    }

    @Override
    public Integer isFavorite(Long userId, Long idleId) {
        QueryWrapper<Favorite> wrapper = new QueryWrapper<>();
        wrapper.eq("user_id", userId);
        wrapper.eq("idle_id", idleId);
        return favoriteMapper.selectCount(wrapper);
    }

    public List<FavoriteDto> buildDtoList(List<Favorite> favoriteList) {
        List<FavoriteDto> favoriteDtoList = new ArrayList<>();

        for (Favorite favorite : favoriteList)
            favoriteDtoList.add(buildDto(favorite));

        return favoriteDtoList;
    }

    public FavoriteDto buildDto(Favorite favorite) {
        QueryWrapper<IdleItem> idleItemQueryWrapper = new QueryWrapper<>();
        return buildDto(favorite, idleItemQueryWrapper);
    }

    public FavoriteDto buildDto(Favorite favorite, QueryWrapper<IdleItem> idleItemQueryWrapper) {
        idleItemQueryWrapper.eq("id", favorite.getIdleId());
        IdleItem idleItem = idleItemMapper.selectOne(idleItemQueryWrapper);
        IdleItemDto idleItemDto = idleItem.toDto();
        User user = userMapper.selectOne(new QueryWrapper<User>().eq("id", idleItem.getUserId()));
        user.setUserPassword(null);
        idleItemDto.setUser(user);
        FavoriteDto favoriteDto = favorite.toDto();
        favoriteDto.setIdleItemDto(idleItemDto);
        return favoriteDto;
    }

}
