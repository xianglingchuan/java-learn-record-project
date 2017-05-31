package com.message.dao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.message.bean.Command;
import com.message.bean.CommandContent;
import com.message.bean.Message;
import com.message.util.DBMybatisUtil;

public class CommandContentDao {

	/**
	 * 通过MyBatis查询数据列表 
	 * */
	public List<CommandContent> queryList(CommandContent commandContent){
		SqlSession sqlSession = null;
		List<CommandContent> list = new ArrayList<CommandContent>();
		try {
			DBMybatisUtil dbMybatisUtil = new DBMybatisUtil();
			sqlSession = dbMybatisUtil.getSqlSession();
			list = sqlSession.selectList("CommandContent.queryList",commandContent);
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if(sqlSession!=null){
				sqlSession.close();
			}
		}		
		return list;
	}
	
	
	/**
	 * 查询一条语句
	 * */
	public CommandContent get(CommandContent entity){
		SqlSession sqlSession = null;
		CommandContent info = null;
		try {
			DBMybatisUtil dbMybatisUtil = new DBMybatisUtil();
			sqlSession = dbMybatisUtil.getSqlSession();
			info = sqlSession.selectOne("CommandContent.get", entity);
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if(sqlSession!=null){
				sqlSession.close();
			}
		}		
		return info;
	}		
	
	
	public int update(CommandContent entity){
		SqlSession sqlSession = null;
		int result = 0;
		try {
			DBMybatisUtil dbMybatisUtil = new DBMybatisUtil();
			sqlSession = dbMybatisUtil.getSqlSession();
			result = sqlSession.update("CommandContent.update", entity);
			sqlSession.commit();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if(sqlSession!=null){
				sqlSession.close();
			}
		}		
		return result;
	}
	
	
	public CommandContent findInfoByOneParam(Map<String, String> entity){
		SqlSession sqlSession = null;
		CommandContent content = new CommandContent();
		try {
			DBMybatisUtil dbMybatisUtil = new DBMybatisUtil();
			sqlSession = dbMybatisUtil.getSqlSession();
			content = sqlSession.selectOne("CommandContent.findInfoByOneParam", entity);
			sqlSession.commit();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if(sqlSession!=null){
				sqlSession.close();
			}
		}		
		return content;
	}
	
	
	
	
	
}
