package com.aop.aspectj;

import org.junit.Test;

import com.aop.aspectj.biz.AlanBiz;
import com.base.UnitTestBase;

public class TestAspectj extends UnitTestBase{

	public TestAspectj(){
		super("classpath*:spring-aop-aspectj.xml");
	}
	
	
	@Test
	public void test(){
		AlanBiz alanBiz = super.getBean("alanBiz");
		alanBiz.save("this is test");
	}
}
