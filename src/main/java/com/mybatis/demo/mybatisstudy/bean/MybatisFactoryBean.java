package com.mybatis.demo.mybatisstudy.bean;

import com.mybatis.demo.mybatisstudy.mapper.MybatisMapper;
import com.mybatis.demo.mybatisstudy.util.Tools;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

@Component
public class MybatisFactoryBean implements FactoryBean {
    @Override
    public Object getObject() {
        Tools.generateSourceCode(MybatisFactoryBean.class);

        Object proxyMapper = Proxy.newProxyInstance(MybatisFactoryBean.class.getClassLoader(), new Class[]{MybatisMapper.class}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println(method.getName());
                Select annotation = method.getAnnotation(Select.class);
                System.out.println(annotation.value()[0]);
                return null;
            }
        });
        return proxyMapper;
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
