package com.message.service;

import java.sql.SQLException;
import java.util.List;

import com.message.bean.Message;
import com.message.dao.MessageDao;

public class MessageService {

	private MessageDao messageDao;

	public MessageService() {
		messageDao = new MessageDao();
	}

	public List<Message> getList(Message message){
		return messageDao.getList(message);
	}
	
	public List<Message> queryList(Message message){
		return messageDao.queryList(message);
	}
	
	
	public int deleteOne(Integer id){
		return messageDao.deleteOne(id);
	}	
	
	public int deleteBetch(String[] ids){
		Integer[] idsInteger = new Integer[ids.length];
		for(int i=0; i<ids.length; i++){
			idsInteger[i] = Integer.valueOf(ids[i]);
		}
		for (Integer integer : idsInteger) {
			System.out.println("integer:"+integer);
		}
        return messageDao.deleteBatch(idsInteger);
	}	
	
	public Message get(Message entity){
		return messageDao.get(entity);
	}
	
	public int insert(Message entity){
		return messageDao.insert(entity);
	}
	
	public int update(Message entity){
		return messageDao.update(entity);
	}
	
	public List<Message> queryListByTrim(Message message){
		return messageDao.queryListByTrim(message);
	}
	
	public int updateByTrim(Message entity){
		return messageDao.updateByTrim(entity);
	}
	
	public int insertByTrim(Message entity){
		return messageDao.insertByTrim(entity);
	}
}
