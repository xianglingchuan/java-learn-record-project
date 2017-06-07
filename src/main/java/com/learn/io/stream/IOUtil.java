package com.learn.io.stream;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.print.DocFlavor.INPUT_STREAM;

import org.apache.coyote.http11.filters.BufferedInputFilter;

public class IOUtil {
	
	/*
	 * 读取指定文件内容，按照16进制输出在控制台
	 * 并且每输出10个byte换行
	 * @param fileName
	 * 音字节读取不适合文件，大文件效率很低
	 * */
	public static void printHex(String fileName) throws IOException{
		FileInputStream in = new FileInputStream(fileName);
		int b;
		int i = 1;
		
		while((b=in.read())!=-1){
			if(b <= 0xf){
			    //单位数前面补0
				System.out.print("0");
			}			
			System.out.print(b+" ");
			if(((i++)%10)==0){
				System.out.println("");
			}
		}
		in.close();
	}
	
	/*
	 * 批量读取，对大文件而言效率高，也是我们最常用的读文件方式
	 * @param fileName
	 * @throws IOException
	 * 
	 * */
	public static void printHexByByteArray(String fileName) throws IOException{
		
		FileInputStream in = new FileInputStream(fileName);
		byte[] buf = new byte[200];
		//从in中批量读取字节，放入到buf这个字节数组中
		//从0个位置开始放，最多放buf.lenght
		//返回的是读到的字节的个数
		//一次性读完，说明字节数且足够大
		/*int bytes = in.read(buf, 0, buf.length); //返回的是读到的字节的个数
		int j = 1;
		for(int i=0; i<bytes; i++){
			//为了避免数据转换错误，通过&0xff将高24位清零
		    //此方法返回的字符串表示的无符号整数参数所表示的值以十六进制（基数为16）
			//System.out.print(Integer.toHexString(buf[i] & 0xff)+" ");
			System.out.print(Integer.toHexString(buf[i] & 0xff)+" ");
			if(j++%10==0){
				System.out.println("");
			}
		}*/
		
		
		//第二种同样用while方式读取
		int bytes;
		int b = 1;
		while( (bytes=in.read(buf, 0, buf.length)) !=-1 ){
			System.out.println("读取了每几次："+b);
			int j=1; 
			for(int i=0; i<bytes; i++){
				System.out.print(buf[i]+" ");
				if(j++%10==0){
					System.out.println("");
				}
			}
			b++;
		}
		in.close();
	}
	
	/*
	 * 文件拷贝 批量读取文件内容
	 * @param srcFile
	 * @param descFile
	 * @throws Exception 
	 * */
	public static void copyFile(File srcFile, File destFile) throws IOException{
		if(!srcFile.exists()){
			throw new IllegalArgumentException("文件:"+srcFile+"不存在");
		}
		if(!srcFile.isFile()){
			throw new IllegalArgumentException("文件:"+srcFile+"不是有效的文件");
		}
		FileInputStream inputStream  = new FileInputStream(srcFile);
		FileOutputStream outputStream = new FileOutputStream(destFile);
		byte[] buf = new byte[20*1024];
		int b;
		while( (b=inputStream.read(buf, 0, buf.length))!=-1){
			outputStream.write(buf, 0, b);
			outputStream.flush(); //最好加上
		}
		inputStream.close();
		outputStream.close();
	}
	
	/*
	 * 使用BuferedInputStream进行文件写入操作
	 * 进行文件的拷贝，利用带缓冲的字节流
	 * @param srcFile
	 * @param descFile
	 * @throws Exception
	 * 
	 * */
	public static void copyFileByBuffer(File srcFile, File descFile) throws Exception{
		if(!srcFile.exists()){
			throw new IllegalArgumentException("文件:"+srcFile+"不存在");
		}
		if(!srcFile.isFile()){
			throw new IllegalArgumentException("文件:"+srcFile+"不是有效的文件");
		}
	   
		BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(srcFile));
		BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(descFile));
		int b;
		while( (b=bufferedInputStream.read()) != -1){
			bufferedOutputStream.write(b);
			bufferedOutputStream.flush(); //必须要刷新缓冲区
		}
		bufferedInputStream.close();
		bufferedOutputStream.close();
	}
	
	
	/*
	 * 进行文件的拷贝，不带缓冲的字节流
	 * @param srcFile
	 * @param descFile
	 * @throws Exception
	 * 
	 * */	
	public static void copyFileByByte(File srcFile, File descFile) throws Exception{
		if(!srcFile.exists()){
			throw new IllegalArgumentException("文件:"+srcFile+"不存在");
		}
		if(!srcFile.isFile()){
			throw new IllegalArgumentException("文件:"+srcFile+"不是有效的文件");
		}
		FileInputStream inputStream = new FileInputStream(srcFile);
		FileOutputStream outputStream = new FileOutputStream(descFile);
		int b;
		while( (b=inputStream.read()) != -1){
			outputStream.write(b);
			outputStream.flush();
		}
		inputStream.close();
		outputStream.close();
	}
}














