package com.ioc.autowiring;

import org.junit.Test;

import com.base.UnitTestBase;

public class TestAutoWiring extends UnitTestBase {

	public TestAutoWiring(){
		super("classpath*:spring-autowiring.xml");
	}
	
	
	@Test
	public void testSay(){
		AutoWiringService service = super.getBean("autoWiringService");
		service.say("this is a autoWiring");
	}
	
	
}
