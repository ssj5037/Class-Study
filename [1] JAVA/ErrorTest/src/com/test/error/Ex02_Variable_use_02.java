package com.test.error;

public class Ex02_Variable_use_02 {

	public static void main(String[] args) {
		
		byte b1;
//		b1 = 1000; 수정 전
		b1 = 10;
		// byte의 범위를 넘어 선 값으로 초기화 함.
		System.out.println(b1);
		
		short s1;
		s1 = 10;
		System.out.println(s1);
		
		int n1;
		n1 = 10;
		System.out.println(n1);
		
		long l1;
//		l1 = 10000000000; 수정 전
		l1 = 10000000000L;
		// int의 범위를 넘어서는 숫자는 뒤에 L 혹은 l을 표기하여 int가 아닌 long의 자료형을 가진 숫자로 받는다는 표시를 해 주어야 한다. 
		System.out.println(l1);
		
		
		
		float f1;
//		f1 = 3.14; 수정 전
		f1 = 3.14F;
		// long에 L을 붙여주는 것 처럼 실수의 기본값은 double이기 때문에 float에 저장할 때도 뒤에 F 혹은 f로 표기를 해주어야 한다.
		System.out.println(f1);
		
		double d1;
		d1 = 6.28;
		System.out.println(d1);
		
		
		
		char c1;
//		c1 = "A"; 수정 전
		c1 = 'A';
		// char는 쌍따옴표가 아닌 홑따옴표로 초기화 해야 한다.
		System.out.println(c1);
		
//		c1 = '홍길동';
//		System.out.println(c1);
		// char는 단어 하나만 받음. 여러 단어를 받기 위해서는 String을 사용해야 한다.
		
		String name;
//		name = '홍길동'; 수정 전
		name = "홍길동";
		// String은 홑따옴표가 아닌 쌍따옴표로 초기화 해야 한다.
		System.out.println(name);
				
		
	}
	
}




















