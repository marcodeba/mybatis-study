package com.mybatis.demo.mybatisstudy.mapper;

import org.apache.ibatis.annotations.Select;

public interface UserMapper {
    @Select("select * from XXXXX")
    void queryUsers();
}
