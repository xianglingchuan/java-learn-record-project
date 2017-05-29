package com.learn.webProjectPath;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



@SuppressWarnings("serial")
public class PathServlet  extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		
		//1、根目录所对应的绝对路径：request.getServletPath()
		String path1 = req.getServletPath();
		System.out.println("path1:"+path1);
		
		//2、文件的绝对路径：request.getSession().getServletContext().getRealPath(request.getRequestURI())
		String path2 = req.getSession().getServletContext().getRealPath("/");
		System.out.println("path2:"+path2);
		
		//3、当前web应用的绝对路径：servletConfig.getServletContext().getRealPath("/")
		String path3 = this.getServletConfig().getServletContext().getRealPath("/");
		System.out.println("path3:"+path3);
	}
	

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doGet(req, resp);
	}	
	
}
