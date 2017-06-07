package com.message.test;

import java.util.List;

import com.message.bean.Command;
import com.message.bean.Message;
import com.message.service.CommandService;
import com.message.service.MessageService;

public class MessageTest {

	
	public static void main(String[] args) {
		
		MessageService commandService = new MessageService();
		Message entity = new Message();
		entity.setCommand("COMMAND");
		List<Message> list = commandService.queryListByTrim(entity);
		
		Message entity2 = new Message();
		entity2.setId(1);
		entity2.setCommand("修改命令");
		int result = commandService.updateByTrim(entity2);
		
		Message entity3 = new Message();
		entity3.setCommand("新命令");
		entity3.setContent("新命令内容");
		entity3.setDescription("新命令描述");
		result = commandService.insertByTrim(entity3);
		System.out.println("新插入的ID号为:"+entity3.getId());
		
		
		
		
	}
}
