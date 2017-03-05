package com.learn.basicSyntax.tryCatchFinally.exception;


/*
 * 
 * 异常链的实现
 * 
 * */
public class Demo05 {

	
	public static void main(String[] args) {
		Demo05 demo = new Demo05();
		//demo.test2(105);
		demo.test3(105);
	}
	
	
	
	public void test(int drunkNumber) throws DrunkException{
		if(drunkNumber>=100){
			throw new DrunkException("你当前血液酒精的容度为:"+drunkNumber+", 不能酒后驾驶汽车！");
		}else{
			System.out.println("你当前血液酒精的容度为:"+drunkNumber+", 可以安全驾驶汽车！");
		}
	}
	
	/*
	 * 第一种写法
	 * */
	public void test2(int drunkNUmber){
		try {
			test(drunkNUmber);
		} catch (DrunkException e) {
			//开始新建一个动行时异常
			RuntimeException runtimeException = new RuntimeException("开车一滴酒，亲人两行泪.");
			runtimeException.initCause(e);
			throw runtimeException;
		}
	}
	
	/*
	 * 第二种写法
	 * */
	public void test3(int drunkNUmber){
		try {
			test(drunkNUmber);
		} catch (DrunkException e) {
			//开始新建一个动行时异常
			RuntimeException runtimeException = new RuntimeException(e);
			throw runtimeException;
		}
	}
	
	
	
}
