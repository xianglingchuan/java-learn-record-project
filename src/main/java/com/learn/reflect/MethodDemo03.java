package com.learn.reflect;

import com.learn.reflect.bean.User;
import com.learn.reflect.util.BeanUtil;

public class MethodDemo03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		User user = new User("xlc","123456",33);
		System.out.println(BeanUtil.getValueByPropertyName(user, "username"));
		System.out.println(BeanUtil.getValueByPropertyName(user, "password"));
		System.out.println(BeanUtil.getValueByPropertyName(user, "age"));
	}

}
