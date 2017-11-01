package com.mybatis.test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;


public class MapperProxy implements InvocationHandler {

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		
		//返回查询出来的结果
		List<Object> list = new ArrayList<Object>();
		list.add("123");
		list.add("456");
		list.add("789");
		return list;
	}

}
