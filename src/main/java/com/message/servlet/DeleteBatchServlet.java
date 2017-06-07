package com.message.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.message.service.MessageService;
/**
 * 
 * 批量删除记录数据
 * 
 */
@SuppressWarnings("serial")
public class DeleteBatchServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//设置编码格式
		req.setCharacterEncoding("UTF-8");
		//接收参数
		String ids[] = req.getParameterValues("id");
		System.out.println("ids:"+ids.toString());
		if(ids.length>=1){
			MessageService messageService = new MessageService();
			int result = messageService.deleteBetch(ids);
			if(result>=1){
				req.getRequestDispatcher("./list.action").forward(req, resp);
			}else{
				System.out.println("删除失败!");
			}	
		}else{
			System.out.println("请选择要删除的ID号!");
		}
	}
	

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doGet(req, resp);
	}
}