package com.learn.basicSyntax;

public class Valuation {

	public static void main(String[] args) {
		// int one = 10 ;
		// int two = 20 ;
		// int three = 0 ;
		// three = one + two ;
		// System.out.println("three:"+three);
		// three += one;
		// System.out.println("three:"+three);
		// three -= one;
		// System.out.println("three:"+three);
		// three *= one;
		// System.out.println("three:"+three);
		// three /= one;
		// System.out.println("three:"+three);
		// three %= one;
		// System.out.println("three:"+three);

		boolean a = true; // a同意
		boolean b = false; // b反对
		boolean c = false; // c反对
		boolean d = true; // d同意
		System.out.println("(a && b)=" + (a && b) + "=未通过");
		System.out.println("(a || b)=" + (a || b) + "=通过");
		System.out.println("(a || d)=" + (a || d) + "=通过");
		System.out.println("(a && d)=" + (a || d) + "=通过");
		System.out.println("(!a)=" + (!a) + "=不通过");
		System.out.println("(!b)=" + (!b) + "=通过");
		System.out.println("(c ^ d)=" + (c ^ d) + "=通过");
		System.out.println("(a ^ d)=" + (a ^ d) + "=不通过");
		double iTest = (double) (35 / 4 % 3);
		System.out.println(iTest);

		int one = 20;
		if (one % 2 == 0) { // 这里要注意了
			System.out.println("该变量值为偶数!");
		} else {
			System.out.println("该变量值为奇数!");
		}

		int age = 17;
		if (age >= 60) {
			System.out.println("老年!");
		} else if (age >= 40 && age < 60) {
			System.out.println("中年!");
		} else if (age >= 18 && age < 40) {
			System.out.println("青年!");
		} else {
			System.out.println("童年!");
		}

		int score = 94;
		String sex = "女";
		if (score >= 80) {
			System.out.println("进入决赛!");
			if (sex == "女") {
				System.out.println("进入女子组决赛!");
			} else {
				System.out.println("进入男子组决赛!");
			}
		} else {
			System.out.println("未进入决赛!");
		}

		char today = '二';
		switch (today) {
		case '一':
		case '三':
		case '五':
			System.out.println("早餐吃包子!");
			break;
		case '二':
		case '四':
		case '六':
			System.out.println("早餐吃油条!");
			break;
		case '日':
			System.out.println("早餐吃主席餐!");
			break;
		default:
			System.out.println("世界末日了，什么也不能吃!");
			break;
		}

		int j = 10;
		while (j > 5) {
			System.out.println(j);
			j--;
		}

		// 计算1-50之间的偶数之和
		int sum = 0;
		int num = 0;
		do {
			num = num + 2;
			System.out.println("num:" + num);
			sum = sum + num;
		} while (num <= 48);
		System.out.println("1至50之间偶数之内为:" + sum);

		// 实现功能：计算 1 到 100 之间不能被 3 整除的数之和
		sum = 0;
		for (int i = 0; i <= 100; i++) {
			if (i % 3 != 0) {
				// System.out.println("i:"+i);
				sum = sum + i;
			}
		}
		System.out.println("sum:" + sum);

		// 实现功能：循环将 1 到 10 之间的整数相加，如果累加值大于 20，则跳出循环，并输出当前的累加值
		sum = 0;
		for (int i = 1; i <= 10; i++, sum = sum + i) {
			if (sum >= 20) {
				break;
			}
		}
		System.out.println("sum====" + sum);

		// 求 1 到 10 之间的所有偶数的和
		sum = 0;
		for (int i = 1; (i <= 10); i++) {
			if (i % 2 != 0) {
				continue;
			}
			sum = sum + i;
		}
		System.out.println("sum====" + sum);

		// 实现功能：使用 * 打印直角三角形
		for (int i = 1; i <= 3; i++) {
			for (int j1 = 1; j1 <= i; j1++) {
				System.out.print("*");
			}
			System.out.println();
		}

		/*
		 * 循环体中包含循环语句的结构称为多重循环。 三种循环语句可以自身嵌套，也可以相互嵌套，最常见的就是二重循环。
		 * 在二重循环中，外层循环每执行一次，内层循环要执行一圈。
		 */

		// 判断一个数（小于10位）的位数。
		// 输入999，则输出 “它是个3位的数！”
		int num1 = 999;
		int count = 0;
		if (num >= 0 && num <= 999999999) {
			while (num != 0) {
				count++;
				num /= 10;
			}
			System.out.println("num:"+num);
			System.out.println("它是个" + count + "位的数！");
		} else {
			System.out.println("输入有误！");
		}
		
		
		
		//小伙伴们，请根据所学知识，参考注释，将代码编辑器中代码补充完整，实现成绩加分功能。
		//功能描述：为指定成绩加分，直到分数大于等于 60 为止，输出加分前和加分后的成绩，并统计加分的次数
        //变量保存成绩
        int score1 = 53; 
        System.out.println("加分前的值为:"+score1);
        // 变量保存加分次数
        int count1 = 0;
        for(int i=score1; i<60; i++,score1++){
        	count1++;
        }
        System.out.println("加分后的值为:"+score1);
        System.out.println("加分次数:"+count1);
        
        

	}
}
