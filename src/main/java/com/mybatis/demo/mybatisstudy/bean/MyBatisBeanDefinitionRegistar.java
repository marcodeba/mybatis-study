package com.mybatis.demo.mybatisstudy.bean;

import com.mybatis.demo.mybatisstudy.mapper.MyBatisMapper;
import com.mybatis.demo.mybatisstudy.mapper.UserMapper;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanNameGenerator;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

import java.util.ArrayList;
import java.util.List;

public class MyBatisBeanDefinitionRegistar implements ImportBeanDefinitionRegistrar {
    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry, BeanNameGenerator importBeanNameGenerator) {
        List<Class> mapperList = new ArrayList<>();
        mapperList.add(MyBatisMapper.class);
        mapperList.add(UserMapper.class);

        // 把MyBatis生成的Mapper代理对象放到IOC容器中
        for (Class mapper : mapperList) {
            AbstractBeanDefinition beanDefinition = BeanDefinitionBuilder.genericBeanDefinition().getBeanDefinition();
            // 将 MybatisFactoryBean 放入 IOC 容器
            beanDefinition.setBeanClass(MyBatisFactoryBean.class);
            // 添加构造方法参数
            beanDefinition.getConstructorArgumentValues().addGenericArgumentValue(mapper);

            registry.registerBeanDefinition(mapper.getName(), beanDefinition);
        }
    }
}
