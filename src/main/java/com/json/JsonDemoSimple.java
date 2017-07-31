package com.json;

import java.util.ArrayList;
import java.util.HashMap;

import org.json.JSONObject;

import com.json.bean.User;
import com.json.bean.UserExpand;

public class JsonDemoSimple {

	public static void main(String[] args) {

		//createUserJson();
		//createUserJsonByMap();
		createUserJsonByBean();

	}

	public static void createUserJson() {

		Object nullObject = null;

		JSONObject object = new JSONObject();
		object.put("name", "jake");
		object.put("age", 22.2);
		object.put("birthday", "1989-01-01");
		object.put("car", true);
		object.put("house", nullObject);
		object.put("major", new String[] { "英语", "挖掘机" });
		object.put("office_city", new ArrayList<>());

		JSONObject expandObject = new JSONObject();
		expandObject.put("city", "深圳");
		expandObject.put("province", "广东省");
		object.put("expand", expandObject);

		System.out.println(object.toString());
	}
	
	public static void createUserJsonByMap(){
		java.util.Map<String, Object> maps = new HashMap<String,Object>();
		
		Object nullObject = null;
		maps.put("name", "jake");
		maps.put("age", 22.2);
		maps.put("birthday", "1989-01-01");
		maps.put("car", true);
		maps.put("house", nullObject);
		maps.put("major", new String[] { "英语", "挖掘机" });
		maps.put("office_city", new ArrayList<>());

		JSONObject expandObject = new JSONObject();
		expandObject.put("city", "深圳");
		expandObject.put("province", "广东省");
		maps.put("expand", expandObject);
		
		System.out.println(new JSONObject(maps));
	}
	
	
	
	public static void createUserJsonByBean(){
		User user = new User();
		
		
		user.setName("jake");
		user.setAge(22.2f);
		user.setBirthday("1989-01-01");
		user.setCar(true);
		user.setHouse(false);
		user.setMajor(new String[] { "英语", "挖掘机" });
		
		UserExpand expand = new UserExpand();
		expand.setCity("深圳");
		expand.setProvince("广东省");
		user.setExpand(expand);
		
		System.out.println(new JSONObject(user));
			
		
		
	}
	
	

}
