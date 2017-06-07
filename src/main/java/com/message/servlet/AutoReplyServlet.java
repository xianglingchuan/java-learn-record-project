package com.message.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.message.service.QueryService;

/**
 * 自动回复功能控制层 
 */
@SuppressWarnings("serial")
public class AutoReplyServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();		
		QueryService queryService = new QueryService();
		//String resultStr = queryService.queryCommand(req.getParameter("content"));
		String resultStr = queryService.queryCommandNew(req.getParameter("content"));
		out.write(resultStr);
		out.close();
	}

	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doGet(req, resp);
	}	
	
}
