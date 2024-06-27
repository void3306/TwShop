package com.api.controller;

import com.api.common.enums.ErrorMsg;
import com.api.model.entity.Message;
import com.api.model.vo.ResultVo;
import com.api.service.MessageService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;

@CrossOrigin
@RestController
@RequestMapping("message")
public class MessageController {

    @Resource
    private MessageService messageService;

    @GetMapping("my")
    public ResultVo getMyMyMessage(@CookieValue("shUserId") Long userId){
        if (userId == null)
            return ResultVo.fail(ErrorMsg.USER_NOT_LOGIN);
        return ResultVo.success(messageService.getMyMessage(userId));
    }

    @GetMapping("info")
    public ResultVo getMessage(@RequestParam Long id){
        return ResultVo.success(messageService.getMessage(id));
    }

    @PostMapping("send")
    public ResultVo sendMessage(@CookieValue("shUserId") Long userId, @RequestBody Message message){
        if (userId == null)
            return ResultVo.fail(ErrorMsg.USER_NOT_LOGIN);
        message.setUserId(userId);
        message.setCreateTime(new Date(System.currentTimeMillis()));
        message.setToMessage(message.getToMessage() == null ? null : message.getToMessage());
        if (messageService.add(message))
            return ResultVo.success(message);
        return ResultVo.fail(ErrorMsg.SYSTEM_ERROR);
    }

    @GetMapping("idle")
    public ResultVo getAllIdleMessage(@RequestParam Long idleId){
        return ResultVo.success(messageService.getAllIdleMessage(idleId));
    }

    @GetMapping("delete")
    public ResultVo deleteMessage(@CookieValue("shUserId") Long userId, @RequestParam Long id){
        if (userId == null)
            return ResultVo.fail(ErrorMsg.USER_NOT_LOGIN);
        if (messageService.delete(id))
            return ResultVo.success();
        return ResultVo.fail(ErrorMsg.SYSTEM_ERROR);
    }



}
