package com.ioc.bean;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

import com.base.UnitTestBase;

/**
*
* 测试Bean的生命周期
* 
*/
@RunWith(BlockJUnit4ClassRunner.class)

public class TestBeanLiftCycle extends UnitTestBase{
	
	
	public TestBeanLiftCycle(){
		 super("classpath*:spring-beanLiftCycle.xml");
	}	
	
	
	@Test
	public void say(){
		BeanLiftCycle beanLiftCycle =  this.getBean("beanLiftCycle");
		beanLiftCycle.hello();
	}

}
