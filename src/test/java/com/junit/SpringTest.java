package com.junit;

import static org.junit.Assert.*;

import java.util.Date;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sun.xml.internal.bind.CycleRecoverable.Context;

/**
 * 
 * Test测试Spring框架是否正常引入 
 * 
 */
public class SpringTest {

	private static ApplicationContext context = null;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
		context =  new ClassPathXmlApplicationContext("springmvc/applicationContext.xml");
	}

	@Test
	public void test() {
	  Date date =	(Date) context.getBean("currentDate");
	  System.out.println(date.toString());
	  
	 
	  //验证MyBatis是否添加到项目中
	  SqlSessionFactory sqlSessionFactory = (SqlSessionFactory) context.getBean("sqlSessionFactory");
	  System.out.println("sqlSessionFactory:"+sqlSessionFactory);
	  
	}

}
