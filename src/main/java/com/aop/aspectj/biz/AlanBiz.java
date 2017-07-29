package com.aop.aspectj.biz;

import org.springframework.stereotype.Service;

import com.aop.aspectj.AlanMethod;

@Service
public class AlanBiz{

	@AlanMethod(value = "AlanBiz save with AlanMethod")
	public String save(String args) {
		System.out.println("AlanBiz save:"+args);
//		throw new RuntimeException("Save fail.");
		return "Save success";
	}

}
