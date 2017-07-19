package com.ioc.beanannotation.injection.dao;


import org.springframework.stereotype.Repository;

@Repository
public class InjectionDAOImpl implements InjectionDAO {

	
	public void save(String str) {
		System.out.println("======dao save:"+str);
	}

}
