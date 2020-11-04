package com.mybatis.demo.mybatisstudy.bean;

import com.mybatis.demo.mybatisstudy.mapper.MybatisMapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

import java.lang.reflect.Proxy;

@Component
public class MybatisFactoryBean implements FactoryBean {
    @Override
    public Object getObject() {
        //Tools.generateSourceCode(MybatisFactoryBean.class);
        return Proxy.newProxyInstance(MybatisFactoryBean.class.getClassLoader(), new Class[]{MybatisMapper.class}, (proxy, method, args) -> {
            System.out.println(method.getName());
            Select annotation = method.getAnnotation(Select.class);
            System.out.println(annotation.value()[0]);
            return null;
        });
    }

    @Override
    public Class<?> getObjectType() {
        return MybatisMapper.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
