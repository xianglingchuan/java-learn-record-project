package com.ioc.annotation;

import org.junit.Test;

import com.base.UnitTestBase;
import com.ioc.beanannotation.BeanAnnotation;

public class TestAnnotation extends UnitTestBase {
	
	public TestAnnotation(){
		super("classpath*:spring-beanAnnotation.xml");
	}
	
	@Test
	public void testSay(){
		//BeanAnnotation beanAnnotation = this.getBean("beanAnnotation");
		BeanAnnotation beanAnnotation = this.getBean("myBean");
		beanAnnotation.say("This is a test");
	}
	
	
	@Test
	public void testScpoe(){
		BeanAnnotation beanAnnotation = this.getBean("myBean");
		beanAnnotation.printHashcode();
		
		beanAnnotation = this.getBean("myBean");
		beanAnnotation.printHashcode();
	}

}
