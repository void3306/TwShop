package com.api.model.entity;

import com.api.model.dto.OrderDto;
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
    private Long idleId;
    private BigDecimal orderPrice;
    private Byte paymentStatus;
    private String paymentWay;
    private Date createTime;
    private Date paymentTime;
    private Byte orderStatus;
    private Byte isDeleted;
    private static final long serialVersionUID = 1L;

    public OrderDto toDto() {
        OrderDto orderDto = new OrderDto();
        orderDto.setId(this.id);
        orderDto.setOrderNumber(this.orderNumber);
        orderDto.setUserId(this.userId);
        orderDto.setIdleId(this.idleId);
        orderDto.setOrderPrice(this.orderPrice);
        orderDto.setPaymentStatus(this.paymentStatus);
        orderDto.setPaymentWay(this.paymentWay);
        orderDto.setCreateTime(this.createTime);
        orderDto.setPaymentTime(this.paymentTime);
        orderDto.setOrderStatus(this.orderStatus);
        orderDto.setIsDeleted(this.isDeleted);
        return orderDto;
    }
}