package com.ioc.beanannotation.multibean;

import java.util.List;
import java.util.Map;

import org.apache.catalina.tribes.group.interceptors.TwoPhaseCommitInterceptor.MapEntry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class BeanInvoker {
	
	
	@Autowired
	private List<BeanInterface> list;
	
	
	@Autowired
	private Map<String, BeanInterface> map;
	

	@Autowired
	@Qualifier("beanTwo")
	private BeanInterface beanInterface;
	
	
	
	public void say(){
	     if(list!=null && list.size()>=1){
	    	System.out.println("list.....size:"+list.size());
	    	for (BeanInterface beanInterface : list) {
				System.out.println(beanInterface.getClass().getName());
			}	    	 
	     }else{
	    	 System.out.println("List<BeanInterface> list is null..");
	     }
	     
	     if(map!=null && map.size()>=1){
	    	 System.out.println("map.....size:"+map.size());
	    	 for(Map.Entry<String, BeanInterface> entry : map.entrySet()){
	    		 System.out.println(entry.getKey()+" "+entry.getValue().getClass().getName());	    		 
	    	 }	    	 
	     }else{
	    	 System.out.println("Map<String, BeanInterface> map is null..");
	     }
	     
	     if(beanInterface!=null){
	    	 System.out.println("beanInterface name: "+beanInterface.getClass().getName());
	     }else{
	    	 System.out.println("beanInterface is null");
	     }
	     
	}	
}
