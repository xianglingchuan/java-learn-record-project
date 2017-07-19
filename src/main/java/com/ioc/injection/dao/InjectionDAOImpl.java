package com.ioc.injection.dao;

public class InjectionDAOImpl implements InjectionDAO {

	
	public void save(String str) {
		System.out.println("======dao save:"+str);
	}

}
