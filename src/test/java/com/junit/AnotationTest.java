package com.junit;

import static org.junit.Assert.assertEquals;

import org.junit.Ignore;
import org.junit.Test;

public class AnotationTest {
	
	/**
	 * @Test: 将一个普通的方法修饰成一个测试方法
	 *  @Test(expected=XXX.class) 来将异常情况给忽略掉
	 *  @Test(timeout=毫秒)
	 * @BeforeClass: 它会在所有的方法运行前被执行，static修饰
	 * @AfterClass:  它会在所有的方法运行结束被执行，static修饰
	 * @Before:      它会在每一个测试方法被运行前执行
	 * @After:       它会在每一个测试方法结束后执行
	 * @Ignore:      所修饰的测试方法会被测试运行器忽略
	 * @RunWith:     可以更改测试运行器 org.junit.runner.Runner 
	 */
	
	
	@Test(expected=java.lang.ArithmeticException.class)
	public void testDivide() {
		assertEquals(9,new Calculate().divide(81, 0));
	}	
	

	@Ignore
	@Test
	public void testIgnore() {
		System.out.println("this is a Ignore...");
	}	
	
	
	@Test(timeout=200)
	public void testWhile(){
		while (true) {
			System.out.println("this is testWhile...");
		}
	}
	
	

}
