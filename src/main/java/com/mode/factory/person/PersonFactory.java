package com.mode.factory.person;

import org.springframework.http.StreamingHttpOutputMessage.Body;

/**
 * 人物工厂类
 * 
 * */
public interface PersonFactory {
	

	public Boy getBoy();
	
	public Girl getGirl();

}
