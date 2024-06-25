package com.api.service;

import com.api.model.dto.IdleItemDto;
import com.api.model.entity.IdleItem;
import com.api.model.vo.PageVo;

public interface IdleItemService {
    PageVo<IdleItemDto> getIdleItemByPage(String findValue, Integer page, Integer size);

    PageVo<IdleItemDto> getIdleItemByLabel(Integer label, Integer page, Integer size);

    int addIdleItem(IdleItem idleItem);
}
