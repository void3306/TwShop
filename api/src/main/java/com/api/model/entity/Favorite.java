package com.api.model.entity;

import com.api.model.dto.FavoriteDto;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@EqualsAndHashCode
@TableName("sh_favorite")
public class Favorite implements Serializable {
    private Long id;
    private Date createTime;
    private Long userId;
    private Long idleId;
    private static final long serialVersionUID = 1L;

    public FavoriteDto toDto() {
        FavoriteDto favoriteDto = new FavoriteDto();
        favoriteDto.setId(this.id);
        favoriteDto.setCreateTime(this.createTime);
        favoriteDto.setUserId(this.userId);
        favoriteDto.setIdleId(this.idleId);
        return favoriteDto;
    }
}