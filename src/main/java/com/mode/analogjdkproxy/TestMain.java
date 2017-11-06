package com.mode.analogjdkproxy;

import java.lang.reflect.Proxy;

import com.mode.analogjdkproxy.proxy.DTrain;
import com.mode.analogjdkproxy.proxy.DTrainMoveable;

public class TestMain {

	public static void main(String[] args) {

		DTrain train = new DTrain();
		TimeHandler h = new TimeHandler(train); 
		Class<?> class1 = train.getClass(); //注意,这里获取的是实现类的Class信息
		
		//这里返回的是实现接口类的类名进行转换即可
		DTrainMoveable dtrain = (DTrainMoveable)Proxy.newProxyInstance(class1.getClassLoader(), class1.getInterfaces(), h);
		dtrain.move();
		
		System.out.println(dtrain.getClass().getName());
		
	}

}
