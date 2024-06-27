package com.api.service.impl;

import com.api.mapper.AddressMapper;
import com.api.model.entity.Address;
import com.api.service.AddressService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {

    @Resource
    private AddressMapper addressMapper;

    @Override
    public List<Address> getAddressByUid(Long id) {
        QueryWrapper<Address> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id", id);
        return addressMapper.selectList(queryWrapper);
    }

    @Override
    public boolean add(Address address) {
        return addressMapper.insert(address) == 1;
    }

    @Override
    public boolean update(Address address) {
        return addressMapper.updateById(address) == 1;
    }

    @Override
    public boolean delete(Address address) {
        QueryWrapper<Address> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id", address.getUserId());
        queryWrapper.eq("id", address.getId());
        return addressMapper.delete(queryWrapper) == 1;
    }

    @Override
    public Address getAddressById(Long id, Long shUserId) {
        QueryWrapper<Address> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id", shUserId);
        queryWrapper.eq("id", id);
        return addressMapper.selectOne(queryWrapper);
    }
}
