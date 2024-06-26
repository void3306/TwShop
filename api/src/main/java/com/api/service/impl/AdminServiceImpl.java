package com.api.service.impl;

import com.api.mapper.AdminMapper;
import com.api.model.entity.Admin;
import com.api.service.AdminService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class AdminServiceImpl implements AdminService {

    @Resource
    private AdminMapper adminMapper;

    @Override
    public Admin login(String username, String password) {
        QueryWrapper<Admin> queryWrapper = new QueryWrapper<>();
        queryWrapper.in("account_number", username);
        queryWrapper.in("admin_password", password);
        return adminMapper.selectOne(queryWrapper);
    }
}
