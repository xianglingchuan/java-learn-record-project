package com.learn.basicSyntax.string;

public class Demo08StringBuilder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 创建一个空的StringBuilder对象
		StringBuilder str = new StringBuilder();
        
		// 追加字符串
		str.append("jaewkjldfxmopzdm");
		
        // 从后往前每隔三位插入逗号
        int lenght = str.length();
        int j=0;
        for(int i=lenght; i>=0; i--){
        	if(i>0 && i<lenght){
            	if(j==3){
                	System.out.println("i==="+i);
                	str.insert(i, ",");        
                	j=0;
            	}            	
            }
            j++;
        }
        System.out.println(str.toString());
        // 将StringBuilder对象转换为String对象并输出
		System.out.print(str.toString());
		
	}

}
