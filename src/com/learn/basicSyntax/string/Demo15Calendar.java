package com.learn.basicSyntax.string;

import java.util.Calendar;
import java.util.Date;

public class Demo15Calendar {

	public static void main(String[] args) {
		
		Calendar calendar = Calendar.getInstance();
		
		calendar.set(1986, 01, 21);
		
		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH)+1;
		int day = calendar.get(Calendar.DAY_OF_MONTH);
		int hour = calendar.get(Calendar.HOUR_OF_DAY);
		int minute = calendar.get(Calendar.MINUTE);
		int second = calendar.get(Calendar.SECOND);
		System.out.println(year+"年"+month+"月"+day+"日"+" "+hour+"时"+minute+"分"+second+"分");
		
		//获取Date对象
		Date date = calendar.getTime();
		System.out.println(date.toString());
		
		//获取录前毫秒数
		long time = calendar.getTimeInMillis();
		System.out.println("距离当前的毫秒数:"+time);

	}

}
