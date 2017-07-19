package com.ioc.aware;

import org.junit.Test;

import com.base.UnitTestBase;

public class TestApplicationContext extends UnitTestBase {

	
	public TestApplicationContext(){
		super("classpath*:spring-aware.xml");
	}
	
	
//	@Test
//	public void say(){
//		System.out.println("say:"+this.getBean("applicationContext").hashCode());
//	}
	
	
	@Test
	public void testBeanName(){
		System.out.println("testBeanName "+this.getBean("beanName").hashCode());
	}
	
	
	
}
