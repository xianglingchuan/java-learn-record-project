package com.learn.basicSyntax.polymorphic.telphone;

public class Initial {

	
	public static void main(String[] args) {
		TelPhone telPhone = new CellPhone();
		telPhone.call();
		telPhone.message();
		
		TelPhone telPhone1 = new SmartPhone();
		telPhone1.call();
		telPhone1.message();
		
		
		IPlayGame p1 = new SmartPhone();
		p1.playGame();
		IPlayGame p2 = new Psp();
		p2.playGame();
		
		
		
		IPlayGame p3 = new IPlayGame() {
			
			@Override
			public void playGame() {
				// TODO Auto-generated method stub
				System.out.println("使用匿名内部内的方法");
			}
		};
		p3.playGame();
		
		
		new IPlayGame() {
			
			@Override
			public void playGame() {
				// TODO Auto-generated method stub
				System.out.println("直接new来实现一个匿名内部类的方");
			}
		}.playGame();
		
		
		
	}
}
