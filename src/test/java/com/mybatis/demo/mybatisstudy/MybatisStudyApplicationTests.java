package com.mybatis.demo.mybatisstudy;

import com.mybatis.demo.mybatisstudy.mapper.UserMapper;
import com.mybatis.demo.mybatisstudy.service.MybatisService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class MybatisStudyApplicationTests {

    @Resource
    private MybatisService mybatisService;

    @Resource
    private UserMapper userMapper;

    @Test
    void testMybatis() {
        mybatisService.query();
        userMapper.queryUsers();
    }
}
