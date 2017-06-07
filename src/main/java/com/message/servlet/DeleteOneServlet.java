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
 * 删除单列记录数据
 * 
 */
@SuppressWarnings("serial")
public class DeleteOneServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//设置编码格式
		req.setCharacterEncoding("UTF-8");
		//接收参数
		String idstr = req.getParameter("id");
		if(idstr!=null && !"".equals(idstr.trim())){
			MessageService messageService = new MessageService();
			int result =  messageService.deleteOne(Integer.parseInt(idstr));
			if(result>=1){
				req.getRequestDispatcher("./list.action").forward(req, resp);
			}else{
				System.out.println("删除失败!");
			}			
		}else{
			System.out.println("参数错误!");
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doGet(req, resp);
	}
}
