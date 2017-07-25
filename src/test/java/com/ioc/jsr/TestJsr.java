package com.ioc.jsr;

import org.junit.Test;

import com.base.UnitTestBase;

public class TestJsr extends UnitTestBase {

	
	
	public TestJsr(){
		super("classpath*:spring-jsr.xml");
	}
	
	
	@Test
	public void testSave(){
		JsrService service = getBean("jsrService");
		service.save();
		
		
	}
	
	
}
