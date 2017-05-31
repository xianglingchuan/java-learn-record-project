package com.message.test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.message.bean.CommandContent;
import com.message.service.CommandContentService;

public class CommandContentTest {
	
	
   public static void main(String[] args) {
	  
//	   CommandContentService service = new CommandContentService();
//	   CommandContent entity = new CommandContent();
//	   List<CommandContent> list = service.queryList(entity);
//	   for (CommandContent commandContent : list) {
//		   System.out.println(commandContent.getId()+commandContent.getCommandId()+commandContent.getContent());
//		   System.out.println("ID:"+commandContent.getCommand().getId());
//		   System.out.println("NAME:"+commandContent.getCommand().getName());
//		   System.out.println("DESCRIPTION:"+commandContent.getCommand().getDescription());
//	   }
//
//	   
//	   
//	   entity.setCommandId(1);
//	   entity.setId(1);
//	   CommandContent commandContent = service.get(entity);
//	   System.out.println(commandContent.getId()+commandContent.getCommandId()+commandContent.getContent());
//	   System.out.println("ID:"+commandContent.getCommand().getId());
//	   System.out.println("NAME:"+commandContent.getCommand().getName());
//	   System.out.println("DESCRIPTION:"+commandContent.getCommand().getDescription());
	   
	   
	   CommandContentService service = new CommandContentService();
	   CommandContent entity = new CommandContent();
	   
	   //set测试
//	   entity.setId(1);
//	   entity.setContent("更新的内容信息");
//	   int result = service.update(entity);
//	   System.out.println("result:"+result);
	   
	   Map<String,String> map = new HashMap<String,String>();
	   map.put("keyword", "第一条");
	   
	   CommandContent commandContent = service.findInfoByOneParam(map);
	   System.out.println("ID:"+commandContent.getId());
	   System.out.println("COMMAND_ID:"+commandContent.getCommandId());
	   System.out.println("CONTENT:"+commandContent.getContent());
	   
	   
	   
   }

}
