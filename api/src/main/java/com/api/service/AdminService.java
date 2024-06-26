package com.api.service;

import com.api.model.entity.Admin;

public interface AdminService {
    Admin login(String username, String password);
}
