package com.twShop.model.entity;

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
@TableName("sh_order")
public class Order implements Serializable {
    private Long id;
    private String orderNumber;
    private Long userId;
    private User user;
    private Long idleId;
    private IdleItem idleItem;
    private BigDecimal orderPrice;
    private Byte paymentStatus;
    private String paymentWay;
    private Date createTime;
    private Date paymentTime;
    private Byte orderStatus;
    private Byte isDeleted;
    private static final long serialVersionUID = 1L;

}