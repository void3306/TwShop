package com.api.service.impl;

import com.api.mapper.AddressMapper;
import com.api.mapper.OrderAddressMapper;
import com.api.model.entity.OrderAddress;
import com.api.service.OrderAddressService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class OrderAddressServiceImpl implements OrderAddressService {

    @Resource
    private OrderAddressMapper orderAddressMapper;

    @Override
    public boolean add(OrderAddress orderAddress) {
        return orderAddressMapper.insert(orderAddress) > 0;
    }

    @Override
    public boolean update(OrderAddress orderAddressModel) {
        return orderAddressMapper.updateById(orderAddressModel) > 0;
    }

    @Override
    public OrderAddress get(Long orderId) {
        return orderAddressMapper.selectById(orderId);
    }
}
