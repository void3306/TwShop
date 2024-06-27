package com.api.service;

import com.api.model.entity.OrderAddress;

public interface OrderAddressService {
    boolean add(OrderAddress orderAddressModel);

    boolean update(OrderAddress orderAddressModel);

    OrderAddress get(Long orderId);
}
