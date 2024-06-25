package com.api.model.entity;

import com.api.model.dto.IdleItemDto;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
@NoArgsConstructor
@EqualsAndHashCode
@TableName("sh_idle_item")
public class IdleItem implements Serializable {
    private Long id;
    private String idleName;
    private String idleDetails;
    private String pictureList;
    private BigDecimal idlePrice;
    private String idlePlace;
    private Integer idleLabel;
    private Date releaseTime;
    private Byte idleStatus;
    private Long userId;
    private static final long serialVersionUID = 1L;

    public IdleItemDto toDto() {
        IdleItemDto idleItemDto = new IdleItemDto();
        idleItemDto.setId(this.id);
        idleItemDto.setIdleName(this.idleName);
        idleItemDto.setIdleDetails(this.idleDetails);
        idleItemDto.setPictureList(this.pictureList);
        idleItemDto.setIdlePrice(this.idlePrice);
        idleItemDto.setIdlePlace(this.idlePlace);
        idleItemDto.setIdleLabel(this.idleLabel);
        idleItemDto.setReleaseTime(this.releaseTime);
        idleItemDto.setIdleStatus(this.idleStatus);
        idleItemDto.setUserId(this.userId);
        return idleItemDto;
    }
}