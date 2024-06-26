package com.api.controller;

import com.api.common.enums.ErrorMsg;
import com.api.model.entity.IdleItem;
import com.api.model.vo.ResultVo;
import com.api.service.IdleItemService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
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

        return ResultVo.success(idleItemService.getIdleItemListByFindValue(findValue, page, size));
    }

    @RequestMapping("/label")
    public ResultVo findByLabel(@RequestParam(value = "idleLabel",required = false) Integer label,
                                @RequestParam(value = "page",required = false) Integer page,
                                @RequestParam(value = "nums",required = false) Integer size) {
        if (label == null || label < 0) label = 0;
        if (page == null || page < 0) page = 1;
        if (size == null || size < 0) size = 8;

        return ResultVo.success(idleItemService.getIdleItemListByLabel(label, page, size));
    }

    @PostMapping("/add")
    public ResultVo addIdleItem(@RequestBody IdleItem idleItem,@CookieValue("shUserId")String shUserId){
        if (shUserId == null)
            return ResultVo.fail(ErrorMsg.USER_NOT_LOGIN);

        if (idleItem.getIdleName() == null || idleItem.getIdlePrice() == null || idleItem.getIdleLabel() == null || idleItem.getIdlePlace() == null || idleItem.getPictureList() == null)
            return ResultVo.fail(ErrorMsg.MISSING_PARAMETER);

        idleItem.setUserId(Long.parseLong(shUserId));
        idleItem.setReleaseTime(new Date(System.currentTimeMillis()));
        idleItem.setIdleStatus((byte) 1);

        return ResultVo.success(idleItemService.addIdleItem(idleItem));
    }

    @RequestMapping("/info")
    public ResultVo getIdleItemInfo(@RequestParam("idleId") Long idleId){
        if (idleId == null || idleId < 0) return ResultVo.fail(ErrorMsg.PARAM_ERROR);
        return ResultVo.success(idleItemService.getIdleItemInfo(idleId));
    }

}
