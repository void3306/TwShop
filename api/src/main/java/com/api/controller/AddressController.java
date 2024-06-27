package com.api.controller;

import com.api.common.enums.ErrorMsg;
import com.api.model.entity.Address;
import com.api.model.vo.ResultVo;
import com.api.service.AddressService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@CrossOrigin
@RestController
@RequestMapping("/address")
public class AddressController {

    @Resource
    private AddressService addressService;

    @GetMapping("info")
    public ResultVo getAddress(@CookieValue("shUserId") Long shUserId, @RequestParam(value = "id",required = false) Long id){
        if (shUserId == null)
            return ResultVo.fail(ErrorMsg.USER_NOT_LOGIN);
        return id==null ? ResultVo.success(addressService.getAddressByUid(shUserId)) : ResultVo.success(addressService.getAddressById(id, shUserId));
    }

    @PostMapping("add")
    public ResultVo addAddress(@CookieValue("shUserId") Long shUserId, @RequestBody Address address){
        if (shUserId == null)
            return ResultVo.fail(ErrorMsg.USER_NOT_LOGIN);
        address.setUserId(shUserId);
        return ResultVo.success(addressService.add(address));
    }

    @PostMapping("update")
    public ResultVo updateAddress(@CookieValue("shUserId") Long shUserId, @RequestBody Address address){
        if (shUserId == null)
            return ResultVo.fail(ErrorMsg.USER_NOT_LOGIN);
        address.setUserId(shUserId);
        return ResultVo.success(addressService.update(address));
    }

    @PostMapping("delete")
    public ResultVo deleteAddress(@CookieValue("shUserId") Long shUserId, @RequestBody Address address){
        if (shUserId == null)
            return ResultVo.fail(ErrorMsg.USER_NOT_LOGIN);
        address.setUserId(shUserId);
        return ResultVo.success(addressService.delete(address));
    }

}
