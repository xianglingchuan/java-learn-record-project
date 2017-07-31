package com.gson;

import java.lang.reflect.Field;

import com.google.gson.FieldNamingStrategy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.gson.bean.User;
import com.gson.bean.UserExpand;

public class GsonCreateSimple {

	
	public static void main(String[] args) {
		
		createGson();
	}
	
	
	public static void createGson(){
		User user = new User();	
		user.setName("jake");
		user.setAge(22.2f);
		user.setBirthday("1989-01-01");
		user.setCar(true);
		user.setHouse(false);
		user.setMajor(new String[] { "英语", "挖掘机" });
		user.setOffice_city(new String[]{"北京","成功","深圳"});
		
		UserExpand expand = new UserExpand();
		expand.setCity("深圳");
		expand.setProvince("广东省");
		user.setExpand(expand);	
		user.setIgnore("忽略属性");
		
		
		//美化json输出的样式
		GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.setPrettyPrinting();
		
		//在json输出的过程进行操作
		gsonBuilder.setFieldNamingStrategy(new FieldNamingStrategy() {
			
			@Override
			public String translateName(Field field) {
				if(field.getName().equals("name")){
					return "NAME";
				}
				return field.getName();
			}
		});
		
		
		Gson gson = gsonBuilder.create();
		
		
		
		
		
		//Gson gson = new Gson();
		System.out.println(gson.toJson(user));
		
		
		
		
	}
	
	
}
