package com.twShop.service.impl;

import com.twShop.dao.UserDao;
import com.twShop.model.entity.User;
import com.twShop.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userDao;

    /**
     * 查询一个用户的公开信息
     * @param id
     * @return
     */
    @Override
    public User getUser(Long id){
        return userDao.selectById(id);
    }


}
