package com.learn.io.stream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import javax.imageio.stream.FileImageOutputStream;

public class IODemo05 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		//在utf-8项目中读取gbk编码的文件
		FileInputStream fileInputStream = new FileInputStream("demo/file_gbk.txt");
		InputStreamReader reader = new InputStreamReader(fileInputStream,"gbk");
		
		//将从bgk编码文件读出的内容存放到utf-8格式的文件中去
		FileOutputStream fileOutputStream = new FileOutputStream("demo/file_utf8.txt");
		OutputStreamWriter writer = new OutputStreamWriter(fileOutputStream, "utf-8");
		
		int ichar;
		while((ichar=reader.read())!=-1){
			System.out.print((char)ichar);
			writer.write((char)ichar);
			writer.flush();
		}
		writer.close();
		reader.close();
		

	}

}
