package com.ioc.beanannotation.injection.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ioc.beanannotation.injection.dao.InjectionDAO;




@Service
public class InjectionServiceImpl implements InjectionService {
	
	//第一种方法直接注释dao属性
	//@Autowired
	private InjectionDAO injectionDAO;
	
	
	//第三种方法
	@Autowired
	public InjectionServiceImpl(InjectionDAO injectionDAO){
		this.injectionDAO = injectionDAO;		
	}
	
	
	
//	public void setDao(InjectionDAOImpl injectionDAO) {
//		this.injectionDAO = injectionDAO;
//	}
	

//	public InjectionDAO getInjectionDAO() {
//		return injectionDAO;
//	}


	//第二种方法注解setDao方法
	//@Autowired
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
