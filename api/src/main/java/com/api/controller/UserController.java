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
import java.sql.Timestamp;
import java.util.Objects;

@CrossOrigin
@RestController
@RequestMapping("user")
public class UserController {

    @Resource
    private UserService userService;

    @GetMapping("/list")
    public String  userList(){
        User user = userService.getUser(11L);
        return user.toString();
    }


    @GetMapping("/login")
    public ResultVo login(@RequestParam("accountNumber") String username,
                          @RequestParam("userPassword") String password,
                          @RequestParam("code") String code,
                          @RequestParam("token") String token,
                          HttpServletResponse response){
        User loginUser = userService.login(username, password);
        if (loginUser == null)
            return ResultVo.fail(ErrorMsg.USERNAME_OR_PASSWORD_ERROR);
        if (!code.equals(UserSessionUtil.getCode(token)))
            return ResultVo.fail(ErrorMsg.CODE_ERROR);
        Cookie cookie = new Cookie("shUserId",String.valueOf(loginUser.getId()));

        cookie.setPath("/");
        cookie.setHttpOnly(false);
        response.addCookie(cookie);

        return ResultVo.success(loginUser);
    }

    @PostMapping("sign-in")
    public ResultVo signIn(@RequestBody  User user) {
        System.out.println(user);
        user.setSignInTime(new Timestamp(System.currentTimeMillis()));
        if (user.getAvatar() == null || "".equals(user.getAvatar())) {
            user.setAvatar("/image?imageName=noasndo123.jpg");
        }
        if (user.getAccountNumber() == null || user.getUserPassword() == null || user.getNickname() == null )
            return ResultVo.fail(ErrorMsg.PARAM_ERROR);
        if (userService.add(user)) {
            return ResultVo.success(user);
        }
        return ResultVo.fail(ErrorMsg.REGISTER_ERROR);
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

    @PostMapping("/info")
    public ResultVo updateUserInfo(@CookieValue("shUserId")Long shUserId, @RequestBody User user){
        user.setId(shUserId);
        if (userService.update(user)) {
            return ResultVo.success();
        }
        return ResultVo.fail(ErrorMsg.SYSTEM_ERROR);
    }

    @GetMapping("/password")
    public ResultVo updatePassword(@CookieValue("shUserId")Long shUserId,
                                   @RequestParam("oldPassword")String oldPassword,
                                   @RequestParam("newPassword")String newPassword){
        if (oldPassword == null || newPassword == null)
            return ResultVo.fail(ErrorMsg.PARAM_ERROR);
        if (Objects.equals(oldPassword, newPassword))
            return ResultVo.fail(ErrorMsg.PASSWORD_SAME);
        if (userService.updatePassword(newPassword, oldPassword, shUserId)) {
            return ResultVo.success();
        }
        return ResultVo.fail(ErrorMsg.PASSWORD_RESET_ERROR);
    }





}
