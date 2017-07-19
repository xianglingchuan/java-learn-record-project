package com.ioc.annotation;

import org.junit.Test;

import com.base.UnitTestBase;
import com.ioc.beanannotation.javabases.BreadStore;
import com.ioc.beanannotation.javabases.StoreConfig;

public class TestStore extends UnitTestBase {
	
	public TestStore(){
		super("classpath*:spring-beanAnnotation.xml");
	}
	
	
	@Test
	public void Test(){
		StoreConfig config = this.getBean("storeConfig");
		System.out.println("config: "+config.getClass().getName());
		
		BreadStore breadStore = this.getBean("store");
		System.out.println("breadStore: "+breadStore.getClass().getName());
		
	}
	
	
	@Test
	public void testSocpe(){
		BreadStore breadStore = this.getBean("breadStore");
		System.out.println("hashCode:"+breadStore.hashCode());
		
		breadStore = this.getBean("breadStore");
		System.out.println("hashCode:"+breadStore.hashCode());
		
	}
	
	
	
	

}
