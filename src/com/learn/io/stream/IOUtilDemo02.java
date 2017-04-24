package com.learn.io.stream;

import java.io.File;

public class IOUtilDemo02 {

	public static void main(String[] args) {

		//测试相关的测试速度
		
		try {
			long start = System.currentTimeMillis();
			
			File srcFile = new File("demo/1.mp3");
			File descFile = new File("demo/byte.mp3");			
			
			//IOUtil.copyFileByBuffer(srcFile, descFile); //花费了21948
			//IOUtil.copyFileByByte(srcFile, descFile);  //花费了31504毫秒
			IOUtil.copyFile(srcFile, descFile); //花费26毫秒
			
			long end = System.currentTimeMillis();
			System.out.println("花费了:"+(end-start)+"毫秒");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
