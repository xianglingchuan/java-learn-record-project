package com.learn.basicSyntax;

import java.util.Arrays;
import java.util.function.Function;

public class DemoMethod {

	public static void main(String[] args) {
		
        // 创建对象，对象名为hello
		DemoMethod hello = new DemoMethod(); 
        
        // 调用方法并将返回值保存在变量中
        int maxScore = hello.getMaxAge();
        
		// 输出最大年龄
		System.out.println("最大年龄为：" + maxScore); 
		
		
        // 调用方法，传入两门课程的成绩
		hello.calcAvg(94, 81);
		
		int[] aRandom = hello.createRandomArray(8);
		System.out.println(Arrays.toString(aRandom));
		
	}
	
	
	
	/*
	 * 功能：输出学生年龄的最大值 
     * 定义一个无参的方法，返回值为年龄的最大值
     * 参考步骤：
     * 1、定义一个整形数组 ages ，保存学生年龄，数组元素依次为 18 ,23 ,21 ,19 ,25 ,29 ,17
     * 2、定义一个整形变量 max ,保存学生最大年龄，初始时假定数组中的第一个元素为最大值
     * 3、使用 for 循环遍历数组中的元素，并与假定的最大值比较，如果比假定的最大值要大，则替换当前的最大值
     * 4、使用 return 返回最大值
	 */
	public int getMaxAge() {
	    int[] ages = {18,23,21,19,25,29,17};
        int max = ages[0];
        for (int i : ages) {
			if(i>max){
				max = i;
			}
		}
        return max;
	}
	
	
	/*
	请在编辑器中的第 15 行后填写完整方法代码
	实现功能：编写带参方法计算两门课程考试成绩的平均分，通过方法的参数传入成绩信息
	运行结果为： 平均分：87.5	 
	 * */
	public void calcAvg(int engScore, int languageScore){
		double sum = (engScore+languageScore);
		double avg =(double)sum/2;
		System.out.println("平均分："+avg);
	}
	
	
	/*
	任务
	一、 定义一个带参带返回值的方法，实现输出随机数数组
	提示：
	 1、 定义一个带参带返回值的方法，通过参数传入数组的长度，返回值为赋值后的数组
	 2、 创建指定长度的整型数组
	 3、 使用 for 循环遍历数组，通过 Math.random( ) 生成随机并给数组成员赋值
	 4、 使用 return 返回赋值后的数组
	 
	二、 完成 main 方法
	提示：
	 1、 调用自定义方法，保存方法执行后返回的数组
	 2、 使用 Arrays.toString( ) 将数组转换为字符串并输出，注意导入 java.util.Arrays;	 
	 * */
	
	public int[] createRandomArray(int arrayLength){
		arrayLength = arrayLength >=1 ? arrayLength : 1;
		int[] iArra = new int[arrayLength];
		for(int i=0; i<iArra.length; i++){
			//System.out.println((int)(Math.random()*1000));
			iArra[i] = (int)(Math.random()*100);
		}
		Arrays.sort(iArra);
		return iArra;		
	}
	
	
	
	
	
	
}
