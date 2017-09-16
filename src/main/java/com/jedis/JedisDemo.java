package com.jedis;

import org.hibernate.validator.internal.util.privilegedactions.GetResource;
import org.junit.Test;
import org.omg.CORBA.SystemException;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class JedisDemo {

	
	/**
	 *  单实例的测试
	 */
	@Test
	public void demo1(){
		//1、设备IP地址和端口号
		Jedis jedis = new Jedis("127.0.0.1",6379);
		//2、保存数据
		jedis.set("name", "jedis");
		//3、读取数据
		String value = jedis.get("name");
		System.out.println("value:"+value);
		//4、释放资源
		jedis.close();
	}
	
	/**
	 * 连接池方式连接 
	 */
	@Test
	public void demo2(){
		//获得连接池的配置
		JedisPoolConfig jPoolConfig = new JedisPoolConfig();
		//设备最大连接数
		jPoolConfig.setMaxTotal(30);
		jPoolConfig.setMaxIdle(10);
		
		//获得连接池
		JedisPool jedisPool = new JedisPool(jPoolConfig,"127.0.0.1",6379);
		
		//获得核心对象
		Jedis jedis = null;
		
		try {
			jedis = jedisPool.getResource();
			jedis.set("name", "idle");
			String name = jedis.get("name");
			System.out.println("name:"+name);
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(jedis!=null){
				jedis.close();
			}
			if(jedisPool!=null){
				jedisPool.close();
			}
		}
		
	}
	
}







