package com.thread;

public class WrongWayStopThread extends Thread {

	private Thread thread;
	
	
    public final boolean keepRunnable = true;

	public static void main(String[] args) {

		// Thread thread = new Thread(new
		// WrongWayStopThread(),"WrongWayStopThread");
		// System.out.println("starting thread...");
		WrongWayStopThread thread = new WrongWayStopThread();
		thread.start();

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("Interrupting thread...");
		thread.interrupt();

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("Stopping application...");
	}

	@Override
	public void run() {
		// while (true) { //无法正确停止线程
		//这里也是采用的下标，只是用的是系统自己的标记来判断的，可以正常停止
		while (!this.isInterrupted()) {
			System.out.println("Thread is running...");
		}
			
		
		//上面的可以正常停止 
//		long time = System.currentTimeMillis();
//		while (System.currentTimeMillis() - time < 1000) {
//			// 减少屏幕输出的空循环
//		}
		
		//换成这一句则不能正常停止
		//如果线程调用了我们一些方法，导致线程堵塞，些时如果线程在被调用interrupt()方法，会产生两个结果
		//1、它的终断状态被清除
		//2、sleep会抛出一个InterruptedException处理
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}
