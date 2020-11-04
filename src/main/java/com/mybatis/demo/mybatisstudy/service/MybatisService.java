package com.mybatis.demo.mybatisstudy.service;

import com.mybatis.demo.mybatisstudy.mapper.MybatisMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class MybatisService {
    @Resource
    private MybatisMapper mybatisMapper;

    public void query() {
        mybatisMapper.query();
    }
}
