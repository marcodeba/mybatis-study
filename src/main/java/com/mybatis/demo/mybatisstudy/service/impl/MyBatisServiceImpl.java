package com.mybatis.demo.mybatisstudy.service.impl;

import com.mybatis.demo.mybatisstudy.mapper.MyBatisMapper;
import com.mybatis.demo.mybatisstudy.service.MyBatisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author marco pan
 * @ClassName MyBatisServiceImpl
 * @Description
 * @date 2021年10月01日 10:26 上午
 */
@Service
public class MyBatisServiceImpl implements MyBatisService {
    private MyBatisMapper myBatisMapper;

    @Autowired
    public void setMyBatisMapper(MyBatisMapper myBatisMapper) {
        this.myBatisMapper = myBatisMapper;
    }

    @Override
    public String queryDataFromDB() {
        return myBatisMapper.query();
    }
}
