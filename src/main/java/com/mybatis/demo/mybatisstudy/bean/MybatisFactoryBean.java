package com.mybatis.demo.mybatisstudy.bean;

import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.FactoryBean;

import java.lang.reflect.Proxy;

public class MybatisFactoryBean implements FactoryBean {
    private Class mapperInterface;

    public MybatisFactoryBean(Class mapperInterface) {
        this.mapperInterface = mapperInterface;
    }

    @Override
    public Object getObject() {
        return Proxy.newProxyInstance(MybatisFactoryBean.class.getClassLoader(), new Class[]{mapperInterface}, (proxy, method, args) -> {
            System.out.println(method.getName());
            Select annotation = method.getAnnotation(Select.class);
            System.out.println(annotation.value()[0]);
            return null;
        });
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
