package com.learn.basicSyntax.tryCatchFinally.exception;

public class Demo04 {

	public static void main(String[] args) {
		Demo04 demo = new Demo04();
		try {
			demo.test(99);
		} catch (DrunkException e) {	
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
	
	public void test(int drunkNumber) throws DrunkException{
		if(drunkNumber>=100){
			throw new DrunkException("你当前血液酒精的容度为:"+drunkNumber+", 不能酒后驾驶汽车！");
		}else{
			System.out.println("你当前血液酒精的容度为:"+drunkNumber+", 可以安全驾驶汽车！");
		}
	}
	

}
