package com.mybatis.demo.mybatisstudy.bean;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.annotation.Autowired;

public class MyBatisFactoryBean implements FactoryBean {

    private Class mapperInterface;
    private SqlSession sqlSession;

    public MyBatisFactoryBean(Class mapperInterface) {
        this.mapperInterface = mapperInterface;
    }

    @Autowired
    public void setSqlSession(SqlSessionFactory sqlSessionFactory) {
        sqlSessionFactory.getConfiguration().addMapper(mapperInterface);
        this.sqlSession = sqlSessionFactory.openSession();
    }

    @Override
    public Object getObject() {
        return sqlSession.getMapper(mapperInterface);
        //return Proxy.newProxyInstance(getClass().getClassLoader(), new Class[]{mapperInterface}, new MapperHandler());
    }

    @Override
    public Class<?> getObjectType() {
        return mapperInterface;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
