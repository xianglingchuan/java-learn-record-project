package com.learn.io;

import java.beans.FeatureDescriptor;
import java.io.File;

public class FileUtils {

	/*
	 * 用于读取目录下面的指定目录下的文件及子目录内容
	 * @param  File
	 * */
	public static void readFiles(File directoryName){
		//判断是否存在
		if(!directoryName.exists()){
			throw new IllegalArgumentException("目录:"+directoryName+"不存在");
		}
		//判断是否为目录信息
		if(!directoryName.isDirectory()){
			throw new IllegalArgumentException(directoryName+"不是目录");
		}
		//开始读取目录下的信息
		//用list()方法读取的操作
		//返回的是字符串数组，直接子的名称，不包含目录下的内容
//		String[] fileNames = directoryName.list();
//		for (String string : fileNames) {
//			System.out.println(directoryName+File.separator+string);
//		}
		
		//如果要遍历子目录下的内容就需要构造成File对象做递归操作，File提供了直接返回File对象的数组访问
		File[] files = directoryName.listFiles(); //返回的是直接子目录(文件的)抽象
		if(files != null && files.length >=1){
		    for (File file : files) {
		    	System.out.println(file.getPath()+file.getName());
		    	if(file.isDirectory()){
		    		readFiles(file); //递归的读取目录下的文件
		    	}
			}					
		}
	}
	
	
}
