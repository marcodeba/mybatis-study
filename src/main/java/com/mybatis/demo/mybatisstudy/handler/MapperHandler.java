package com.mybatis.demo.mybatisstudy.handler;

import org.apache.ibatis.annotations.Select;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MapperHandler implements InvocationHandler {
    private Logger logger = LoggerFactory.getLogger(MapperHandler.class);

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) {
        logger.info("connect DB");
        logger.info(method.getName());
        Select annotation = method.getAnnotation(Select.class);
        logger.info(annotation.value()[0]);
        return null;
    }
}
