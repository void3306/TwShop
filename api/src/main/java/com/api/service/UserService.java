package com.api.service;


import com.api.model.entity.User;
import com.api.model.vo.PageVo;

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


    PageVo<User> getUserListByStatus(Integer status, Integer page, Integer size);

    int updateUserStatus(Long userId, Byte status);
}
