package com.api.service.impl;

import com.api.mapper.IdleItemMapper;
import com.api.mapper.OrderMapper;
import com.api.mapper.UserMapper;
import com.api.model.dto.OrderDto;
import com.api.model.entity.IdleItem;
import com.api.model.entity.Order;
import com.api.model.entity.User;
import com.api.model.vo.PageVo;
import com.api.service.OrderService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Resource
    private OrderMapper orderMapper;

    @Resource
    private IdleItemMapper idleItemMapper;

    @Resource
    private UserMapper userMapper;


    @Override
    public PageVo<OrderDto> getOrderList(Integer page, Integer size) {
        QueryWrapper<Order> orderQueryWrapper = new QueryWrapper<>();
        return buildOrderDtoListPageVo(orderQueryWrapper, page, size);
    }

    @Override
    public int deleteOrder(Long orderId) {
        return orderMapper.deleteById(orderId);
    }

    public PageVo<OrderDto> buildOrderDtoListPageVo(QueryWrapper<Order> orderQueryWrapper, Integer page, Integer size){
        int count = orderMapper.selectCount(orderQueryWrapper);
        orderQueryWrapper.last("limit " + (page - 1) * size + "," + size);
        List<Order> orderList = orderMapper.selectList(orderQueryWrapper);

        List<OrderDto> orderDtoList = buildOrderDtoList(orderList);

        return new PageVo<>(orderDtoList,count);
    }

    public List<OrderDto> buildOrderDtoList(List<Order> orderList){
        List<OrderDto> orderDtoList = new ArrayList<>();
        for (Order order : orderList) {
            orderDtoList.add(buildOrderDto(order));
        }
        return orderDtoList;
    }

    public OrderDto buildOrderDto(Order order){
        QueryWrapper<IdleItem> idleItemQueryWrapper = new QueryWrapper<>();
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        return buildOrderDto(order, idleItemQueryWrapper,userQueryWrapper);
    }

    public OrderDto buildOrderDto(Order order, QueryWrapper<IdleItem> idleItemQueryWrapper, QueryWrapper<User> userQueryWrapper){
        idleItemQueryWrapper.eq("id", order.getIdleId());
        IdleItem idleItem = idleItemMapper.selectOne(idleItemQueryWrapper);
        userQueryWrapper.eq("id", order.getUserId());
        User user = userMapper.selectOne(userQueryWrapper);
        OrderDto orderDto = order.toDto();
        orderDto.setIdleItem(idleItem);
        orderDto.setUser(user);
        return orderDto;
    }

}
