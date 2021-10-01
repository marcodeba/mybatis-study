package com.mybatis.demo.mybatisstudy.mapper;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

@Component
public interface UserMapper {
    @Select("select 'user'")
    String queryUsers();
}
