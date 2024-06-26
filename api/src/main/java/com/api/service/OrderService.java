package com.api.service;

import com.api.model.dto.OrderDto;
import com.api.model.entity.Order;
import com.api.model.vo.PageVo;

public interface OrderService {
    PageVo<OrderDto> getOrderList(Integer page, Integer size);

    int deleteOrder(Long orderId);
}
