package com.message.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.message.bean.Message;
import com.message.service.MessageService;

/**
 * 创建记录信息
 */
@SuppressWarnings("serial")
public class CreateServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		Message info = new Message();
		req.setAttribute("info", info);
		req.getRequestDispatcher("WEB-INF/view/message/backend/form.jsp").forward(req, resp);
	}
	

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doGet(req, resp);
	}
}
