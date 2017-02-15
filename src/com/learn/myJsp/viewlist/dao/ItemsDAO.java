package com.learn.myJsp.viewlist.dao;

import java.util.ArrayList;

import com.learn.myJsp.viewlist.entity.Items;
import com.learn.myJsp.viewlist.util.DBHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


/*
 * 产品业务逻辑类
 * 
 * */
public class ItemsDAO {

	// 获取所有产品列表信息
	public ArrayList<Items> getItemsAll() {
		Connection connection = null; // 数据库链接
		PreparedStatement preparedStateement = null;
		java.sql.ResultSet result = null; // 执行结果集
		ArrayList<Items> arrayList = new ArrayList<Items>(); // 返回的数组信息
		try {
			// 获取链接对象
			connection = DBHelper.getConnection();
			String sql = "select * from items;";
			preparedStateement = connection.prepareStatement(sql);
			result = preparedStateement.executeQuery();
			while (result.next()) {
				Items items = new Items();
				items.setId(result.getInt("id"));
				items.setCity(result.getString("city"));
				items.setName(result.getString("name"));
				items.setNumber(result.getInt("number"));
				items.setPrice(result.getInt("price"));
				items.setPicture(result.getString("picture"));
				arrayList.add(items);
			}
			return arrayList;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		// 操作完成以后释放相关资源信息
		finally {
			// ResultSet 对象
			if (result != null) {
				try {
					result.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				result = null;
			}

			// statement 对象
			if (preparedStateement != null) {
				try {
					preparedStateement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				preparedStateement = null;
			}
		}
	}

	// 根据ID获取单条记录信息
	public Items getItmesById(int id) {
		Connection connection = null; // 数据库链接
		PreparedStatement preparedStateement = null;
		java.sql.ResultSet result = null; // 执行结果集
		try {
			// 获取链接对象
			connection = DBHelper.getConnection();
			String sql = "select * from items WHERE id=?";
			preparedStateement = connection.prepareStatement(sql);
			preparedStateement.setInt(1, id);
			result = preparedStateement.executeQuery();
			if (result.next()) {
				Items items = new Items();
				items.setId(result.getInt("id"));
				items.setCity(result.getString("city"));
				items.setName(result.getString("name"));
				items.setNumber(result.getInt("number"));
				items.setPrice(result.getInt("price"));
				items.setPicture(result.getString("picture"));
				return items;
			} else {
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		// 操作完成以后释放相关资源信息
		finally {
			// ResultSet 对象
			if (result != null) {
				try {
					result.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				result = null;
			}

			// statement 对象
			if (preparedStateement != null) {
				try {
					preparedStateement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				preparedStateement = null;
			}
		}
	}

	// 根据保存的商品ID获取多条商品记录
	public ArrayList<Items> getViewList(String sViewList) {
		ArrayList<Items> arrayList = new ArrayList<Items>(); // 返回的数组信息
		int iCount = 5;
		String[] aViewList = sViewList.split(",");
		if (sViewList != null && aViewList != null) {
			if (aViewList.length >= 1) {
				iCount = aViewList.length>=iCount ? iCount : aViewList.length;
				for (int i = aViewList.length - 1; i > ((aViewList.length-1) - iCount); i--) {
					System.out.println(aViewList[i]);
					if(aViewList[i]!=""){
						Items items = new Items();
						items = getItmesById(Integer.parseInt(aViewList[i]));					
						if (items != null) {
							arrayList.add(items);
						}						
					}
				}
			}
			return arrayList;
		}else{			
			return null;
		}
	}

	public static void main(String[] args) {
		ItemsDAO itemsDAO = new ItemsDAO();
		ArrayList<Items> itemsAll = itemsDAO.getItemsAll();
		System.out.println("查询到的产品数量是:" + itemsAll.size());

		Items items = itemsDAO.getItmesById(1);
		System.out.println("查询到的单条产品信息是:" + items.toString());

		itemsAll = itemsDAO.getViewList("1,2");
		System.out.println("查询到的单条产品信息是(getViewList):" + itemsAll.size());

	}
}
