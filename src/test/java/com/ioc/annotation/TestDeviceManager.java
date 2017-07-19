package com.ioc.annotation;

import org.junit.Test;

import com.base.UnitTestBase;
import com.ioc.beanannotation.javabases.MyDeviceManager;

public class TestDeviceManager extends UnitTestBase {

	public TestDeviceManager(){
		super("classpath*:spring-beanAnnotation.xml");
	}
	
	
	@Test
	public void test(){
		MyDeviceManager myDeviceManager = this.getBean("myDeviceManager");
		System.out.println("myDeviceManager: "+myDeviceManager.getClass().getName());
		myDeviceManager.print();
	}
	
	
	
	
}
