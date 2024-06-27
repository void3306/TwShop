package com.api.service;

import com.api.model.dto.OrderDto;
import com.api.model.entity.Order;
import com.api.model.vo.PageVo;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface OrderService {
    PageVo<OrderDto> getOrderList(Integer page, Integer size);

    int deleteOrder(Long orderId);

    List<OrderDto> getMyOrder(Long userId);

    List<OrderDto> getMySoldOrder(Long userId);

    OrderDto getOrderById(Long id);

    boolean add(Order order);

    boolean update(Order order);
}
