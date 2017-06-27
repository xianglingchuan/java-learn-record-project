package com.thread;


/**
 * 隋唐演义大戏
 * */
public class Stage extends Thread {
	
	
	public void run(){
		
		System.out.println("欢迎观看隋唐演义");
		//让观众们安静片刻，等待大戏上演
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		
		System.out.println("大幕徐徐拉开");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		
		System.out.println("话说隋朝末年，隋军与农民起义军杀得天昏地黑的...");
		
		
		//政府军队
		ArmyRunnable armyTaskOfSuiDynasty = new ArmyRunnable();
		//农民军队
		ArmyRunnable armyTaskOfRevolt = new ArmyRunnable();
		
		//使用Runnable接口创建线程
		Thread armySuiDynasty = new Thread(armyTaskOfSuiDynasty,"隋军");
		Thread armyRevolt = new Thread(armyTaskOfRevolt,"农民起义军");
		
		//启动线程,让军队开始作战
		armySuiDynasty.start();
		armyRevolt.start();
		
		//线程休眠，大家专习观看军队厮杀
		try {
			Thread.sleep(50);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
//		//将两队军队暂不执行战斗任务
//		armyTaskOfSuiDynasty.keepRunnable = false;
//		armyTaskOfRevolt.keepRunnable = false;
//		try {
//			armyRevolt.join();
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
		
		System.out.println("正当双方激战正酣，半路杀出了一个程咬金");
		
		Thread mrCheng = new KeyPersonThread();
		mrCheng.setName("程咬金");
		
		System.out.println("程咬金的理想就是结束战争，使百性安居乐业!");
		
		//停止军队作战
		//停止线程的方法
		armyTaskOfSuiDynasty.keepRunnable = false;
		armyTaskOfRevolt.keepRunnable = false;	
		
		//错误停止java线程的方法
//		armySuiDynasty.stop();
//		armyRevolt.stop();
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		//历史大戏留给关键人物
		mrCheng.start();
		
		//万众瞩目，所有的线程等待程先生完成历史使命
		try {
			mrCheng.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("战争结束，人民安居乐业，程先生实现了积极的人生梦想，为人民作出了贡献！");
		System.out.println("谢谢观看隋唐演义，再见！");
	}
	
	
	public static void main(String[] args) {
		
     	new Stage().start();
		
	}

}
