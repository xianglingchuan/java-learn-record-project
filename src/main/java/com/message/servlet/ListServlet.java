package com.message.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.message.bean.CommandContent;
import com.message.bean.Message;
import com.message.entity.Page;
import com.message.service.CommandContentService;
import com.message.service.MessageService;

/**
 * 
 * 列表页面初始化控制
 * 
 */
@SuppressWarnings("serial")
public class ListServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//设置编码格式
		req.setCharacterEncoding("UTF-8");
		//接收参数
		String command = (String) req.getParameter("command");
		String description = (String) req.getParameter("description");
		String currentPage = (String) req.getParameter("currentPage");
		System.out.println("command:" + command + ", description:" + description);
		req.setAttribute("command", command);
		req.setAttribute("description", description);

		MessageService messageService = new MessageService();
		Message messageFind = new Message();
		messageFind.setCommand(command);
		messageFind.setDescription(description);
		
		//创建分页对象
		Page page = new Page();
		Pattern pattern = Pattern.compile("[0-9]{1,9}");
		if(currentPage==null || !pattern.matcher(currentPage).matches()){
			page.setCurrentPage(1);
		}else{
			page.setCurrentPage(Integer.valueOf(currentPage));
		}
		
		Map<String,Object> paramObject = new HashMap<String,Object>();
		paramObject.put("message", messageFind);
		paramObject.put("page", page);
		
		//查询列表内容
		//List<Message> list = messageService.getList(messageFind);
		//List<Message> list = messageService.queryList(messageFind);
		
		
		//进行分页查询
		List<Message> list = messageService.queryListPage(paramObject);
		
		//分页使用拦截器查询
		//List<Message> list = messageService.queryMessageListByPage(paramObject);
		
		
		System.out.println("ListServlet.java");
		req.setAttribute("messageList", list);
		req.setAttribute("page", page);
		
		
		
		
		//测试批量插入数据
		CommandContentService service = new CommandContentService();
		CommandContent content1 = new CommandContent();
		content1.setCommandId(1);
		content1.setContent("aaa");
		System.out.println(content1.toString());
		CommandContent content2 = new CommandContent();
		content2.setCommandId(1);
		content2.setContent("bbb");	
		System.out.println(content2.toString());
		List<CommandContent> list2 = new ArrayList<CommandContent>();
		list2.add(content1);
		list2.add(content2);
		service.insertBatch(list2);
		
		
		
		
		
		
		req.getRequestDispatcher("WEB-INF/views/message/backend/list.jsp").forward(req, resp);
	}

	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doGet(req, resp);
	}
}
