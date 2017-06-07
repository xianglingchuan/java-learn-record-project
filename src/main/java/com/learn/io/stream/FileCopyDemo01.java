package com.learn.io.stream;

import java.io.File;
import java.io.IOException;

public class FileCopyDemo01 {

	public static void main(String[] args) {

		try {
			File srcFile= new File("demo/out.dat");
			File destFile = new File("demo/copy.txt");			
			IOUtil.copyFile(srcFile, destFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}

}
