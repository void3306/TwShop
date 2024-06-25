package com.api.service.impl;

import com.api.mapper.TypeMapper;
import com.api.model.entity.Type;
import com.api.model.vo.PageVo;
import com.api.service.TypeService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class TypeServiceImpl implements TypeService {

        @Resource
        private TypeMapper typeMapper;

        public PageVo<Type> getTypeListByPage(int begin, int size) {
                QueryWrapper<Type> wrapper = new QueryWrapper<>();
                wrapper.last("limit " + begin + "," + size);
                return new PageVo<>(typeMapper.selectList(wrapper),typeMapper.selectCount(null));
        }
}
