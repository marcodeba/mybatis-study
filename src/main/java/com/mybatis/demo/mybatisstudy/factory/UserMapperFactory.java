package com.mybatis.demo.mybatisstudy.factory;

import com.mybatis.demo.mybatisstudy.util.Tools;
import org.apache.ibatis.annotations.Select;

import java.lang.reflect.Proxy;

public class UserMapperFactory {

    public static Object getInstance(Class clazz) {
        Tools.generateSourceCode(clazz);
        return Proxy.newProxyInstance(clazz.getClassLoader(), new Class[]{clazz}, (proxy, method, args) -> {
            System.out.println("connect DB");
            System.out.println(method.getName());
            Select annotation = method.getAnnotation(Select.class);
            System.out.println(annotation.value()[0]);
            return null;
        });
    }
}
