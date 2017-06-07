package com.learn.basicSyntax.jdbc.action;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.learn.basicSyntax.jdbc.dao.GoddessDao;
import com.learn.basicSyntax.jdbc.model.Goddess;

public class GoddessAction {

	public int createGoddess(Goddess goddess) throws SQLException{
		GoddessDao goddessDao = new GoddessDao();
		return goddessDao.createGoddess(goddess);
	}
	
	public int updateGoddess(Goddess goddess) throws SQLException{
		GoddessDao goddessDao = new GoddessDao();
		return goddessDao.updateGoddess(goddess);
		
	}
	
	public int delGoddess(int id) throws SQLException{
		GoddessDao goddessDao = new GoddessDao();
		return goddessDao.delGoddess(id);		
	}
	
	public Goddess get(int id) throws SQLException{
		GoddessDao goddessDao = new GoddessDao();
		return goddessDao.get(id);
	}
	
	
    public List<Goddess> query() throws SQLException{
    	GoddessDao goddessDao = new GoddessDao();
    	return goddessDao.query();
    }
    
    public List<Goddess> query(List<Map<String, String>> paramers) throws SQLException{
    	GoddessDao goddessDao = new GoddessDao();
    	return goddessDao.query(paramers);
    }    
    
	
}
