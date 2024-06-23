package com.api.service.impl;

import com.api.mapper.UserMapper;
import com.api.model.entity.User;
import com.api.service.UserService;
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


}
