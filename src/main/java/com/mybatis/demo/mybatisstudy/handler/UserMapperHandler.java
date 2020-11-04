package com.mybatis.demo.mybatisstudy.handler;

import org.apache.ibatis.annotations.Select;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class UserMapperHandler implements InvocationHandler {
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) {
        System.out.println("connect DB");
        System.out.println(method.getName());
        Select annotation = method.getAnnotation(Select.class);
        System.out.println(annotation.value()[0]);
        return null;
    }
}
