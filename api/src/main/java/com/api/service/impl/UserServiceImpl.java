package com.api.service.impl;

import com.api.mapper.UserMapper;
import com.api.model.entity.User;
import com.api.service.UserService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    /**
     * 查询一个用户的公开信息
     * @param id
     * @return
     */
    @Override
    public User getUser(Long id){
        return userMapper.selectById(id);
    }

    @Override
    public User login(String username, String password) {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.in("account_number", username);
        wrapper.in("user_password", password);
        return userMapper.selectOne(wrapper);
    }


}
