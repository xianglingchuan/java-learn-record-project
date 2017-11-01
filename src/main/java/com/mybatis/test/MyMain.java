package com.mybatis.test;

import java.util.List;


public class MyMain {
	
	public static void main(String[] args) {
		SqlSession session = new SqlSession();
		MyInterface myInterface =   session.getMapper(MyInterface.class);
		Object params = new Object();
		List<Object> list = myInterface.query(params);
		for (Object object : list) {
			System.out.println(object.toString());
		}
	}
}
