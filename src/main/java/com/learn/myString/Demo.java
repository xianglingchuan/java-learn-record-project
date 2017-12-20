package com.learn.myString;

import java.io.IOException;


import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

public class Demo {

	public static void main(String[] args) {
		
		//1、普通字符串反斜杠做为转义字符串存在,输出时不会显示
		String strA = "[{\"10844791.mp3\":\"cloudMusic\",\"t\":316}]";
		System.out.println("strA:"+strA);
		
		//2、如果想输出反斜框需要在前面添加转义符
		String strB = "[{\\\"10844791.mp3\\\":\\\"cloudMusic\\\",\\\"t\\\":316}]";
		System.out.println("strB:"+strB);
		//替换反斜杠为空
		String strC = strB.replaceAll("\\\\\"", "\"");
		System.out.println("strC:"+strC);
	
		
		//3、通过ObjectMapper.writeValueAsString后的字符串反斜杠替换
		String str = "[{\"10844791.mp3\":\"cloudMusic\",\"t\":241}]";
		System.out.println("原始字符串:" + str);
		ObjectMapper mapper = new ObjectMapper();
		String content = "";
		try {
			//通过ObjectMapper.writeValueAsString后
			content = mapper.writeValueAsString(str);
			System.out.println("通过ObjectMapper:"+content);
			System.out.println("替换又引号为空: "+content.replaceAll("\"", ""));
			System.out.println("替换反斜框为空: "+str.replaceAll("\\\\",""));
		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
		


	}

}
