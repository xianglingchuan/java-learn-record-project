package com.learn.basicSyntax.string;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Demo13Date {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//将Date对象转换为指定日期格式字符串
		Date date = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String today = simpleDateFormat.format(date);
		System.out.println(today);
		
		
		//将指定日期格式字符串转换成Date对象
	    String string = "1986年01月21";
	    SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyy年MM月dd");
	    try {
			Date date2 = simpleDateFormat2.parse(string);
			today = simpleDateFormat.format(date2);
			System.out.println(today);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

	}

}
