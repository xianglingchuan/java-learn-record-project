package com.learn.basicSyntax.leaseCarDemo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;

import com.learn.basicSyntax.leaseCarDemo.bean.Car;
import com.learn.basicSyntax.leaseCarDemo.bean.CustomerCar;
import com.learn.basicSyntax.leaseCarDemo.bean.FrirghtCar;
import com.learn.basicSyntax.leaseCarDemo.bean.PickupCar;

public class Main{

	
	public static void main(String[] args) throws IOException {
		
		System.out.println("欢迎使用租车系统!");
		System.out.println("您是否需要租车：1是 0否");
		
		ArrayList<Car> caArrayList = new ArrayList<Car>();
		Car CarOne = new CustomerCar("奥迪A4", 500f, 4);
	    Car CarTwo = new CustomerCar("马自达6", 400f, 4);
		Car CarThree = new PickupCar("皮卡雪6", 450f, 4, 2);
		Car CarFour = new CustomerCar("金龙", 800f, 20);
		Car CarFive = new FrirghtCar("松花江", 400f, 4);
		caArrayList.add(CarOne);
		caArrayList.add(CarTwo);
		caArrayList.add(CarThree);
		caArrayList.add(CarFour);
		caArrayList.add(CarFive);		
		
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		int value = new Integer(bufferedReader.readLine());
		//租车的数量
		if(1==value){
			System.out.println("您可租车的类型及其价目表：");
			int j = 1;
			for (Car car : caArrayList) {
				System.out.println("序号"+j+" "+car.getTitle()+" "+car.getRental()+"元/天"+" "+car.show());
				j++;
			}
			System.out.println("请输入你要租汽车的数量：");
			int leaseCarNumber = new Integer(bufferedReader.readLine());
			Map<Integer,Integer> inputLeaseCarMap = new HashMap<Integer,Integer>();
			
			//LinkedList<Map<Integer,Integer>> linkedList = new LinkedList<Map<Integer,Integer>>();
			LinkedHashMap linkedHashMap = new LinkedHashMap<>();
			
			for(int i=1; i<=leaseCarNumber; i++){
				System.out.println("请输入第"+i+"辆汽车的序号：");
				int carIndex = new Integer(bufferedReader.readLine());
				System.out.println("请输入第"+i+"辆汽车的租车天数：");
				int leaseCarDay = new Integer(bufferedReader.readLine());
				inputLeaseCarMap.put(carIndex, leaseCarDay);
				//Map<Integer,Integer> currentMap = new Map<carIndex, leaseCarDay>;
				linkedHashMap.put(carIndex, leaseCarDay);
			}
			Iterator<Map.Entry<Integer, Integer>> entries = inputLeaseCarMap.entrySet().iterator();
			while(entries.hasNext()){
				Map.Entry<Integer, Integer> entry = entries.next();
				//System.out.println(entry.getKey()+"="+entry.getValue());
			}
			float countPrice = 0f;
			System.out.println("您选择的租车信息如下：");
			for (Object key : linkedHashMap.keySet()) {
				//System.out.println("key:"+key+", value:"+linkedHashMap.get(key));
				int carIndex = (int)key-1;
				int days =(int)linkedHashMap.get(key);
				//开始计算车的价格
				String carTitle =  caArrayList.get(carIndex).getTitle();
				float carPrice = caArrayList.get(carIndex).getRental();
			    float carCountPrice = days * carPrice;
			    countPrice += carCountPrice;	
			    System.out.println(carTitle+" "+days+"天"+" "+carCountPrice+"元");
			}
			System.out.println("合计:"+countPrice);
		}else{
			System.out.println("希望您下次光临!");
		}
	}
}
