package com.aop.api;

import org.junit.Test;

import com.base.UnitTestBase;

public class TestAOPApi extends UnitTestBase {

	public TestAOPApi(){
		super("classpath*:spring-aop-api.xml");
	}
	
	
	
//	@Test
//	public void testSave(){
//		BizLogicIntface logicIntface = (BizLogicIntface)super.getBean("bizLogicImplTarget");
//		logicIntface.save();
//	}
	
	
	@Test
	public void testSave(){
		BizLogicIntface logicIntface = (BizLogicIntface)super.getBean("bizLogicImpl");
		logicIntface.save();
	}

	
	
}







