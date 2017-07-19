package com.ioc.annotation;

import org.junit.Test;

import com.base.UnitTestBase;
import com.ioc.beanannotation.javabases.StringCar;

public class TestCar extends UnitTestBase {
	
	public TestCar(){
		super("classpath*:spring-beanAnnotation.xml");
	}

	
	@Test
	public void stringCarTest(){
		StringCar car = this.getBean("stringCarTest");
		
	}
	
}
