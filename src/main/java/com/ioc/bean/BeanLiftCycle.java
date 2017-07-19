package com.ioc.bean;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;


/**
 * 
 *  三种初始化方法都配置好
 *  首先执行的是 InitializingBean初始化方法
 *  然后执行Bean自定义的方法。
 *  1、如果已经配置了InitializingBean或者Bean自定义方法，那么就不会执行default-init-method方法了。
 *  2、在全局配置default-init-method配置的方法就算不在类中实现也不会报错
 *  3、消毁顺序跟初始化一样。
 *  
 * 
 */
public class BeanLiftCycle implements InitializingBean,DisposableBean{
	
	
	public void start(){
		System.out.println("execute start");
	}
	
	
	public void stop(){
		System.out.println("execute stop");
	}
	
	
	public void hello(){
		System.out.println("hello i am is BeanLiftCycle");
	}


	@Override
	public void afterPropertiesSet() throws Exception {
		 System.out.println("execute afterPropertiesSet.");
	}


	@Override
	public void destroy() throws Exception {
		System.out.println("execute destroy.");
	}
	
	
	public void defaultInit(){
		System.out.println("execute defaultInit.");
	}
	
	
	public void defaultDestory(){
		System.out.println("execute defaultDestory.");
	}

}
