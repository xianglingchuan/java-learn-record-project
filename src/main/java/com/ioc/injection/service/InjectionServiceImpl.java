package com.ioc.injection.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ioc.beanannotation.injection.dao.InjectionDAO;


public class InjectionServiceImpl implements InjectionService {
	
	
	private InjectionDAO injectionDAO;
	
	
//	public void setDao(InjectionDAOImpl injectionDAO) {
//		this.injectionDAO = injectionDAO;
//	}
	

	public InjectionDAO getInjectionDAO() {
		return injectionDAO;
	}


	public void setInjectionDAO(InjectionDAO injectionDAO) {
		this.injectionDAO = injectionDAO;
	}


	@Override
	public void save(String str) {
		str = str + this.hashCode();
		System.out.println("******service data:"+str);
		this.injectionDAO.save(str);		
	}

}
