package com.api.controller;

import com.api.common.enums.ErrorMsg;
import com.api.model.entity.Admin;
import com.api.model.vo.ResultVo;
import com.api.service.AdminService;
import com.api.service.IdleItemService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@CrossOrigin
@RestController
@RequestMapping("admin")
public class AdminController {

    @Resource
    private AdminService adminService;

    @Resource
    private IdleItemService idleItemService;

    @GetMapping("login")
    public ResultVo login(@RequestParam("accountNumber") String username, @RequestParam("adminPassword") String password, HttpSession session) {
        if (username == null || password == null)
            return ResultVo.fail(ErrorMsg.PARAM_ERROR);
        Admin loginAdmin = adminService.login(username, password);
        session.setAttribute("admin", loginAdmin);
        return ResultVo.success(loginAdmin);
    }

    @GetMapping("idleList")
    public ResultVo getIdleList(@RequestParam("status") Integer status,
                                @RequestParam("page") Integer page,
                                @RequestParam("nums") Integer size,
                                HttpSession session){
        if (session.getAttribute("admin") == null)
            return ResultVo.fail(ErrorMsg.USER_NOT_LOGIN);
        if (status == null || status < 0) status = 0;
        if (page == null || page < 0) page = 1;
        if (size == null || size < 0) size = 8;
        return ResultVo.success(idleItemService.getIdleItemListByStatus(status, page, size));
    }

}
