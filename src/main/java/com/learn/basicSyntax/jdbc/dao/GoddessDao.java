package com.learn.basicSyntax.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.learn.basicSyntax.jdbc.model.Goddess;
import com.learn.basicSyntax.jdbc.util.DBUtil;

public class GoddessDao {

	/*
	 * 添加
	 * 
	 * */
	public int createGoddess(Goddess goddess) throws SQLException{
		Connection conn =  DBUtil.getConnection();	
		String sql = "INSERT INTO goddess(user_name, sex, age, birthday, email, mobile, create_user, create_date, update_user, update_date, isdel) "
				+ "values(?,?,?,?,?,?,?,current_date(),?,current_date(),?)";
		PreparedStatement preparedStatement =conn.prepareStatement(sql);
		preparedStatement.setString(1, goddess.getUserName());
		preparedStatement.setInt(2, goddess.getSex());
		preparedStatement.setInt(3, goddess.getAge());
		preparedStatement.setDate(4, goddess.getBirthday());
		preparedStatement.setString(5, goddess.getEmail());
		preparedStatement.setString(6, goddess.getMobile());
		preparedStatement.setString(7, goddess.getCreateUser());
		preparedStatement.setString(8, goddess.getUpdateUser());
		preparedStatement.setInt(9, goddess.getIsdel());
		return preparedStatement.executeUpdate();
	}
	
	
	/*
	 * 修改
	 * 
	 * */
	public int updateGoddess(Goddess goddess) throws SQLException{
		Connection conn =  DBUtil.getConnection();	
		String sql = "UPDATE goddess set user_name=?, sex=?, age=?, birthday=?, email=?, mobile=?, update_user=?, update_date=current_date() "
				+ " WHERE id=? ";
		PreparedStatement preparedStatement =conn.prepareStatement(sql);
		preparedStatement.setString(1, goddess.getUserName());
		preparedStatement.setInt(2, goddess.getSex());
		preparedStatement.setInt(3, goddess.getAge());
		preparedStatement.setDate(4, goddess.getBirthday());
		preparedStatement.setString(5, goddess.getEmail());
		preparedStatement.setString(6, goddess.getMobile());
		preparedStatement.setString(7, goddess.getUpdateUser());
		
		preparedStatement.setInt(8, goddess.getId());
		return preparedStatement.executeUpdate();
	}
	
	/*
	 * 删除
	 * 
	 * */
	public int delGoddess(int id) throws SQLException{
		Connection conn =  DBUtil.getConnection();	
		String sql = "DELETE FROM goddess WHERE id=? ";
		PreparedStatement preparedStatement =conn.prepareStatement(sql);
		preparedStatement.setInt(1, id);
		return preparedStatement.executeUpdate();
	}
	
	/*
	 * 查询多条
	 * 
	 * */
	public List<Goddess> query() throws SQLException{
		Connection conn =  DBUtil.getConnection();	
		String sql = "SELECT * FROM goddess";
		PreparedStatement preparedStatement =conn.prepareStatement(sql);
		ResultSet resultSet = preparedStatement.executeQuery();
		List<Goddess> list = new ArrayList<Goddess>();
		Goddess goddess = null;
		while(resultSet.next()){
			goddess = this.readResultSet(resultSet);
			list.add(goddess);
		}
		return list;
	}
	
	
	/*
	 * 查询多条
	 * 
	 * */
	public List<Goddess> query(List<Map<String, String>> paramers) throws SQLException{
		Connection conn =  DBUtil.getConnection();	
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT * FROM goddess WHERE 1=1 ");
		if(paramers!=null && paramers.size()>=1){
			for (Map<String, String> map : paramers) {
				if(!map.isEmpty()){
					sql.append(" "+map.get("condition")+" "+map.get("name")+" "+map.get("rela")+" "+map.get("value"));
				}
			}
		}
	    System.out.println(sql.toString());
		PreparedStatement preparedStatement =conn.prepareStatement(sql.toString());
		ResultSet resultSet = preparedStatement.executeQuery();
		List<Goddess> list = new ArrayList<Goddess>();
		Goddess goddess = null;
		while(resultSet.next()){
			goddess = this.readResultSet(resultSet);
			list.add(goddess);
		}
		return list;
	}
	
	
	
	/*
	 * 查询单条记录 - 根据ID号
	 * 
	 * */
	public Goddess get(int id) throws SQLException{
		Connection conn =  DBUtil.getConnection();	
		String sql = "SELECT * FROM goddess WHERE id=? ";
		PreparedStatement preparedStatement =conn.prepareStatement(sql);
		preparedStatement.setInt(1, id);
	    ResultSet resultSet = preparedStatement.executeQuery();
	    Goddess goddess = null;
	    while(resultSet.next()){
	    	goddess = this.readResultSet(resultSet);
	    }
	    return goddess;
	}
	
	
	/*
	 * ResultSet内容的对应
	 * 
	 * */	
	private Goddess readResultSet(ResultSet resultSet) throws SQLException{
		Goddess goddess =new Goddess();
    	goddess.setId(resultSet.getInt("id"));
    	goddess.setUserName(resultSet.getString("user_name"));
    	goddess.setAge(resultSet.getInt("age"));
    	goddess.setSex(resultSet.getInt("sex"));
    	goddess.setEmail(resultSet.getString("email"));
    	goddess.setBirthday(resultSet.getDate("birthday"));
    	goddess.setMobile(resultSet.getString("mobile"));
    	goddess.setCreateDate(resultSet.getDate("create_date"));
    	goddess.setCreateUser(resultSet.getString("create_user"));
    	goddess.setUpdateDate(resultSet.getDate("update_date"));
    	goddess.setUpdateUser(resultSet.getString("update_user"));
    	goddess.setIsdel(resultSet.getInt("isdel"));	
    	return goddess;
	}
	
	
}
