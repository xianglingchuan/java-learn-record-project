package com.message.mybatis;

import java.util.List;

import com.message.bean.Message;

public interface IMessage {

	public List<Message> queryList(Message message);
	
}
