package com.learn.basicSyntax.string;


public class Demo17Math {

	public static void main(String[] args) {
		
        // 定义一个整型数组，长度为10
		int[] nums = new int[10];
        
        //通过循环给数组赋值
		for (int i = 0; i < nums.length; i++) {
            // 产生10以内的随机数
			int x = (int)(Math.random()*10);
            
			nums[i] = x;// 为元素赋值
		}
        
		// 使用foreach循环输出数组中的元素
		for (int i=0; i<nums.length; i++) {
		    int num = nums[i];
			System.out.print(num + " ");
		}		

	}

}
