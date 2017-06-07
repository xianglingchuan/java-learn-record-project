package com.learn.io;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.lang.reflect.Array;
import java.util.Arrays;

public class RandomAccessFileDemo {

	public static void main(String[] args) throws IOException {
		File demo = new File("demo"); //在当前工程下创建demo目录
		if(!demo.exists()){
			demo.mkdir();
		}
		File file = new File(demo,"randomAccessFile.dat");
		if(!file.exists()){
			file.createNewFile();
		}
		RandomAccessFile raf = new RandomAccessFile(file,"rw");
		//查看指针的位置
		System.out.println("当前指针的位置："+raf.getFilePointer());
		
		//只写一个字节
		raf.write('A');
		System.out.println("写入一个字节后的指值位置："+raf.getFilePointer());
		raf.write('B');
		System.out.println("写入一个字节后的指值位置："+raf.getFilePointer());
		System.out.println("写入AB站用两个字节数");
		
		int i = 0x7fffffff;
		//用writer方法每次只能写入一个字节，如果要把i写进去就得写4次
		System.out.println(i);
		raf.write(i >>> 24); //高8位
		raf.write(i >>> 16);
		raf.write(i >>> 8);
		raf.write(i);
		System.out.println("将"+i+"写入一个字节后的指值位置："+raf.getFilePointer());
		System.out.println("写入一个最大值的整数站用四个字节数");
		
		//也可以直接写入int
		//raf.write(i);
		
		String string = "中";
		byte[] gbk = string.getBytes("gbk");
		//gbk一个中文站用两个字节数
		System.out.println("中字的长度："+gbk.length);
		raf.write(gbk);
		System.out.println("目前文件的长度为："+raf.length());
		System.out.println("当前指针的位置是："+raf.getFilePointer());
		
		//读文件，必须指指针指移到头部
		raf.seek(0);
		byte[] buf = new byte[(int)raf.length()];
		raf.read(buf);
		System.out.println(Arrays.toString(buf));
		for (byte b : buf) {
			System.out.println(Integer.toHexString(b & 0xff)+" ");
		}
		raf.close();
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
