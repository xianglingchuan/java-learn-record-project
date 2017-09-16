//package com.springmvc.course.bean;
//
//import java.util.Properties;
//
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Component;
//
//@Component
//public class SysConf {
//
//    //@Value("#{sys.test}") 
//	@Value("#{config[test]}")
//    private String test;  
//  
//    public String getTest() {
//		return test;
//	}
//
//	//@Value("#{sys.test}")  
//    @Value("#{config[test]}")
//    public void setTest(String test){  
//        this.test = test;  
//    }  
//  
//    //@Value("#{sys}")  
//    public void setSysConf(Properties sys){  
//        this.test= sys.getProperty("test");  
//    } 
//    
//	
//}
