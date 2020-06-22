package com.test.method;

public class Ex08_Method_question_11 {

	public static void main(String[] args) {
		
		// 요구사항 11
		
		position("홍길동");
		position("홍길동", "유재석");
		position("홍길동", "유재석", "박명수");
		position("홍길동", "유재석", "박명수", "정형돈");
	}
	
	public static void position(String a) {
		System.out.printf("사원 : %s\r\n", a);
	}
	
	public static void position(String a, String b) {
		System.out.printf("사원 : %s\r\n", a);
		System.out.printf("대리 : %s\r\n", b);
	}
	
	public static void position(String a, String b, String c) {
		System.out.printf("사원 : %s\r\n", a);
		System.out.printf("대리 : %s\r\n", b);
		System.out.printf("과장 : %s\r\n", c);
	}
	
	public static void position(String a, String b, String c, String d) {
		System.out.printf("사원 : %s\r\n", a);
		System.out.printf("대리 : %s\r\n", b);
		System.out.printf("과장 : %s\r\n", c);
		System.out.printf("부장 : %s\r\n", d);
	}
}
