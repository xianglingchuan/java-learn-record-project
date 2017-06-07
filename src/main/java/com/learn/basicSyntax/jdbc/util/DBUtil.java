package com.learn.basicSyntax.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUtil {

	private static String URL = "jdbc:mysql://127.0.0.1:3306/learn?useUnicode=true&characterEncoding=utf8";
	private static String USER = "root";
	private static String PASSWORD = "111111";
	private static Connection conn = null;

	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public static Connection getConnection(){
		return conn;
	}
	

	public static void main(String[] args) throws Exception {
		Connection conn =  DBUtil.getConnection();		
		Statement statement = conn.createStatement();
		ResultSet reSet = statement.executeQuery("SELECT user_name, age FROM goddess");
		while (reSet.next()) {
			System.out.println("姓名：" + reSet.getString("user_name") + ",年龄：" + reSet.getString("age"));
		}
	}

}
