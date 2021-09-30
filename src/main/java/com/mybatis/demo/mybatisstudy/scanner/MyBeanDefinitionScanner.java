package com.mybatis.demo.mybatisstudy.scanner;

import com.mybatis.demo.mybatisstudy.bean.MyBatisFactoryBean;
import org.springframework.beans.factory.annotation.AnnotatedBeanDefinition;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanDefinitionHolder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;

import java.util.Set;

/**
 * @author marco pan
 * @ClassName MyBeanDefinitionScanner
 * @Description
 * @date 2021年10月01日 12:01 上午
 */
public class MyBeanDefinitionScanner extends ClassPathBeanDefinitionScanner {
    public MyBeanDefinitionScanner(BeanDefinitionRegistry registry) {
        super(registry);
    }

    /**
     * MyBatis扫描的mapper都是接口，所以要重写该方法，因为Spring默认的扫描器只扫描类
     * @param beanDefinition
     * @return
     */
    @Override
    protected boolean isCandidateComponent(AnnotatedBeanDefinition beanDefinition) {
        return beanDefinition.getMetadata().isInterface();
    }

    @Override
    protected Set<BeanDefinitionHolder> doScan(String... basePackages) {
        Set<BeanDefinitionHolder> beanDefinitionHolders = super.doScan(basePackages);

        beanDefinitionHolders.forEach(beanDefinitionHolder -> {
            BeanDefinition beanDefinition = beanDefinitionHolder.getBeanDefinition();
            beanDefinition.getConstructorArgumentValues().addGenericArgumentValue(beanDefinition.getBeanClassName());
            beanDefinition.setBeanClassName(MyBatisFactoryBean.class.getName());
        });
        return beanDefinitionHolders;
    }
}
