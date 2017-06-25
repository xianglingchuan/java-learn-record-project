package com.junit;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;

public class MybatisTest {

	
	private ApplicationContext context = null;
	
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
		//context = new ClassPathXmlApplicationContext("");
	}

	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
