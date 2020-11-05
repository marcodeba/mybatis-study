package com.mybatis.demo.mybatisstudy;

import com.mybatis.demo.mybatisstudy.bean.MyBatisBeanDefinitionRegistar;
import com.mybatis.demo.mybatisstudy.mapper.UserMapper;
import com.mybatis.demo.mybatisstudy.service.MybatisService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

import javax.annotation.Resource;

@SpringBootTest
@Import(MyBatisBeanDefinitionRegistar.class)
//@MapperScan("com.mybatis.demo.mybatisstudy.mapper")
class MybatisStudyApplicationTests {
    @Resource
    private MybatisService mybatisService;
    @Resource
    private UserMapper userMapper;

//    @PostConstruct
//    void init() {
//        userMapper = (UserMapper) UserMapperFactory.getInstance(UserMapper.class);
//    }

    @Test
    void testMybatis() {
        mybatisService.query();
        userMapper.queryUsers();
    }
}
