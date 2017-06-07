package com.learn.io.stream;

import java.io.File;

public class IOUtilDemo01 {

	public static void main(String[] args){
		try {
			File srcFile = new File("demo/out.dat");
			File descFile = new File("demo/file_buffer.txt");		
			IOUtil.copyFileByBuffer(srcFile, descFile);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
