package com.junit;

import static org.junit.Assert.*;

import org.junit.Test;

public class CalculateTest {

	
	@Test
	public void testAdd(){
		assertEquals(9, new Calculate().add(3, 6));
	}
	
	@Test
	public void testMultiply(){
		assertEquals(9, new Calculate().multiply(3, 3));
	}
	
	@Test
	public void testSubtract(){
		assertEquals(9, new Calculate().subtract(11, 2));
	}
	
	@Test
	public void testDivide(){
		assertEquals(9,new Calculate().divide(81, 9));
	}
	
	
	
	

}
