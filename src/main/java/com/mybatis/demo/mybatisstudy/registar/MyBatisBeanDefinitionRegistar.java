package com.mybatis.demo.mybatisstudy.registar;

import com.mybatis.demo.mybatisstudy.annotation.MyBatisMapperScan;
import com.mybatis.demo.mybatisstudy.scanner.MyBatisBeanDefinitionScanner;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanNameGenerator;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

import java.util.Map;

public class MyBatisBeanDefinitionRegistar implements ImportBeanDefinitionRegistrar {
    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry, BeanNameGenerator importBeanNameGenerator) {
        Map<String, Object> annotationAttributes = importingClassMetadata.getAnnotationAttributes(MyBatisMapperScan.class.getName());
        System.out.println(annotationAttributes);
        String path = (String) annotationAttributes.get("value");

        MyBatisBeanDefinitionScanner scanner = new MyBatisBeanDefinitionScanner(registry);
        scanner.addIncludeFilter((metadataReader, metadataReaderFactory) -> true);
        scanner.scan(path);

//        List<Class> mapperList = new ArrayList<>();
//        mapperList.add(MyBatisMapper.class);
//        mapperList.add(UserMapper.class);
//
//        // 把MyBatis生成的Mapper代理对象放到IOC容器中
//        for (Class mapper : mapperList) {
//            AbstractBeanDefinition beanDefinition = BeanDefinitionBuilder.genericBeanDefinition().getBeanDefinition();
//            beanDefinition.setBeanClass(MyBatisFactoryBean.class);
//            // 添加构造方法参数
//            beanDefinition.getConstructorArgumentValues().addGenericArgumentValue(mapper);
//            registry.registerBeanDefinition(mapper.getName(), beanDefinition);
//        }
    }
}
