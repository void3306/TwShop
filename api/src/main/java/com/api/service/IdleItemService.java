package com.api.service;

import com.api.model.dto.IdleItemDto;
import com.api.model.entity.IdleItem;
import com.api.model.vo.PageVo;

public interface IdleItemService {
    PageVo<IdleItemDto> getIdleItemListByFindValue(String findValue, Integer page, Integer size);

    PageVo<IdleItemDto> getIdleItemListByLabel(Integer label, Integer page, Integer size);

    PageVo<IdleItemDto> getIdleItemListByStatus(Integer status, Integer page, Integer size);

    int addIdleItem(IdleItem idleItem);

    IdleItemDto getIdleItemInfo(Long idleId);

}
