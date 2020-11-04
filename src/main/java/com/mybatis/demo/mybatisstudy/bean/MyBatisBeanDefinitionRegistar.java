package com.mybatis.demo.mybatisstudy.bean;

import com.mybatis.demo.mybatisstudy.mapper.MybatisMapper;
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
        mapperList.add(UserMapper.class);
        mapperList.add(MybatisMapper.class);

        for (Class mapper : mapperList) {
            AbstractBeanDefinition beanDefinition = BeanDefinitionBuilder.genericBeanDefinition().getBeanDefinition();
            beanDefinition.setBeanClass(MybatisFactoryBean.class);
            beanDefinition.getConstructorArgumentValues().addGenericArgumentValue(mapper);

            registry.registerBeanDefinition(mapper.getName(), beanDefinition);
        }
    }
}
