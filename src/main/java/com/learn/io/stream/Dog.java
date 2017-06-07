package com.learn.io.stream;

import java.io.Serializable;

class Dog {
    public Dog(){
    	System.out.println("dog...");
    }		
}



class BigDog extends Dog {
    public BigDog(){
    	System.out.println("bigDog...");
    }		
}


class SmallDog extends BigDog implements Serializable {
    public SmallDog(){
    	System.out.println("smallDog...");
    }		
}