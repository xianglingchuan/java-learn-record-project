package com.thread;

import java.util.concurrent.ThreadPoolExecutor;

import com.learn.basicSyntax.cardWash.Main;

public class Actor extends Thread {

	public void run() {

		System.out.println(getName() + "是一个演员.");
		int count = 0;
		boolean keepRunnable = true;
		while (keepRunnable == true) {

			System.out.println(getName() + "登台演出:" + (++count));
			if (count >= 100) {
				keepRunnable = false;
			}

			if (count % 10 == 0) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		System.out.println(getName() + "演出结束了.");

	}

	public static void main(String[] args) {
		Thread actor = new Actor();
		actor.setName("Mr.Thread");
		actor.start();
		
		
		Thread actree = new Thread(new Actree(),"Ms.Runnable");
		actree.start();
	}
}
