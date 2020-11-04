package com.mybatis.demo.mybatisstudy;

import com.mybatis.demo.mybatisstudy.factory.UserMapperFactory;
import com.mybatis.demo.mybatisstudy.mapper.UserMapper;
import com.mybatis.demo.mybatisstudy.service.MybatisService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.PostConstruct;

@SpringBootTest
class MybatisStudyApplicationTests {
    @Autowired
    private MybatisService mybatisService;

    private UserMapper userMapper;

    @PostConstruct
    void init() {
        userMapper = (UserMapper) UserMapperFactory.getInstance(UserMapper.class);
    }

    @Test
    void testMybatis() {
        mybatisService.query();
    }

    @Test
    void testUserMapper() {
        userMapper.queryUsers();
    }
}
