package com.mybatis.demo.mybatisstudy.mapper;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

@Component
public interface MyBatisMapper {
    @Select("select 'mybatis'")
    String query();
}
