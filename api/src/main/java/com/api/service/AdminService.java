package com.api.service;

import com.api.model.entity.Admin;
import com.api.model.vo.PageVo;

public interface AdminService {
    Admin login(String username, String password);

    PageVo<Admin> getAdminList(Integer page, Integer size);

    int add(Admin admin);
}
