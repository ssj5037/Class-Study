package com.test.datatype;

public class Ex02_Variable_use_02 {

	
	public static void main(String[] args) {
		
		
		
		// 자바 자료형 9개 + 변수 만들기
		
		// 1. byte : -128 ~ 127
		
		byte b1;
		b1 = 10;	// Type mismatch: cannot convert from int to byte
		System.out.println(b1);
		
		// 2. short : -32768 ~ 32767
		
		short s1;
		s1 = 10;	//Type mismatch: cannot convert from int to short
		System.out.println(s1);
		
		// 3. int : -21억 ~ 21억 (***)
		
		int n1;
		n1 = 10;
		System.out.println(n1);
		//이름이 없는 상수 10을 메모리에 임시로 데이터를 저장함. 바로 n1에 복사함.
		
		// 4. long : -922경 ~ 922경
		
		long l1;
		l1 = 10000000000L;	//The literal 10000000000 of type int is out of range 
		System.out.println(l1);
		
		// 데이터 -> 상수, 리터럴(Literal)
		System.out.println(10);
		System.out.println(10);
		System.out.println(10);
		System.out.println(10);
		// 10 -> 정수형 상수, 정수형 리터럴
		// 10을 확인하자마자 임의의 메모리 공간에 10을 생성. 상수는 재사용함.
		// 정수형 상수는 무조건 크기를 int로 잡아버림
		// 숫자 뒤에 L을 붙이면 자료형을 int가 아니라 long으로 잡는다.
		
		
		
		// 실수
		
		// 1. float
		
		float f1;
		f1 = 3.14F;	//Type mismatch: cannot convert from double to float
		f1 = 1.2345678901234567890123456789F;	// 결과값 : 1.2345679 (정밀도 낮음)
		System.out.println(f1);
		// 실수형 상수는 무조건 double로 잡아버림
		// 실수 뒤에 F를 붙이면 자료형을 double이 아닌 float로 잡는다.
		
		// 2. double (***)
		
		double d1;
		d1 = 6.28;
		d1 = 1.2345678901234567890123456789;	// 결과값 : 1.2345678901234567 (정밀도 높음)
		System.out.println(d1);
		
		
		
		// 문자형
		
		// 1. char
		// 문자를 하나만 넣을 수 있다.
		
		char c1;
		c1 = 'A';	// ' ' : 문자 리터럴. ' '가 없으면 데이터가 아닌 변수로 인지해서 오류가 난다.
		System.out.println(c1);
		c1 = '가';
		System.out.println(c1);
		c1 = '*';
		System.out.println(c1);
		c1 = '1';
		System.out.println(c1);
		
		
		
		// 논리형
		
		// 1. boolean
		
		boolean flag;
		flag = true;	// true, false : 논리 상수, boolean literal
		System.out.println(flag);
		flag = false;
		System.out.println(flag);
		
		
		
		// 자바 자료형
		// 1. 기본형 : byte, short, int, long, float, double, boolean, char
		// 2. 참조형
		
		
		
		// 문자열, String
		// - 참조형
		
		// 문자, char
		
		// '홍길동' -> 변수 저장
		char name1 = '홍';
		char name2 = '길';
		char name3 = '동';
		
		// 문자들의 열을 저장하는 자료형 -> 문자열(String)
		String name;
		name = "홍길동";	// " " : 문자열 상수, String Literal
		System.out.println(name);
		
		name = "홍";
		System.out.println(name);
		
		
		
		/*
		
		영문식 표현
		
		~(tilde)
		!
		@(SI)
		#(샵, 해시)
		$, %
		^(caret, hat, XOR)
		&
		*(all(wildcard), asterisk)
		-(minus, dash, horizontal bar)
		|(pipe, vertical bar)
		:, ;, /, \
		'(쿼트), "(쿼트, 더블쿼트), `(역홑따옴표), ,, .
		
		괄호
		() 소괄호
		[] 대괄호 브렉킷
		{} 중괄호 브레이스
		<> 화살표 괄호
		
		A > B 크다, 초과, bigger than
		A >= B 이상 , bigger than equal
		A < B 작다, 미만, less than
		A <= B 이하, less than equal
		
		http://terms.co.kr
		
		*/
	}
}
