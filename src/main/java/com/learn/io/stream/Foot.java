package com.learn.io.stream;

import java.io.Serializable;


class Foot implements Serializable {	
    public Foot(){
    	System.out.println("Foot...");
    }
    
}

class Foot2 extends Foot{
	public Foot2(){
		System.out.println("Foot2...");
	}
}

class Foot3 extends Foot2{
	public Foot3(){
         System.out.println("Foot3...");		
	}
}
