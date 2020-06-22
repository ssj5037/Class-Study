package com.test.error;


public class Ex02_Variable_use_01 {

	public static void main(String[] args) {
		
		int a;		
//		a = 10	수정 전
		a = 10;
		// 세미콜론 문장종결자가 없음.
		System.out.println(a);
		
		int b = 20;
		System.out.println(b);
		
//		int c, d; e; 수정 전
		int c, d, e;
		// 문장종결자가 끝난 후 또 변수를 기입함. 
		
		c = 30;
		d = 40;
		e = 50;
		
		System.out.println(c);
		System.out.println(d);
		System.out.println(e);
		
		int f = 60, g = 70, h = 80;
//		int i = 90, j, long k, l = 100; 수정 전
		int i = 90, j;
		long k, l = 100;
		// 자료형이 다른 변수의 선언은 따로 해주어야 한다. 같은 문장 내에서 할 수 없음
		
		a = 100;
		// 이미 선언된 변수는 앞에 자료형을 붙이면 안됨. 
		System.out.println(a);
		
		int m;
		
//		System.out.println(m);
		// 초기화 되지 않은 변수는 출력할 수 없음.
		// 주석처리를 하든, 초기값을 정해주면 되는데 주석처리를 하였음.
		
//		System.out.println(total);
		// 선언되지 않은 변수 total을 사용함.
		
	}
	
}










