package com.mybatis.test;

import java.lang.reflect.Proxy;

public class SqlSession {
	
	@SuppressWarnings("unchecked")
	public <T> T getMapper(Class<T> type){
		
		return (T)  Proxy.newProxyInstance(type.getClassLoader(), new Class[]{type}, new MapperProxy());
	}
	

}
