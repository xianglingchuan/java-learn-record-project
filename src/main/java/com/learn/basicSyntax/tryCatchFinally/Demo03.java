package com.learn.basicSyntax.tryCatchFinally;

//import com.xiaomi.xmpush.server.Result;
//import jxl.demo.Demo;

public class Demo03 {

	public static void main(String[] args) {
		Demo03  demo03 = new Demo03();
		//int result = demo03.test();
	    //System.out.println("test执行返回值:"+result);
		
		//int result2 = demo03.test2();
	    //System.out.println("test2执行返回值:"+result2);

		int result3 = demo03.test3();
	    System.out.println("test3执行返回值:"+result3);

	    
	    
	}
	
	
	
	
	/*
	 * 抛出异常情况
	 * */
    public int test(){    	
    	try {
        	int dayCount = 10;
        	int result = 100;
        	while(dayCount>-1){
        		result = result+(100/dayCount);
        		dayCount--;
        	}    	
        	return result;			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("我抛出了异常信息");
			return -1;
		}
    }

    
    
	/*
	 * 抛出异常情况
	 * finally的执行顺序在try catch块执行完以后
	 * */
    public int test2(){    	
    	int dayCount = 10;
    	int result = 100;    	
    	try {
        	while(dayCount>-1){
        		result = result+(100/dayCount);
        		dayCount--;
        	}    	
        	return result;			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("我抛出了异常信息");
			return result=9999;
		}finally {
		    System.out.println("finally信息输出result="+result);	
		}
    }
    
    
    
	/*
	 * 抛出异常情况
	 * finally的执行顺序在try catch块执行完以后
	 * */
    public int test3(){    	
    	int dayCount = 10;
    	int result = 100;    	
    	try {
        	while(dayCount>-1){
        		result = result+(100/dayCount);
        		dayCount--;
        	}    	
    	} catch (Exception e) {
			e.printStackTrace();
			System.out.println("我抛出了异常信息");
		}finally {
		    System.out.println("finally信息输出result="+result);	
		}
    	System.out.println("test3执行完成， result="+result);
    	return result;
    }
    
    
}
