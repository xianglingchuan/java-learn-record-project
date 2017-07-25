package com.aop.schema.advice;

public class FitImpl implements FitInterface {

	@Override
	public void filter() {
		System.out.println("FitImpl filter...");
	}

}
