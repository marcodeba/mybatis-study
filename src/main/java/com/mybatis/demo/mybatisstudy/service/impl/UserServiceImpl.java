package com.mybatis.demo.mybatisstudy.service.impl;

import com.mybatis.demo.mybatisstudy.mapper.UserMapper;
import com.mybatis.demo.mybatisstudy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author marco pan
 * @ClassName UserServiceImpl
 * @Description
 * @date 2021年10月01日 10:23 上午
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public String createOrder() {
        return userMapper.queryUsers();
    }
}
