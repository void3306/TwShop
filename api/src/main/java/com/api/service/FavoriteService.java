package com.api.service;

import com.api.model.dto.FavoriteDto;
import com.api.model.entity.Favorite;

import java.util.List;

public interface FavoriteService {
    List<FavoriteDto> getMyFavorite(Long userId);

    boolean add(Favorite favorite);

    boolean delete(Long id);

    Integer isFavorite(Long userId, Long idleId);
}
