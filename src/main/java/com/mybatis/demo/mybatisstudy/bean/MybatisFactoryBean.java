package com.mybatis.demo.mybatisstudy.bean;

import com.mybatis.demo.mybatisstudy.handler.MapperHandler;
import org.springframework.beans.factory.FactoryBean;

import java.lang.reflect.Proxy;

public class MybatisFactoryBean implements FactoryBean {
    private Class mapperInterface;

    public MybatisFactoryBean(Class mapperInterface) {
        this.mapperInterface = mapperInterface;
    }

    @Override
    public Object getObject() {
        return Proxy.newProxyInstance(MybatisFactoryBean.class.getClassLoader(), new Class[]{mapperInterface}, new MapperHandler());
    }

    @Override
    public Class<?> getObjectType() {
        return mapperInterface;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
