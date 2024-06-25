package com.api.controller;

import com.api.model.vo.ResultVo;
import com.api.service.IdleItemService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

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

}
