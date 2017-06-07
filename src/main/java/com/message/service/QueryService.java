package com.message.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.message.bean.Command;
import com.message.bean.CommandContent;
import com.message.bean.Message;
import com.message.dao.CommandDao;
import com.message.dao.MessageDao;
import com.message.util.Iconst;

public class QueryService {

	private MessageDao messageDao;
	
	private CommandDao commandDao;

	public QueryService() {
		messageDao = new MessageDao();
		commandDao = new CommandDao();
	}	
	
	/**
	 * 通过命令查询相关的内容信息
	 */
	public String queryCommand(String command){
		Message message = new Message();
		List<Message> list= new ArrayList<Message>();
		if(!command.equals("")){
			if(command.equals("帮助")){
				list = messageDao.queryList(message);
				StringBuilder stringBuilder = new StringBuilder();
				for(int i=0; i<list.size(); i++){
					if(i!=0){
						stringBuilder.append("<BR>");
					}
					stringBuilder.append("回复:["+list.get(i).getCommand()+"]"+" 查看:"+list.get(i).getDescription());				
				}
				if(!stringBuilder.equals("")){
					return stringBuilder.toString();				
				}
			}else{
				message.setCommand(command);		
				list = messageDao.queryList(message);
				if(list.size()>=1){
					return list.get(0).getContent();
				}
			}					
		}
		return Iconst.NO_MATCHING_CONTENT;
	}
	
	
	/**
	 * 通过命令查询相关的内容信息
	 */
	public String queryCommandNew(String command){
		Command entity = new Command();
		List<Command> list= new ArrayList<Command>();
		if(!command.equals("")){
			if(command.equals("帮助")){
				list = commandDao.queryList(entity);
				StringBuilder stringBuilder = new StringBuilder();
				for(int i=0; i<list.size(); i++){
					if(i!=0){
						stringBuilder.append("<BR>");
					}
					stringBuilder.append("回复:["+list.get(i).getName()+"]"+" 查看:"+list.get(i).getDescription());				
				}
				if(!stringBuilder.equals("")){
					return stringBuilder.toString();				
				}
			}else{
				entity.setName(command);
				list = commandDao.queryList(entity);
				if(list.size()>=1){
					List<CommandContent> contentList = list.get(0).getContentList();
					int index = new Random().nextInt(contentList.size());
					System.out.println("index==="+index);
					return contentList.get(index).getContent();
				}
			}					
		}
		return Iconst.NO_MATCHING_CONTENT;
	}
}
