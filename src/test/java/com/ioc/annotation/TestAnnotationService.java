package com.ioc.annotation;

import org.junit.Test;

import com.base.UnitTestBase;
import com.ioc.beanannotation.injection.service.InjectionServiceImpl;
import com.ioc.beanannotation.multibean.BeanInvoker;

public class TestAnnotationService extends UnitTestBase{

	
	public TestAnnotationService(){
		super("classpath*:spring-beanAnnotation.xml");
	}
	
	
	@Test
	public void testSave(){
		InjectionServiceImpl service = this.getBean("injectionServiceImpl");
		service.save("This is a service");
	}
	
	
	@Test
	public void testMulti(){
		BeanInvoker beanInvoker = this.getBean("beanInvoker");
		beanInvoker.say();
	}
	
	
}
