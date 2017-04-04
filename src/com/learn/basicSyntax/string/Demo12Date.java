package com.learn.basicSyntax.string;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Timer;
import java.util.Date;

public class Demo12Date {

	public static void main(String[] args) {
		Date d = new Date(System.currentTimeMillis());
		System.out.println(d);
		
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String today = simpleDateFormat.format(d); //调用format()方法，格式化时间，转换为指定格式字符串
		System.out.println(today);
		
	    //将字符串转换为日期 
		String day = "2015年04月01 13:27:25";
		SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyy年MM月dd HH:mm:ss");
		try {
			Date date = (Date) simpleDateFormat2.parse(day);
			System.out.println(date.toString());
			today = simpleDateFormat.format(date);
			System.out.println(today);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
}
