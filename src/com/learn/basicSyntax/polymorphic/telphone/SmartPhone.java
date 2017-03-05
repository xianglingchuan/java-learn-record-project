package com.learn.basicSyntax.polymorphic.telphone;
import com.learn.basicSyntax.polymorphic.telphone.TelPhone;

public class SmartPhone extends TelPhone implements IPlayGame{

	@Override
	public void call() {
		System.out.println("通过语音打电话.");
	}

	@Override
	public void message() {
		System.out.println("通过语音发短信.");		
	}

	
	@Override
	public void playGame() {
		System.out.println("手机有了玩游戏的功能.");
		
	}
}
