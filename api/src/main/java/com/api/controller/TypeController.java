package com.api.controller;

import com.api.model.vo.ResultVo;
import com.api.service.TypeService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@CrossOrigin
@RestController
@RequestMapping("type")
public class TypeController {

    @Resource
    private TypeService typeService;

    @RequestMapping("/listByCondition")
    public ResultVo listByCondition(@RequestParam("begin") int begin, @RequestParam("size") int size) {
        return ResultVo.success(typeService.getTypeListByPage(begin, size).getList());
    }

}
