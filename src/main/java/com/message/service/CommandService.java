package com.message.service;

import java.util.List;

import com.message.bean.Command;
import com.message.dao.CommandDao;

public class CommandService {

	private CommandDao commandDao;

	public CommandService() {
		commandDao = new CommandDao();
	}

	public List<Command> queryList(Command command){
		return commandDao.queryList(command);
	}
	
	public Command get(Command entity){
		return commandDao.get(entity);
	}	
}
