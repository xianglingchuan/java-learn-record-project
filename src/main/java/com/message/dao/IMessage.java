package com.message.dao;

import java.util.List;
import java.util.Map;

import com.message.bean.Message;


public interface IMessage {
	
	
	public List<Message> queryList(Message message);
	
	
	public List<Message> queryListPage(Map map);

}
