package com.learn.reflect;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Method;

import com.learn.reflect.service.UserService;

public class MethodDemo2 {

	public static void main(String[] args) {
		UserService userService = new UserService();
		/*
		 * 通过键盘输入命令执行操作
		 * 输入update命令执行update方法
		 * 输入delete命令执行delete方法
		 * */
		try {
			BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("请输入命令：");		
			String action = bReader.readLine();
			//普通的方法是:
//			if("update".equals(action)){
//				userService.update();
//			}
//			if("create".equals(action)){
//				userService.create();
//			}
			
			/*
			 * action就是方法名称，都没有参数--->通过方法的反射操作就会简单很多
			 * 通过方法对象后进行反射操作
			 * */
			Class class1 = userService.getClass();
			Method method = class1.getMethod(action);
			method.invoke(userService);
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		
		
		
	}
}
