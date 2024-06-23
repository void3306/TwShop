package com.twShop.service;


import com.twShop.model.entity.User;

public interface UserService {

    /**
     * 获取某个用户的公开信息
     * @param id
     * @return
     */
    User getUser(Long id);


}
