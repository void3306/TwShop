package com.api.service;

import com.api.model.dto.IdleItemDto;
import com.api.model.entity.IdleItem;
import com.api.model.vo.PageVo;

import java.util.List;

public interface IdleItemService {
    PageVo<IdleItemDto> getIdleItemListByFindValue(String findValue, Integer page, Integer size);

    PageVo<IdleItemDto> getIdleItemListByLabel(Integer label, Integer page, Integer size);

    PageVo<IdleItemDto> getIdleItemListByStatus(Integer status, Integer page, Integer size);

    int addIdleItem(IdleItem idleItem);

    IdleItemDto getIdleItemInfo(Long idleId);

    int updateIdleStatus(Long idleId, Byte status);

    List<IdleItemDto> getAllIdleItemByUid(Long shUserId);

    boolean updateIdleItem(IdleItem idleItem);
}
