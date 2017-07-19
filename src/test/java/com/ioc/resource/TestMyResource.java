package com.ioc.resource;

import org.junit.Test;

import com.base.UnitTestBase;

public class TestMyResource extends UnitTestBase {
	
	
	public TestMyResource(){
		super("classpath*:spring-myresource.xml");
	}
	
	
	@Test
	public void testReadResource(){
		
		 MyResource myResource = super.getBean("myResource");
		 myResource.readResource();
		
		
		
	}
	
	
	

}
