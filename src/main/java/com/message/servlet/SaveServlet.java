package com.message.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.message.bean.Message;
import com.message.service.MessageService;


@SuppressWarnings("serial")
public class SaveServlet extends HttpServlet  {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String command = req.getParameter("command");
		String description = req.getParameter("description");
		String content = req.getParameter("content");
		String idStr = req.getParameter("id");
		Message entity = new Message();
		entity.setCommand(command);
		entity.setDescription(description);
		entity.setContent(content);		
		if(idStr!=null && !idStr.equals("")){
			entity.setId(Integer.parseInt(idStr));
		}
		MessageService messageService = new MessageService();
		int result = 0;
		if(entity.getId()!=null && entity.getId() >=1){
			result = messageService.update(entity);
		}else{
			result = messageService.insert(entity);
		}
		if(result>=1){
			System.out.println("添加成功.");
		}else{
			System.out.println("添加失败.");
		}
		resp.sendRedirect("./list.action");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doGet(req, resp);
	}	
}
