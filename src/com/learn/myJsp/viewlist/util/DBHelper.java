package com.learn.myJsp.viewlist.util;

import java.sql.DriverManager;
import java.sql.SQLException;

import java.sql.Connection;

/*
 * 数据库操作帮助类
 * 
 * */
public class DBHelper {

    public static final String driver = "com.mysql.jdbc.Driver"; //数据库驱动
    //链接数据库的URL地址
    public static final  String url="jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=UTF-8";
    public static final  String username = "root"; //数据库的用户名
    public static final  String password = "111111"; //数据库的密码

    
    private static  Connection connection;
    
    //静态代码块负责加载驱动
    static
    {
    	try{
    		Class.forName(driver);    		
    	}catch(Exception ex){
    		ex.printStackTrace();
    	}
    }
    
    
    //单列模式返回数据库链接对象
    public static  Connection getConnection(){
    	if(connection==null){
    		try {
				connection = DriverManager.getConnection(url, username, password);
			} catch (SQLException e) {
				e.printStackTrace();
			}    		
    	}
    	return connection;
    }
    
    
    
    public static void main(String[] args) {
    	Connection conn = DBHelper.getConnection();
    	if(conn!=null){
    		System.out.println("获取数据库链接成功!");
    	}else{
    		System.out.println("获取数据库链接失败!");
    	}
	}
}