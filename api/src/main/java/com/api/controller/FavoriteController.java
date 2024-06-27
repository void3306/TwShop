package com.api.controller;

import com.api.common.enums.ErrorMsg;
import com.api.model.entity.Favorite;
import com.api.model.vo.ResultVo;
import com.api.service.FavoriteService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;

@CrossOrigin
@RestController
@RequestMapping({"favorite"})
public class FavoriteController {

    @Resource
    private FavoriteService favoriteService;

    @GetMapping("my")
    public ResultVo getMyFavorite(@CookieValue("shUserId") Long userId){
        if (userId == null)
            return ResultVo.fail(ErrorMsg.USER_NOT_LOGIN);
        return ResultVo.success(favoriteService.getMyFavorite(userId));
    }

    @PostMapping("add")
    public ResultVo addFavorite(@CookieValue("shUserId") Long userId, @RequestBody Favorite favorite){
        favorite.setCreateTime(new Date(System.currentTimeMillis()));
        favorite.setUserId(userId);
        if(favoriteService.add(favorite)){
            return ResultVo.success(favorite.getId());
        }
        return ResultVo.fail(ErrorMsg.FAVORITE_EXIT);
    }

    @GetMapping("delete")
    public ResultVo deleteFavorite(@RequestParam Long id){
        if(favoriteService.delete(id)){
            return ResultVo.success();
        }
        return ResultVo.fail(ErrorMsg.SYSTEM_ERROR);
    }

    @GetMapping("check")
    public ResultVo checkFavorite(@CookieValue("shUserId") Long userId, @RequestParam Long idleId){
        return ResultVo.success(favoriteService.isFavorite(userId, idleId));
    }


}
