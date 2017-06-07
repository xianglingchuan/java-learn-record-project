package com.learn.basicSyntax;

public class DemoFunctionInnerClass {

	
	//定义方法
	public void show(){
		//定义内部内
		class MInner{
			public int age = 10;
			public void getAge(){
				int age = this.age + 10;
				System.out.println("i age "+age);
			}
		}
		MInner inner = new MInner();
		inner.getAge();
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DemoFunctionInnerClass demoFunctionInnerClass = new DemoFunctionInnerClass();
		demoFunctionInnerClass.show();

	}

}
