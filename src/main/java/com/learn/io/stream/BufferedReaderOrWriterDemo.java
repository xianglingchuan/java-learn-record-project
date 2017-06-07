package com.learn.io.stream;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BufferedReaderOrWriterDemo {

	public static void main(String[] args) throws Exception {
		
		BufferedReader reader = new BufferedReader(
								new InputStreamReader(
								new FileInputStream("demo/file.txt")));
		BufferedWriter writer = new BufferedWriter(
				                new OutputStreamWriter(
				                new FileOutputStream("demo/file_buffered.txt")));
		String str;
		
		while((str=reader.readLine())!=null){
			System.out.println(str); //一次性读取一行，并不认识换行符
			writer.write(str); //写入字符串
			writer.newLine();  //添加换行符
			writer.flush();
		}
		reader.close();
		writer.close();
		
		
		

	}

}
