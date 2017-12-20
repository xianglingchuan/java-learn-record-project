package com.learn.myString;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.ObjectReader;


public class ObjectMapperTest {

	/**
	 * ObjectMapper类是Jackson库的主要类。它提供一些功能将转换成Java对象匹配JSON结构，反之亦然。
	 * 它使用JsonParser和JsonGenerator的实例实现JSON实际的读/写。
	 * Jackson可以轻松的将Java对象转换成json对象和xml文档，同样也可以将json、xml转换成Java对象。 
	 * 
	 */
	
	public static void main(String[] args) {

        //-------------------------------------
        //将java对象转换成json字符串
        //-------------------------------------		
		AccountBean bean = new AccountBean();
        bean.setAddress("china-Guangzhou");
        bean.setEmail("hoojo_@126.com");
        bean.setId(1);
        bean.setName("hoojo");
        ObjectMapper objectMapper = new ObjectMapper();
        try {
			String str = objectMapper.writeValueAsString(bean);
			System.out.println("str:"+str);
		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
        


        //-------------------------------------
        //将map转换成json字符串
        //-------------------------------------        
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("name", bean.getName());
        map.put("account", bean);        
        bean = new AccountBean();
        bean.setAddress("china-Beijin");
        bean.setEmail("hoojo@qq.com");
        map.put("account2", bean);       
        try {
			System.out.println(objectMapper.writeValueAsString(map));
		} catch (JsonGenerationException e1) {
			e1.printStackTrace();
		} catch (JsonMappingException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
        
        
        
        //将list集合转换成json字符串        
        List<AccountBean> list = new ArrayList<AccountBean>();
        list.add(bean);
        bean = new AccountBean();
        bean.setId(2);
        bean.setAddress("address2");
        bean.setEmail("email2");
        bean.setName("haha2");
        list.add(bean);
        
        try {
			System.out.println(objectMapper.writeValueAsString(list));
		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
        
        
        
        
        
	}
	
	
	
	
}
