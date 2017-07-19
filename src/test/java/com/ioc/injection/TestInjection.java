package com.ioc.injection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

import com.base.UnitTestBase;
import com.ioc.injection.service.InjectionService;
import com.ioc.interfaces.OneInterfaces;


@RunWith(BlockJUnit4ClassRunner.class)
public class TestInjection extends UnitTestBase {

    public TestInjection(){
    	super("classpath*:spring-injection.xml");
    }	
	
    
    @Test
    public void save(){
    	
    	InjectionService injectionService = this.getBean("injectionService");
    	injectionService.save("username:admin;password:123456");
    	
    	
    	
    }    
    
}
