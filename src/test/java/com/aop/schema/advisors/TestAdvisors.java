package com.aop.schema.advisors;

import org.junit.Test;

import com.aop.schema.advisors.service.InvokeService;
import com.base.UnitTestBase;

public class TestAdvisors  extends UnitTestBase{
	
	
	public TestAdvisors(){
		super("classpath*:spring-aop-schema-advisors.xml");
	}

	
	@Test
	public void testSave(){
		InvokeService service = super.getBean("invokeService");
		service.invoke();
		System.out.println();
		service.invokeException();
	}
	
	
	
	

}
