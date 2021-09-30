package com.mybatis.demo.mybatisstudy;

import com.mybatis.demo.mybatisstudy.mapper.MyBatisMapper;
import com.mybatis.demo.mybatisstudy.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class MybatisStudyApplicationTests {

    @Resource
    private UserMapper userMapper;

    @Resource
    private MyBatisMapper mybatisMapper;

    @Test
    void testMybatis() {
        System.out.println(mybatisMapper.query());
        System.out.println(userMapper.queryUsers());
    }
}
