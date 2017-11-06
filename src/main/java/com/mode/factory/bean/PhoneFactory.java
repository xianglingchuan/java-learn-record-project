package com.mode.factory.bean;

import java.util.Map;

import com.mode.factory.util.PropertiesUtil;

/**
 * 
 * 打电话的工厂类
 * 
 */
public class PhoneFactory {

	
	public PhoneInterface getPhone(String key) {
		if ("iphone".equals(key)) {
			return new Iphone();
		} else if ("ophone".equals(key)) {
			return new Ophone();
		}
		return null;
	}
	
	
	public PhoneInterface getPhoneByClass(String className){
		try {
			return (PhoneInterface) Class.forName(className).newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	
	public PhoneInterface getPhoneByClassSimpName(String className){
		try {
			 Map<String, String> map = new PropertiesUtil().getProperties();
			 return (PhoneInterface) Class.forName(map.get(className)).newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}
	

}
