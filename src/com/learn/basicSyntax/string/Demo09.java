package com.learn.basicSyntax.string;

public class Demo09 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int score1 = 99;
		Integer score2 = new Integer(score1);
		double score3 = score2.doubleValue();
		float score4 = score2.floatValue();
		int score5 = score2.intValue();
		short score6 = score2.shortValue();
		System.out.println("score2:"+score2);
		System.out.println("score3:"+score3);
		System.out.println("score4:"+score4);
		System.out.println("score5:"+score5);
		System.out.println("score6:"+score6);

	}

}
