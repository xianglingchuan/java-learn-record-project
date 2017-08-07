package com.gson;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.springframework.core.env.SystemEnvironmentPropertySource;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.gson.bean.User;
import com.gson.bean.UserBirthday;


public class GsonReadFile {
	
	public static void main(String[] args) {
		
		try {
			//readFile2();
			//readFile();
			readFileBrithday();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public static void readFile() throws IOException{
		String fileName = "user.properties";
		File file = new File(fileName);
		
		
		//		System.out.println("filePath:"+file.getPath());
		//		FileInputStream fileInputStream = new FileInputStream(new File(fileName));
		//		byte[] byteData = new byte[1024];
		//		fileInputStream.read(byteData);		
		//		String data = new String(byteData);
		//		System.out.println("data:"+data);
		//		System.out.println("data.length:"+data.length());
		
		
		StringBuilder result = new StringBuilder();
		BufferedReader bufferedReader = new BufferedReader(new FileReader(new File(fileName)));
		String str = null;
		while((str = bufferedReader.readLine())!=null){
			result.append(str);
		}
		System.out.println("result:"+result);
		System.out.println("result.length:"+result.length());
				
		
		Gson gson = new Gson();
		User user =  gson.fromJson(result.toString(), User.class);
		System.out.println("name:"+user.getName());
		
	}
	
	
	public static void readFile2() throws IOException{
		File file = new File(GsonReadFile.class.getResource("user.properties").getFile());
		System.out.println("filePath:"+file.getPath());
		String content = FileUtils.readFileToString(file);
		System.out.println("content:"+content);
		System.out.println("content.length:"+content.length());
		Gson gson = new Gson();
		User user =  gson.fromJson(content, User.class);
		System.out.println("name:"+user.getName());
	}	
	
	
	
	public static void readFileBrithday() throws IOException{
		File file = new File(GsonReadFile.class.getResource("user.properties").getFile());
		System.out.println("filePath:"+file.getPath());
		String content = FileUtils.readFileToString(file);
		System.out.println("content:"+content);
		System.out.println("content.length:"+content.length());
		//Gson gson = new Gson();
		Gson gson = new GsonBuilder().setDateFormat("yyyy-mm-dd").create();
		UserBirthday user =  gson.fromJson(content, UserBirthday.class);
		System.out.println("name:"+user.getName());
		Date date = user.getBirthday();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-mm-dd");
        
        String dateStr = simpleDateFormat.format(user.getBirthday());
        System.out.println("name:"+dateStr);
        
        System.out.println("expand.city:"+user.getExpand().getCity());
        
        System.out.println("major:"+user.getMajor());
        System.out.println("major.object:"+user.getMajor().getClass());
        
	}
	

}
