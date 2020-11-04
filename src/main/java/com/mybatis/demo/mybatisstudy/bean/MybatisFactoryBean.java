package com.mybatis.demo.mybatisstudy.bean;

import com.mybatis.demo.mybatisstudy.mapper.MybatisMapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;
import sun.misc.ProxyGenerator;

import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

@Component
public class MybatisFactoryBean implements FactoryBean {
    @Override
    public Object getObject() {
        generateSourceCode(MybatisFactoryBean.class);

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

    public static void generateSourceCode(Class clazz) {
        byte[] bytes = ProxyGenerator.generateProxyClass("$Proxy0", new Class[]{clazz});
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(clazz.getResource("").getPath() + "/$Proxy0.class");
            fos.write(bytes);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (fos != null) {
                    fos.close();
                    fos = null;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
