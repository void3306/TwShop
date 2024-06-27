package com.api.controller;

import com.api.common.enums.ErrorMsg;
import com.api.common.utils.IdFactoryUtil;
import com.api.common.utils.OrderTaskHandler;
import com.api.model.dto.OrderDto;
import com.api.model.entity.Order;
import com.api.model.vo.ResultVo;
import com.api.service.OrderService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;
import java.util.Objects;

@CrossOrigin
@RestController
@RequestMapping("/order")
public class OrderController {

    @Resource
    private OrderService orderService;

    @GetMapping("my")
    public ResultVo getMyOrder(@CookieValue("shUserId") Long userId){
        if (userId == null)
            return ResultVo.fail(ErrorMsg.USER_NOT_LOGIN);
        return ResultVo.success(orderService.getMyOrder(userId));
    }

    @GetMapping("my-sold")
    public ResultVo getMySoldOrder(@CookieValue("shUserId") Long userId){
        if (userId == null)
            return ResultVo.fail(ErrorMsg.USER_NOT_LOGIN);
        return ResultVo.success(orderService.getMySoldOrder(userId));
    }

    @GetMapping("info")
    public ResultVo getOrderInfo(@CookieValue("shUserId") Long userId, @RequestParam Long id){
        if (userId == null)
            return ResultVo.fail(ErrorMsg.USER_NOT_LOGIN);
        OrderDto orderDto = orderService.getOrderById(id);
        if (Objects.equals(orderDto.getUserId(), userId))
            return ResultVo.success(orderDto);
        else
            return ResultVo.fail(ErrorMsg.NO_ACCESS);
    }

    @PostMapping("add")
    public ResultVo addOrder(@CookieValue("shUserId") Long userId, @RequestBody Order order){
        if (userId == null)
            return ResultVo.fail(ErrorMsg.USER_NOT_LOGIN);
        if(OrderTaskHandler.orderService==null)
            OrderTaskHandler.orderService=orderService;
        order.setOrderNumber(IdFactoryUtil.getOrderId());
        order.setCreateTime(new Date());
        order.setUserId(Long.valueOf(userId));
        order.setOrderStatus((byte) 0);
        order.setPaymentStatus((byte)0);
        order.setUserId(userId);
        if (orderService.add(order))
            return ResultVo.success(order);
        else
            return ResultVo.fail(ErrorMsg.SYSTEM_ERROR);
    }

    @PostMapping("update")
    public ResultVo updateOrder(@CookieValue("shUserId") Long userId, @RequestBody Order order){
        if (userId == null)
            return ResultVo.fail(ErrorMsg.USER_NOT_LOGIN);
        order.setUserId(userId);
        if(order.getPaymentStatus()!=null&&order.getPaymentStatus().equals((byte) 1))
            order.setPaymentTime(new Date());

        if (orderService.update(order))
            return ResultVo.success(order);
        else
            return ResultVo.fail(ErrorMsg.SYSTEM_ERROR);
    }
}
