package com.api.controller;

import com.api.common.enums.ErrorMsg;
import com.api.model.vo.ResultVo;
import com.api.service.MessageService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@CrossOrigin
@RestController
@RequestMapping("message")
public class MessageController {

    @Resource
    private MessageService messageService;

    @GetMapping("me")
    public ResultVo getMyMyMessage(@CookieValue("shUserId") Long userId){
        if (userId == null)
            return ResultVo.fail(ErrorMsg.USER_NOT_LOGIN);
        return ResultVo.success(messageService.getMyMessage(userId));
    }

}
