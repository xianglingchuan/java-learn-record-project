package com.ioc.beanannotation;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

//@Component
//@Scope("prototype")
@Scope("singleton")
@Component("myBean") //注解定义Bean名称
public class BeanAnnotation {
	
	
	public void say(String str){
		System.out.println("BeanAnnotation:"+str);
	}
	
	public void printHashcode(){
		System.out.println("BeanAnnotation:"+this.hashCode());
	}

}
