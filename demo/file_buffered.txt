package com.learn.basicSyntax;

import java.util.Scanner;

public class Demo02 {

	public static void main(String[] args) {
	    
		int classNum = 3; //需要计算成绩班级的数量
		int stuNum = 4;   //需要计算成绩的学员数量
		double sum = 0;   //总成绩数
		double avg = 0;   //成绩的平均数
		
		
		for(int i=1; i<=classNum; i++){
			sum = 0;
			System.out.println("***请输入第"+i+"班级的成绩***");
			for(int j=1; j<=stuNum; j++){
				System.out.print("请输入第"+j+"位学生成绩:");
				Scanner input = new Scanner(System.in);
				int score = input.nextInt();
				sum = sum + score;
			}
			avg = sum/stuNum;
			System.out.println("第"+i+"班级的平均成绩是:"+avg);
		}
		
		
		
	}
}
