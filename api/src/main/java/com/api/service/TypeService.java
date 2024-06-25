package com.api.service;

import com.api.model.entity.Type;
import com.api.model.vo.PageVo;

import java.util.List;

public interface TypeService {
    PageVo<Type> getTypeListByPage(int begin, int size);
}
