package com.api.controller;

import com.api.common.enums.ErrorMsg;
import com.api.model.entity.User;
import com.api.model.vo.ResultVo;
import com.api.service.UserService;
import com.api.session.UserSessionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@CrossOrigin
@RestController
@RequestMapping("user")
public class UserController {

    @Resource
    private UserService userService;
    @Resource
    private UserSessionUtil userSessionUtil;

    @GetMapping("/list")
    public String  userList(){
        User user = userService.getUser(11L);
        return user.toString();
    }


    @GetMapping("/login")
    public ResultVo login(@RequestParam("accountNumber") String username, @RequestParam("userPassword") String password, @RequestParam("code") String code, @RequestParam("token") String token, HttpServletResponse response){
        User loginUser = userService.login(username, password);
        if (loginUser == null)
            return ResultVo.fail(ErrorMsg.USERNAME_OR_PASSWORD_ERROR);
        if (!code.equals(userSessionUtil.getCode(token)))
            return ResultVo.fail(ErrorMsg.CODE_ERROR);
        Cookie cookie = new Cookie("shUserId",String.valueOf(loginUser.getId()));

        cookie.setPath("/");
        cookie.setHttpOnly(false);
        response.addCookie(cookie);

        return ResultVo.success(loginUser);
    }

    @GetMapping("/logout")
    public ResultVo logout(@CookieValue("shUserId")String shUserId, HttpServletResponse response){
        Cookie cookie = new Cookie("shUserId",null);
        cookie.setPath("/");
        cookie.setMaxAge(0);
        cookie.setHttpOnly(true);
        response.addCookie(cookie);

        return ResultVo.success();
    }

    @GetMapping("/info")
    public ResultVo getUserInfo(@CookieValue("shUserId")String shUserId){
        User user = userService.getUser(Long.valueOf(shUserId));
        user.setUserPassword(null);
        return ResultVo.success(user);
    }



}
