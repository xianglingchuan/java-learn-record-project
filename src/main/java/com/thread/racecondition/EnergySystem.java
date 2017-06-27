package com.thread.racecondition;


/**
 * 宇宙的能量系统
 * 能量守恒定律
 * 能量不会凭空创生或消失，只会从一处转移到另一处
 */

public class EnergySystem {
	
	//能量盒子，能量存贮的地方
	private final double[] energyBoxes;
	private final Object lockObj = new Object();
	
	
	/**
	 * @param n 能量盒子的数量
	 * @param initialEnergy 每个能量盒子初始含有的能量值
	 */
	public EnergySystem(int n, double initialEnergy){
		  this.energyBoxes = new double[n];
		  for(int i=0; i<this.energyBoxes.length; i++){
			  energyBoxes[i] = initialEnergy;
		  }		
	}
	
	/**
	 * 能量的转移，从一个盒子到另一个盒子
	 * @param from    能量源
	 * @param to      能量终点
	 * @param amount  能量值
	 */
	public void transfe(int from,int to, double amount){
		synchronized (this.lockObj) {  //实现线程的互斥
//			  if(this.energyBoxes[from] < amount)
//				  return;
			  //while循环，保证条件不满足时任务都会被条件阻挡
			  //而不是继承竟争CPU资源
			  while(this.energyBoxes[from] < amount){
				  try{
					  //条件不满足，将当前线程放入Wait Set
					  lockObj.wait();
				  }catch (InterruptedException e) {
					  e.printStackTrace();
				  }
			  }
			  System.out.println(Thread.currentThread().getName());
			  this.energyBoxes[from] -= amount;
			  System.out.printf("从%d转移%10.2f单位能量到%d,",from,amount,to);
			  this.energyBoxes[to] += amount;
			  System.out.printf("%d能量值为%10.2f,",to, this.energyBoxes[to]);
			  System.out.printf("能量总和:%10.2f%n", getTotalEnergies());
			  //唤醒所有在lockObj对象上等待的线程
			  lockObj.notifyAll(); //实现线程的同步
		}
	}
	
	/**
	 * 获取能量世界的能量总和
	 */
	public double getTotalEnergies(){
		double sum = 0;
		for(double amount : energyBoxes){
			sum += amount;
		}
		return sum;
	}
	
	/**
	 * 返回能量盒子的长度
	 */
	public int getBoxAmount(){
		return this.energyBoxes.length;
	}
}
