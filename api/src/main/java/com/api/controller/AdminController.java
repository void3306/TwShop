package com.api.controller;

import com.api.common.enums.ErrorMsg;
import com.api.model.entity.Admin;
import com.api.model.vo.ResultVo;
import com.api.service.AdminService;
import com.api.service.IdleItemService;
import com.api.service.OrderService;
import com.api.service.UserService;
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

    @Resource
    private OrderService orderService;

    @Resource
    private UserService userService;

    @GetMapping("login")
    public ResultVo login(@RequestParam("accountNumber") String username, @RequestParam("adminPassword") String password, HttpSession session) {
        if (username == null || password == null)
            return ResultVo.fail(ErrorMsg.PARAM_ERROR);
        Admin loginAdmin = adminService.login(username, password);
        session.setAttribute("admin", loginAdmin);
        return ResultVo.success(loginAdmin);
    }

    @GetMapping("logOut")
    public ResultVo logout(HttpSession session) {
        session.removeAttribute("admin");
        return ResultVo.success();
    }

    @GetMapping("list")
    public ResultVo getAdminList(@RequestParam("page") Integer page,
                                 @RequestParam("nums") Integer size,
                                 HttpSession session){
        if (session.getAttribute("admin") == null)
            return ResultVo.fail(ErrorMsg.USER_NOT_LOGIN);
        if (page == null || page < 0) page = 1;
        if (size == null || size < 0) size = 8;
        return ResultVo.success(adminService.getAdminList(page, size));
    }

    @PostMapping("add")
    public ResultVo addAdmin(@RequestBody Admin admin, HttpSession session){
        if (session.getAttribute("admin") == null)
            return ResultVo.fail(ErrorMsg.USER_NOT_LOGIN);
        if (admin == null || admin.getAccountNumber() == null || admin.getAdminPassword() == null || admin.getAdminName() == null)
            return ResultVo.fail(ErrorMsg.PARAM_ERROR);
        return ResultVo.success(adminService.add(admin));
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

    @GetMapping("updateIdleStatus")
    public ResultVo updateIdleStatus(@RequestParam("id") Long idleId,
                                     @RequestParam("status") Byte status,
                                     HttpSession session){
        if (session.getAttribute("admin") == null)
            return ResultVo.fail(ErrorMsg.USER_NOT_LOGIN);
        if (idleId == null || idleId < 0 || status == null || status < 0)
            return ResultVo.fail(ErrorMsg.PARAM_ERROR);
        return ResultVo.success(idleItemService.updateIdleStatus(idleId, status));
    }

    @GetMapping("orderList")
    public ResultVo getOrderList(@RequestParam("page") Integer page, @RequestParam("nums") Integer size, HttpSession session){
        if (session.getAttribute("admin") == null)
            return ResultVo.fail(ErrorMsg.USER_NOT_LOGIN);
        if (page == null || page < 0) page = 1;
        if (size == null || size < 0) size = 8;
        return ResultVo.success(orderService.getOrderList(page, size));
    }

    @GetMapping("deleteOrder")
    public ResultVo deleteOrder(@RequestParam("id") Long orderId, HttpSession session){
        if (session.getAttribute("admin") == null)
            return ResultVo.fail(ErrorMsg.USER_NOT_LOGIN);
        if (orderId == null || orderId < 0)
            return ResultVo.fail(ErrorMsg.PARAM_ERROR);
        return ResultVo.success(orderService.deleteOrder(orderId));
    }

    @GetMapping("userList")
    public ResultVo getUserList(@RequestParam("page") Integer page, @RequestParam("nums") Integer size,@RequestParam("status")Integer status, HttpSession session){
        if (session.getAttribute("admin") == null)
            return ResultVo.fail(ErrorMsg.USER_NOT_LOGIN);
        if (status == null || status < 0) status = 0;
        if (page == null || page < 0) page = 1;
        if (size == null || size < 0) size = 8;
        return ResultVo.success(userService.getUserListByStatus(status, page, size));
    }

    @GetMapping("updateUserStatus")
    public ResultVo updateUserStatus(@RequestParam("id") Long userId, @RequestParam("status") Byte status, HttpSession session){
        if (session.getAttribute("admin") == null)
            return ResultVo.fail(ErrorMsg.USER_NOT_LOGIN);
        if (userId == null || userId < 0 || status == null || status < 0)
            return ResultVo.fail(ErrorMsg.PARAM_ERROR);
        return ResultVo.success(userService.updateUserStatus(userId, status));
    }


}
