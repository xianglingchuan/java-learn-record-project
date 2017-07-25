package com.aop.schema.advice;

import org.junit.Test;

import com.base.UnitTestBase;

public class TestSimpleAspect  extends UnitTestBase{
	
	
	public TestSimpleAspect(){
		super("classpath*:spring-aop-schema-advice.xml");
	}
//	
//	@Test
//	public void testSay(){
//		AspectBiz aspectBiz = this.getBean("aspectBiz");
//		aspectBiz.say();
//	}
//	
//	@Test
//	public void testRound(){
//		AspectBiz aspectBiz = this.getBean("aspectBiz");
//		aspectBiz.init("simple", 10);
//	}
	
	
	@Test
	public void testFit(){
		FitInterface fit =(FitInterface)this.getBean("aspectBiz");
		fit.filter();
	}	
	
	

}
