package com.learn.basicSyntax.jdbc;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.learn.basicSyntax.jdbc.dao.GoddessDao;
import com.learn.basicSyntax.jdbc.model.Goddess;
import com.xiaomi.xmpush.server.Result;

public class Main {

	public static void main(String[] args) throws SQLException {
//		 GoddessDao goodessDao = new GoddessDao();
//		 Goddess goddess = new Goddess();
//		 goddess.setUserName("小夏");
//		 goddess.setAge(23);
//		 goddess.setBirthday(new Date(System.currentTimeMillis()));
//		 goddess.setSex(1);
//		 goddess.setMobile("1381111111");
//		 goddess.setCreateDate(new Date(System.currentTimeMillis()));
//		 goddess.setCreateUser("ADMIN");
//		 goddess.setUpdateDate(new Date(System.currentTimeMillis()));
//		 goddess.setUpdateUser("ADMIN");
//		 goddess.setIsdel(0);
//		 goddess.setEmail("XiaoXia@163.com");
//		 int result = goodessDao.createGoddess(goddess);
//		 System.out.println("result："+result);
//		 if(result==1){
//		 System.out.println("添加成功!");
//		 }else{
//		 System.out.println("添加失败!");
//		 }

		// GoddessDao goodessDao = new GoddessDao();
		// int result = goodessDao.delGoddess(6);
		// System.out.println("result："+result);
		// if(result==1){
		// System.out.println("删除成功!");
		// }else{
		// System.out.println("删除失败!");
		// }

//		GoddessDao goodessDao = new GoddessDao();
//		Goddess goddess = goodessDao.get(1);
//		if (goddess != null) {
//			goddess.setAge(38);
//			int result = goodessDao.updateGoddess(goddess);
//			if (result == 1) {
//				System.out.println("修改成功!");
//			} else {
//				System.out.println("修改失败!");
//			}
//		}

		GoddessDao goodessDao = new GoddessDao();
		//List<Goddess> list = goodessDao.query();
		List<Map<String, String>> paramers = new ArrayList<Map<String,String>>();
		Map<String,String> paramer = new HashMap<String,String>();
		paramer.put("condition", "AND");
		paramer.put("name", "user_name");
		paramer.put("rela", "like");
		paramer.put("value", "'%小%'");
		paramers.add(paramer);
		
		
		paramer.put("condition", "AND");
		paramer.put("name", "mobile");
		paramer.put("rela", "like");
		paramer.put("value", "'%139%'");
		paramers.add(paramer);		
		
//		paramer.put("condition", "OR");
//		paramer.put("name", "user_name");
//		paramer.put("rela", "=");
//		paramer.put("value", "'小溪'");	
//		paramers.add(paramer);
		
		List<Goddess> list = goodessDao.query(paramers);
		for (Goddess goddess : list) {
			System.out.println(goddess.toString());
		}
		
		
	}

}
