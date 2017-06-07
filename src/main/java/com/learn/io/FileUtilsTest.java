package com.learn.io;

import java.io.File;

public class FileUtilsTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String pathname = File.separator+"Users"+File.separator+"xianglingchuan"+File.separator+"Documents"+File.separator+"work"+File.separator+"javaWork2"+File.separator+"java-learn-record-project";
		System.out.println("pathname:"+pathname);
		FileUtils.readFiles(new File(pathname));
		

	}

}
