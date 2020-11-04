package com.mybatis.demo.mybatisstudy.mapper;

import org.apache.ibatis.annotations.Select;

public interface MybatisMapper {
    @Select("select * from XXXXX")
    void query();
}
