package com.thread;

//军队线程
//模拟作战双方的行为
public class ArmyRunnable implements Runnable {
	
	
	//volatile保证了线程可以正确的读取其他结程写入的值
	//可见性 参考refJMM,java内存原则
	volatile boolean keepRunnable = true;
	
	@Override
	public void run(){
		while (keepRunnable) {
			//军队可以发动5连击
			for(int i=0; i<5; i++){
				System.out.println(Thread.currentThread().getName()+"进攻对方["+i+"]次");
				//让出了处理器时间，下次该谁进攻还不一定呢!
				Thread.yield();
			}
		}
		System.out.println(Thread.currentThread().getName()+"进攻结束");
		
	}

}
