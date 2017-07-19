package com.ioc.interfaces;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

import com.base.UnitTestBase;

@RunWith(BlockJUnit4ClassRunner.class)
public class TestOneInterfaces extends UnitTestBase {
	
    public TestOneInterfaces(){
    	super("classpath*:spring-ioc.xml");
    }
    
    @Test
    public void myPring(){
    	OneInterfaces interfaces = super.getBean("OneInterfaces");
    	System.out.println(interfaces.myPrint("java ioc"));
    	
    }

}
