package com.api.model.dto;

import com.api.model.entity.Favorite;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FavoriteDto extends Favorite implements Serializable {
    private IdleItemDto idleItemDto;
}
