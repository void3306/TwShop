package com.api.controller;

import com.api.common.enums.ErrorMsg;
import com.api.model.entity.IdleItem;
import com.api.model.vo.ResultVo;
import com.api.service.IdleItemService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@CrossOrigin
@RestController
@RequestMapping("idle")
public class IdleItemController {

    @Resource
    private IdleItemService idleItemService;

    @RequestMapping("/find")
    public ResultVo findByPage(@RequestParam(value = "findValue",required = false) String findValue,
                               @RequestParam(value = "page",required = false) Integer page,
                               @RequestParam(value = "nums",required = false) Integer size) {
        if (findValue == null) findValue = "";
        if (page == null || page < 0) page = 1;
        if (size == null || size < 0) size = 8;

        return ResultVo.success(idleItemService.getIdleItemByPage(findValue, page, size));
    }

    @RequestMapping("/label")
    public ResultVo findByLabel(@RequestParam(value = "idleLabel",required = false) Integer label,
                                @RequestParam(value = "page",required = false) Integer page,
                                @RequestParam(value = "nums",required = false) Integer size) {
        if (label == null || label < 0) label = 0;
        if (page == null || page < 0) page = 1;
        if (size == null || size < 0) size = 8;

        return ResultVo.success(idleItemService.getIdleItemByLabel(label, page, size));
    }

    @PostMapping("/add")
    public ResultVo addIdleItem(@RequestBody IdleItem idleItem, HttpServletRequest request){
        for (Cookie cookie : request.getCookies()) {
            if (cookie.getName().equals("shUserId")) {
                idleItem.setUserId(Long.parseLong(cookie.getValue()));
                break;
            }
        }

        if (idleItem.getUserId() == null) return ResultVo.fail(ErrorMsg.USER_NOT_LOGIN);

        if (idleItem.getIdleName() == null ||
            idleItem.getIdlePrice() == null ||
            idleItem.getIdleLabel() == null ||
            idleItem.getIdlePlace() == null
        ) return ResultVo.fail(ErrorMsg.MISSING_PARAMETER);

        idleItem.setReleaseTime(new Date(System.currentTimeMillis()));
        idleItem.setIdleStatus((byte) 1);

        return ResultVo.success(idleItemService.addIdleItem(idleItem));
    }

}
