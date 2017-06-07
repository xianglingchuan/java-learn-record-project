package com.learn.basicSyntax;

import java.sql.Array;
import java.util.Arrays;

public class DemoArray {

	public static void main(String[] args) {
		
		// 定义一个长度为5的字符串数组，保存考试科目信息
		String[] subjects = new String[5];
        // 分别为数组中的元素赋值
		subjects[0] = "Oracle";
		subjects[1] = "PHP";
		subjects[2] = "Linux";
		subjects[3] = "Java";
		subjects[4] = "HTML";
        System.out.println("数组中第4个科目为：" + subjects[3]);	
        
        
        
		// 定义一个长度为 3 的字符串数组，并赋值初始值
		String[] hobbys = { "sports", "game", "movie" };
		System.out.println("循环输出数组中元素的值：");
		// 使用循环遍历数组中的元素
		for(int i=0; i<hobbys.length; i++){
		    System.out.print(hobbys[i]+",");
		}	
		
		
		/*
		1、 定义一个整型数组，并赋初值 61, 23, 4, 74, 13, 148, 20
		2、 定义变量分别保存最大值、最小值、累加值和平均值，并假设数组中的第一个元素既为最大值又为最小值
		3、 使用 for 循环遍历数组中的元素，分别与假定的最大值和最小值比较。如果比假定的最大值要大，则替换当前的最大值；如果比假定的最小值要小，则替换当前的最小值
		4、 循环执行过程中对数组中的元素进行累加求和
		5、 循环结束根据累加值计算平均值，并打印输出相关内容		
		*/
		int[] iArray = new int[] {61, 23, 4, 74, 13, 148, 20};
		int maxNum = 0;
		int minNum = 0;
		double iSum = 0;
		double iAvg = 0;
		maxNum = minNum = iArray[0];
		for(int i=0; i<iArray.length; i++){
			iSum += iArray[i];
			if(iArray[i] > maxNum){
				maxNum = iArray[i];
			}else if(iArray[i] < minNum){
				minNum = iArray[i];
			}			
		}
		iAvg = iSum/iArray.length;
		System.out.println();
		System.out.println("maxNum:"+maxNum);
		System.out.println("minNum:"+minNum);
		System.out.println("iSum:"+iSum);
		System.out.println("iAvg:"+iAvg);
		
		
		
		// 定义一个字符串数组
		String[] hobbys1 = { "sports", "game", "movie" };
        // 使用Arrays类的sort()方法对数组进行排序
		// 使用Arrays类的toString()方法将数组转换为字符串并输出
		System.out.println( Arrays.toString(hobbys1));
		
		Arrays.sort(iArray);
		System.out.println( Arrays.toString(iArray));
		
		
		
		
		// 定义一个整型数组，保存成绩信息
		int[] scores = { 89, 72, 64, 58, 93 };
        // 对Arrays类对数组进行排序
		Arrays.sort(scores);
		// 使用foreach遍历输出数组中的元素
		for ( int score : scores) {
			System.out.println(score);
		}		
		
		// 定义两行三列的二维数组并赋值
        String[][] names={{"tom","jack","mike"},{"zhangsan","lisi","wangwu"}};
        // 通过二重循环输出二维数组中元素的值
		for (int i = 0; i <names.length; i++) {
			for (int j = 0; j < names[i].length; j++) {
		       System.out.print(names[i][j]+",");
			}		   
			System.out.println();
		}
	}
}
