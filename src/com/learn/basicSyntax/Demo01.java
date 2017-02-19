package com.learn.basicSyntax;

import java.util.Scanner;

public class Demo01 {

   public static void main(String[] args){
	   
	   Scanner input = new Scanner(System.in);
	   System.out.print("请输入学生成绩:");
	   int score = input.nextInt();
	   System.out.println("输入的成绩"+score);
	   
	   //变量保存加分次数
       int count = 0;
       System.out.println("加分前的成绩："+score);
       while(score <= 60){
    	   score++;
    	   count++;
       }
       System.out.println("加分后的值为:"+score);
       System.out.println("加分次数:"+count);
       
       
	   
   }
	
}
