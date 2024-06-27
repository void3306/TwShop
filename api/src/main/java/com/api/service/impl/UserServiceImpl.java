package com.api.service.impl;

import com.api.mapper.UserMapper;
import com.api.model.entity.User;
import com.api.model.vo.PageVo;
import com.api.service.UserService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


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

    @Override
    public PageVo<User> getUserListByStatus(Integer status, Integer page, Integer size) {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("user_status", status);
        int count = userMapper.selectCount(wrapper);
        wrapper.last("limit " + (page - 1) * size + "," + size);
        List<User> userList = userMapper.selectList(wrapper);
        return new PageVo<>(userList,count);
    }

    @Override
    public int updateUserStatus(Long userId, Byte status) {
        User user = new User();
        user.setId(userId);
        user.setUserStatus(status);
        return userMapper.updateById(user);
    }

    @Override
    public boolean add(User user) {
        return userMapper.insert(user) == 1;
    }

    @Override
    public boolean update(User user) {
        return userMapper.updateById(user) == 1;
    }

    @Override
    public boolean updatePassword(String newPassword, String oldPassword, Long shUserId) {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("id", shUserId);
        wrapper.eq("user_password", oldPassword);
        User user = userMapper.selectOne(wrapper);
        if (user == null) return false;
        user.setUserPassword(newPassword);
        return userMapper.updateById(user) == 1;
    }


}
