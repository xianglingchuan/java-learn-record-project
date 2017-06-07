package com.learn.reflect;

import org.apache.catalina.tribes.membership.StaticMember;
import org.omg.CORBA.PUBLIC_MEMBER;

public class ClassDemo2 {

	public static void main(String[] args) {

		Class class1 = int.class;
	    Class class2 = Integer.class;
	    Class class3 = Double.class;
	    Class class4 = String.class;
	    Class class5 = double.class;
	    Class class6 = void.class;
	    Class class7 = Void.class;
		System.out.println(class6.getName());
		System.out.println(class7.getName());
		Class class8 = PUBLIC_MEMBER.class;
		System.out.println(class8.getName());
	}

}
