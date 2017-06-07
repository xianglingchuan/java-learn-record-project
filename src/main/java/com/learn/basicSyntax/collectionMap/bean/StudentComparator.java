package com.learn.basicSyntax.collectionMap.bean;

import java.util.Comparator;

public class StudentComparator implements Comparator<Student> {

	public int compare(Student o1, Student o2) {
		//按姓进行排序操作
		return o1.getName().compareTo(o2.getName());
		//return 0;
	}

}
