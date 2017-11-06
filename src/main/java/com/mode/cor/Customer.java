package com.mode.cor;

import java.util.Random;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import com.mode.cor.handler.PriceHandler;

/**
 * 
 * 消费者类
 * 
 */
public class Customer {

	private PriceHandler priceHandler;

	public void setPriceHandler(PriceHandler priceHandler) {
		this.priceHandler = priceHandler;
	}
	
	//处理请求方法
	public void requestDiscount(float discount){
		priceHandler.processDiscount(discount);
	}
	
	
	public static void main(String[] args) {
		Customer customer = new Customer();
		customer.setPriceHandler(PriceHandlerFactory.createPriceHandler());
		
		//循环随机请求一百次
		Random random = new Random();
		for(int i=1; i<=100; i++){
		    System.out.print(i+":");
		    customer.requestDiscount(random.nextFloat());
		}
		//customer.requestDiscount(0.5f);
	}

}
