package com.mybatis.demo.mybatisstudy.service;

import com.mybatis.demo.mybatisstudy.mapper.MyBatisMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class MybatisService {
    @Resource
    private MyBatisMapper mybatisMapper;

    public void query() {
        mybatisMapper.query();
    }
}
