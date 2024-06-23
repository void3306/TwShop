package com.twShop.model.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@EqualsAndHashCode
@TableName("sh_address")
public class Address implements Serializable {
    private Long id;
    private String consigneeName;
    private String consigneePhone;
    private String provinceName;
    private String cityName;
    private String regionName;
    private String detailAddress;
    private Boolean defaultFlag;
    private Long userId;
    private static final long serialVersionUID = 1L;

}