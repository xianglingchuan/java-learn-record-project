package com.learn.basicSyntax.tryCatchFinally;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Demo02 {

	public static void main(String[] args) {

		
		try {
			System.out.println("请输入上班总小时数:");
			Scanner scanner = new  Scanner(System.in);
			int jobDayNumber = scanner.nextInt();
			
			System.out.println("请输入平均每天工作小时数:");
			int jobDayHourNumber = scanner.nextInt();
			System.out.println("当前总工作天数:"+jobDayNumber/jobDayHourNumber);		
			
			
		} catch (InputMismatchException e) { //输入的是否为数字异常
			System.out.println("对不起,你需要输入数字!");
		}catch (ArithmeticException e) { //计算异常
			System.out.println("对不起，被除数不能为0!");
		}catch(Exception e){
			System.out.println("未知异常情况!");
		}
		System.out.println("结束运行结束.");
	}

}
