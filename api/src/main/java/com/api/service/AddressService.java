package com.api.service;


import com.api.model.entity.Address;

import java.util.List;

public interface AddressService {
    List<Address> getAddressByUid(Long id);

    boolean add(Address address);

    boolean update(Address address);

    boolean delete(Address address);

    Address getAddressById(Long id, Long shUserId);
}
