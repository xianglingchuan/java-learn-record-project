package com.learn.io;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.lang.reflect.Array;
import java.sql.Ref;
import java.util.Arrays;

import jxl.biff.ByteArray;

public class RandomAccessFileReadDemo {

	public static void main(String[] args) throws IOException {
		File demo = new File("demo"); //在当前工程下创建demo目录
		if(!demo.exists()){
			demo.mkdir();
		}
		File file = new File(demo,"randomAccessFile.dat");
		if(!file.exists()){
			file.createNewFile();
		}
		//只读内容
		RandomAccessFile raf = new RandomAccessFile(file,"r");
		raf.seek(0);
		
		//取两位byte位置
		int lenght = 2;
		byte[] data = new byte[lenght];
		for(int i=0; i<lenght; i++){
			int value = raf.read();
			data[i] = (byte)value;
			//raf.seek(i+1);
		}
		String t = new String(data);//byte[]转换为String
		System.out.println("写入的前两位字符内容为:"+t);
		System.out.println("当前文件指针的位置在:"+raf.getFilePointer());
		
		raf.seek(2);
		int i = 0;
		int b = raf.read();//读取到一个字节
		System.out.println(raf.getFilePointer());
		i = i | (b << 24 );
		b = raf.read();
		i = i | ( b << 16);
		b = raf.read();
		i = i | (b << 8 );
		b = raf.read();
		i = i | b;
		
		System.out.println("==============写入的整数为=================");
		//toHexString 返回一个整数参数的字符串表示*在基地16个无符号整数。
		//System.out.println(Integer.toHexString(i));
		System.out.println(i);
		raf.seek(2);
		i = raf.readInt();
		//System.out.println(Integer.toHexString(i));
		System.out.println(i);
		
		
		System.out.println("==============写入的汉字=================");
		//获取中字出来
		System.out.println("当前指针位置在："+raf.getFilePointer());
		byte[] data2 = new byte[2];
		data2[0] = (byte) raf.read();
		data2[1] = (byte) raf.read();
		//data2[2] = (byte) raf.read();
		System.out.println("当前指针位置在："+raf.getFilePointer());
		System.out.println("整个文件的长度为:"+raf.length());
		
		//怎么将取出来的gbk byte[] 放入到String中去？？？
		//System.out.println("data2:"+data2.toString());
		String string = new String(data2, "gbk");
		//string.getBytes("gbk");
		System.out.println("string:"+string);
		
		raf.close();
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
