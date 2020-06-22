package com.test.two;

import com.test.one.Student;

public class Student2 extends Student{
	
	public void test() {
		System.out.println("다른 패키지내의 자식 클래스에서 접근");
//		System.out.println("private a   : " + this.a);
		System.out.println("public b    : " + this.b);
		System.out.println("protected c : " + this.c);
//		System.out.println("default d   : " + this.d);
		// protected : 다른패키지, 자식클래스 에서는 public처럼 쓴다.
		// default : 다른패키지, 자식클래스 에서는 private처럼 쓴다.
	}

}
