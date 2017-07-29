package com.aop.api;


public class BizLogicImple implements BizLogicIntface {

	@Override
	public String save() {
		System.out.println("BizLogicImple : Logic save");
		return "BizLogicImple.save()";
		//throw new RuntimeException();
	}

}
