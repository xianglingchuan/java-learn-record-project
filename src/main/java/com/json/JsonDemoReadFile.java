package com.json;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.ibatis.javassist.expr.NewArray;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.core.env.SystemEnvironmentPropertySource;

import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonObjectFormatVisitor;
import com.json.bean.UserExpand;
import com.mysql.cj.xdevapi.JsonArray;

public class JsonDemoReadFile {
	
	public static void main(String[] args) {
		
		try {
			readFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public static void readFile() throws IOException{
		String fileName = "user.properties";
		FileInputStream fileInputStream = new FileInputStream(new File(fileName));
		
		
		
		byte[] byteData = new byte[1024];
		fileInputStream.read(byteData);
		
		String data = new String(byteData);
		JSONObject object =  new JSONObject(data);
		String name = object.get("name").toString();
		System.out.println("name:"+name);
		System.out.println("age:"+object.getDouble("age"));
		System.out.println("car:"+object.getBoolean("car"));
		System.out.println("house:"+object.getBoolean("house"));
		
		if(!object.isNull("nickname")){
			System.out.println("nickname:"+object.getBoolean("nickname"));
		}else{
			System.out.println("nickname is null");
		}
		
		
		JSONObject userExpand = object.getJSONObject("expand");
		System.out.println("userExpand.city:"+userExpand.get("city"));
		System.out.println("userExpand.province:"+userExpand.get("province"));
		
	    JSONArray major = object.getJSONArray("major");
	    for(int i=0; i<major.length(); i++){
	    	System.out.println("专业-"+(i+1)+major.getString(i));
	    }
		
		
			
	}
	

}
