package com.mybatis.demo.mybatisstudy.factory;

import com.mybatis.demo.mybatisstudy.handler.MapperHandler;

import java.lang.reflect.Proxy;

public class UserMapperFactory {

    public static Object getInstance(Class clazz) {
        return Proxy.newProxyInstance(clazz.getClassLoader(), new Class[]{clazz}, new MapperHandler());
    }
}
