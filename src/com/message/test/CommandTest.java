package com.message.test;

import java.util.List;

import org.apache.ibatis.reflection.SystemMetaObject;

import com.message.bean.Command;
import com.message.bean.CommandContent;
import com.message.service.CommandService;

public class CommandTest {
	
	public static void main(String[] args) {
		CommandService commandService = new CommandService();
		Command entity = new Command();
		List<Command> list = commandService.queryList(entity);
		for (Command command : list) {
			System.out.println("ID:"+command.getId()+",NAME:"+command.getName()+",描述:"+command.getDescription());
			List<CommandContent> contentList = command.getContentList();
			for (CommandContent commandContent : contentList) {
				System.out.println(commandContent.getContent());				
			}
		}
		
		System.out.println("==================================");
		entity.setId(1);
		Command command  = commandService.get(entity);
		System.out.println(command.toString());
		System.out.println("ID:"+command.getId()+",NAME:"+command.getName()+",描述:"+command.getDescription());
		List<CommandContent> contentList = command.getContentList();
		for (CommandContent commandContent : contentList) {
			System.out.println(commandContent.getContent());				
		}		
		
		
		
	}
}
