package com.api.service;

import com.api.model.entity.Type;

import java.util.List;

public interface TypeService {
    List<Type> getTypeListByCondition(int begin, int size);
}
