package com.api.controller;

import com.api.common.enums.ErrorMsg;
import com.api.model.entity.OrderAddress;
import com.api.model.vo.ResultVo;
import com.api.service.OrderAddressService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@CrossOrigin
@RequestMapping("/order-address")
public class OrderAddressController {

    @Resource
    private OrderAddressService orderAddressService;

    @PostMapping("/add")
    public ResultVo addOrderAddress(@CookieValue("shUserId") Long uid,
                                    @RequestBody OrderAddress orderAddressModel) {
        return ResultVo.success(orderAddressService.add(orderAddressModel));
    }

    @PostMapping("/update")
    public ResultVo updateOrderAddress(@CookieValue("shUserId") Long uid,
                                       @RequestBody OrderAddress orderAddressModel) {
        if (orderAddressService.update(orderAddressModel)) {
            return ResultVo.success(orderAddressModel);
        }
        return ResultVo.fail(ErrorMsg.SYSTEM_ERROR);
    }

    @GetMapping("/info")
    public ResultVo getOrderAddress(@CookieValue("shUserId") Long uid,
                                    @RequestParam Long orderId) {
        return ResultVo.success(orderAddressService.get(orderId));
    }
}
