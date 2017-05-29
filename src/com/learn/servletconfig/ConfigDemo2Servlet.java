package com.learn.servletconfig;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ConfigDemo2Servlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		//获取指定的初始化参数		
		String donwloadPath  = this.getServletConfig().getInitParameter("donwloadPath");
		System.out.println("donwloadPath="+donwloadPath);
		response.getOutputStream().write(donwloadPath.getBytes());
		//循环获取所有初始化参数
		Enumeration<String> list = this.getServletConfig().getInitParameterNames();
		while(list.hasMoreElements()){
			String name = list.nextElement();
			String value = this.getServletConfig().getInitParameter(name);
			System.out.println(name+"="+value);
			String str = name+"="+value;
			response.getOutputStream().write(str.getBytes());
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		doGet(request,response);
	}	
	
}
