package com.api.service;


import com.api.model.entity.User;

public interface UserService {

    /**
     * 获取某个用户的公开信息
     * @param id
     * @return
     */
    User getUser(Long id);

    /**
     * 用户登录
     * @param username
     * @param password
     * @return
     */
    User login(String username, String password);


}
