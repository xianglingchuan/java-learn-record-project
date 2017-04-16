package com.learn.io;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;

public class FileDemo01 {

	public static void main(String[] args) {
		
		
		//File.separator 根据系统给出目录的链接符
		
		String pathname = File.separator+"Users"+File.separator+"xianglingchuan"+File.separator+"Documents"+File.separator+"work"+File.separator+"javaWork2"+File.separator+"java-learn-record-project"+File.separator+"files/";
		System.out.println("pathname:"+pathname);
		File file = new File(pathname);
		System.out.println("是否存在:"+file.exists());
		if(!file.exists()){
			System.out.println("开始创建");
			file.mkdir();
		}else{
			//file.delete();
		}
		//当File不为目录或者该目录不存在的情况下返回false, 目录存在返回true
		System.out.println("判断是否为目录："+file.isDirectory());
		System.out.println("判断是否为文件:"+file.isFile());
		
		//File file2 = new File(pathname+"日记1.txt");
		File file2 = new File(pathname, "日记2.txt");
		if(!file2.exists()){
			try {
				file2.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else{
			//file2.delete();
		}
		
		//常用的File对象的API
		System.out.println(file); //file.toString对象
		System.out.println(file2);
		System.out.println(file.getAbsolutePath()); 
		System.out.println(file.getName());
		System.out.println(file2.getName());
		System.out.println(file.getParent());
		System.out.println(file2.getParent());
		System.out.println(file.getParentFile().getAbsolutePath());
		System.out.println(file2.getParentFile().getAbsolutePath());
		
		File file3 = new File(pathname+"a"+file.separator+"c"+file.separator+"d");
		file3.mkdirs(); //创建多级目录结构的mkdir
		

	}

}
