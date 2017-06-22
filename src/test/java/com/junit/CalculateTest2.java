package com.junit;

import static org.junit.Assert.*;

import org.junit.Test;

public class CalculateTest2 {

	@Test
	public void testAdd() {
		assertEquals(4, new Calculate().add(3, 6));
	}

	
	@Test
	public void testDivide() {
		assertEquals(9,new Calculate().divide(81, 0));
	}

}
