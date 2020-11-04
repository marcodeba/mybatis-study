package com.mybatis.demo.mybatisstudy.service;

import com.mybatis.demo.mybatisstudy.mapper.MybatisMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MybatisService {
    @Autowired
    private MybatisMapper mybatisMapper;

    public void query() {
        mybatisMapper.query();
    }
}
