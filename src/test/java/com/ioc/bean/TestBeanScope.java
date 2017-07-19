package com.ioc.bean;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

import com.base.UnitTestBase;

/**
 *
 * 测试Bean的作用域
 * 
 */
@RunWith(BlockJUnit4ClassRunner.class)
public class TestBeanScope extends UnitTestBase {

	
	public TestBeanScope(){
		 super("classpath*:spring-beanscope.xml");
	}
	
	
	@Test
	public void testSay(){
		BeanScope beanScope = this.getBean("beanScope"); 
		beanScope.say();
		
		BeanScope beanScope2 = this.getBean("beanScope"); 
		beanScope2.say();
	}
	
}
