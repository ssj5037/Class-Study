package com.test.casting;

public class Ex06_Casting_use {

	public static void main(String[] args) {
		
		// 명시적 형번환
		byte b1 = (byte)10;	// byte(1) = int(4)
		short s1 = (short)10;	// short(2) = int(4)
		// 예외 상황
		
		int n1 = 10;	// int(4) = int(4)
		
		// 암시적 형변환
		long l1 = (long)10;	// long(8) = int(4)
		
		
		// 정수 -> 정수
		// 실수 -> 실수	(별로 없음)
		// 정수 -> 실수	(많이 씀)
		// 실수 -> 정수
		
		int m1;
		double d1;
		
		m1 = 100;
		
		// 큰형 = 작은형
		// double = int
		d1 = (double)m1;
		System.out.println(d1);
		
		
		int m2;
		double d2;
		
		d2 = 3.74;
		
		// 작은형 = 큰형
		// int = double
		m2 = (int)d2;
		System.out.println(m2);
		// 소수점 다 버린다. 반올림 없음
		
		
		float f1;
		int m3;
		
		f1 = 31.4F;
		
		// int : -21억 ~ 21억
		// float : -10^30 ~ 10^30
		// -> 같은 4바이트지만 float 범위가 더 크기 때문에 큰형이다.
		// int(4) = float(4)
		m3 = (int)f1;
		System.out.println(m3);
		
		
		long l2;
		
		// 작은형 = 큰형
		//long(8) = float(4)
		l2 = (long)f1;
		System.out.println(l2);
		
		// byte(1) < short(2) < int(4) < long(8) < float(4) < double(8)
		// 바이트의 크기로 구분하는 것이 아닌 자료형이 나타낼 수 있는 수의 범위를 봐야한다.
		
		
		// boolean
		// - 형변환이 불가능
		
		// char
		// - 형변환이 가능
		
		int m5;
		char c1;
		
		m5 = 45000;	// 원본
		
		// 복사
		// char(2) = int(4)
		c1 = (char)m5;
		
		System.out.println(c1);
		System.out.println((char)65);
		System.out.println((int)'A');
		
		
		// 문자 코드
		System.out.println((int)'A');
		System.out.println((int)'Z');
		System.out.println((int)'a');
		System.out.println((int)'z');
		System.out.println((int)'0');
		System.out.println((int)'9');
		System.out.println((int)'가');
		System.out.println((int)'힣');

		System.out.println((int)'\r');
		System.out.println((int)'\n');
		System.out.println((int)'\t');
		System.out.println((int)'\b');
		System.out.println((int)' ');
		
		
		
		
		
		
		
	}
}
