package com.mode.factory;

import java.util.Map;

import com.mode.factory.bean.PhoneFactory;
import com.mode.factory.bean.PhoneInterface;
import com.mode.factory.util.PropertiesUtil;

public class CallPhone {

	
	public static void main(String[] args) {
		 //根据传入的值判断获取电话
		 //PhoneInterface phone = new PhoneFactory().getPhone("iphone");
		 //phone.call();
		
		 //根据全整的类名获取电话
		 //PhoneInterface phone = new PhoneFactory().getPhoneByClass("com.mode.factory.bean.Ophone");
		 //phone.call();
		 
		 //根据配置的短名称获取类信息
		PhoneInterface phone = new PhoneFactory().getPhoneByClassSimpName("vivophone");
		phone.call();
		
		
	}
	
	
}
