package com.message.util;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;


public class DBMybatisUtil {

	
	public SqlSession getSqlSession() throws IOException {
		// 通过配置文件获取数据库连接信息
		Reader reader;
		//reader = Resources.getResourceAsReader("com/message/config/Configuration.xml");
		//reader = Resources.getResourceAsReader("src/main/resources/Configuration.xml");
		
		//在Maven中读取Mybatis路径地址
		ClassLoader classloader = Thread.currentThread().getContextClassLoader();
		//InputStream is = classloader.getResourceAsStream("Configuration.xml");
		reader = Resources.getResourceAsReader(classloader, "mybatis/Configuration.xml");
		
		// 通过配置信息构建一个SqlSessionFactory
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
		// 通过SqlSessionFactory打开一个数据库会话
		SqlSession sqlSession = sqlSessionFactory.openSession();
		return sqlSession;
	}
}
