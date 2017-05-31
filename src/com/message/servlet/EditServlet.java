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
 * 
 * 修改记录信息
 * 
 */
@SuppressWarnings("serial")
public class EditServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//设置编码格式
		req.setCharacterEncoding("UTF-8");
		//接收参数
		String idstr = req.getParameter("id");
		Message info = null;
		if(idstr!=null && !"".equals(idstr.trim())){
			MessageService messageService = new MessageService();
			Message entity = new Message();
			entity.setId(Integer.parseInt(idstr));
			info = messageService.get(entity);			
		}else{
			System.out.println("参数错误!");
		}
		req.setAttribute("info", info);
		req.getRequestDispatcher("WEB-INF/jsp/backend/form.jsp").forward(req, resp);		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doGet(req, resp);
	}
}
