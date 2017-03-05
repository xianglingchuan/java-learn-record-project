package com.learn.basicSyntax.tryCatchFinally;

import java.util.InputMismatchException;
import java.util.Scanner;

import org.eclipse.jdt.internal.compiler.codegen.MultiCatchExceptionLabel;

public class Demo01 {

	public static void main(String[] args) {
		try {
			System.out.println("请输入年龄:");
			Scanner scanner = new  Scanner(System.in);
			int age = scanner.nextInt();
			System.out.println("当前年龄为:"+age);			
		} catch (InputMismatchException e) { //输入的是否为数字异常
			System.out.println("对不起,你需要输入数字!");
		}catch (ArithmeticException e) { //计算异常
			// TODO: handle exception
		}
		System.out.println("结束运行结束.");
	}

}
