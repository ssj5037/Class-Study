package com.test.two;

import com.test.one.Student;

public class Item {

	public void test() {
		Student s = new Student();
		
		System.out.println("다른 패키지내의 다른 클래스에서 접근");
//		System.out.println("private a   : " + s.a);
		System.out.println("public b    : " + s.b);
//		System.out.println("protected c : " + s.c);
//		System.out.println("default d   : " + s.d);
		System.out.println();
		// protected, default : 다른패키지, 다른클래스에서는 private처럼 쓴다.
		
	}
}
