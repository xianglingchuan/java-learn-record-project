package com.learn.basicSyntax;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;

public class DemoMethod1 {

	public static void main(String[] args) {
		
		int[] scores = { 89, -23, 64, 91, 119, 52, 73};
		DemoMethod1 demoMethod1 = new DemoMethod1();
		demoMethod1.sortScore(scores);
		
		Scanner input = new Scanner(System.in);
		int num = input .nextInt();
		System.out.println(num );
	}
	
	
	
	/*
	要求：
	1、 考试成绩已保存在数组 scores 中，数组元素依次为 89 , -23 , 64 , 91 , 119 , 52 , 73
	2、 要求通过自定义方法来实现成绩排名并输出操作，将成绩数组作为参数传入
	3、 要求判断成绩的有效性（ 0—100 ），如果成绩无效，则忽略此成绩	 	 
	 * */
	public void sortScore(int[]  scores){
		Arrays.sort(scores);
		//定义显示有效成绩的人数
		int properNum = 3;
		int currentProperNum = 0;
		//开始倒序
		for (int i = scores.length-1; currentProperNum<properNum && i>0; i--){
			if(scores[i]>100 || scores[i]<0){
			   continue;	
			}
			currentProperNum++;
			System.out.println("成绩数:"+scores[i]);
		}
	}
	
	
	
}
