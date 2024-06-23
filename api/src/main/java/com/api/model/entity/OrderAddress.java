package com.api.model.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@EqualsAndHashCode
@TableName("sh_type")
public class OrderAddress implements Serializable {
    private Long id;
    private Long orderId;
    private String consigneeName;
    private String consigneePhone;
    private String detailAddress;
    private static final long serialVersionUID = 1L;

}