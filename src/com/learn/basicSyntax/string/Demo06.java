package com.learn.basicSyntax.string;

public class Demo06 {

	public static void main(String[] args) {
		String str = "hello Java";
		String str2 = new String("hello Java");
		System.out.println(str+" I love");
		System.out.println(str);
		System.out.println("str==str2"+(str==str2));
		System.out.println("str.equals"+(str.equals(str2)));
       /*
	    public boolean equals(Object anObject) {
	        if (this == anObject) {
	            return true;
	        }
	        if (anObject instanceof String) {
	            String anotherString = (String)anObject;
	            int n = value.length;
	            if (n == anotherString.value.length) {
	                char v1[] = value;
	                char v2[] = anotherString.value;
	                int i = 0;
	                while (n-- != 0) {
	                    if (v1[i] != v2[i])
	                        return false;
	                    i++;
	                }
	                return true;
	            }
	        }
	        return false;
	    }        
        * */	
		
				
		StringBuilder stringBuilder = new StringBuilder("hello Java");
		StringBuilder stringBuilder2 = new StringBuilder("hello Java");
        System.out.println("两个StringBuilder对象内存地址是否相同"+(stringBuilder==stringBuilder2));
        //为什么两个StringBuilder的字符串一样，但equals出来为false
        //经查资料说明如下：
        /*
        首先，当我们使用StringBuilder创建对象时，肯定会在内存中开辟一个新的专属的地址用于存放对象内容，但是即使StringBuilder中存放的内容与其他字符串的内容相同，使用equals来判断也是返回false，这是因为StringBuilder并没有重写equals函数，即StringBuilder的equals为：
        [java] view plain copy 在CODE上查看代码片派生到我的代码片
        public boolean equals(Object obj) {  
                return (this == obj);  
            }  
        所以会返回false。
        */        
        
        
        System.out.println("两个StringBuilder对象内容是否相同"+(stringBuilder.equals(stringBuilder2)));
        System.out.println(stringBuilder.toString());
        System.out.println(stringBuilder2.toString());
        
        stringBuilder = stringBuilder.append(", I love");
        System.out.println(stringBuilder.toString());
		
	}

}
