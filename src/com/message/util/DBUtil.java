package com.message.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class DBUtil {

	public static Connection connection;
	
	static{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/learn?useUnicode=true&characterEncoding=UTF-8","root","111111");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * 执行SQL语句
	 * @param sql
	 * @param List<String>
	 * @throws SQLException 
	 * 
	 * */
	public static ResultSet executeQuery(String sql, List<String> paramerList){
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement(sql.toString());
			if(paramerList.size()>=1){
				for(int i=0; i<paramerList.size(); i++){
					//这里要将i+1才行，因为sql语句中的?号是从1一始数，并不是从0开如数的
					statement.setString(i+1, paramerList.get(i));
				}				
			}		
			System.out.println(statement.toString());
			ResultSet resultSet = statement.executeQuery();	
			return resultSet;			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(statement!=null){
				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return null;
	}
	
	
	
}
