package com.api.model.entity;

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
    private IdleItem idleItem;
    private static final long serialVersionUID = 1L;
}