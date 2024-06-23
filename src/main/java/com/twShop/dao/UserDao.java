package com.twShop.dao;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.twShop.model.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserDao extends BaseMapper<User> {
}