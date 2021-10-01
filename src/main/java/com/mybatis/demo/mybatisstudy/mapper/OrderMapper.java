package com.mybatis.demo.mybatisstudy.mapper;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

@Component
public interface OrderMapper {
    @Select("select 'order'")
    String query();
}
