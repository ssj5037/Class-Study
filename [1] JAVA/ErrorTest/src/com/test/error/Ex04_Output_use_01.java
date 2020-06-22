package com.test.error;

public class Ex04_Output_use_01 {
	
	public static void main(String[] args) {
		
		String name = "홍길동";
		int age = 20;
		double pi = 3.14;
		char c = 'A';
		
		int small = (int)c + 32;
		
//		System.out.printf("제 이름은 %.-1c입니다.\n", name);
		System.out.printf("제 이름은 %s입니다.\n", name);
		// string은 %s를 사용해야함.
		// 점과 위치를 나타내는 숫자는 %s와 사용할 수 없음.
		
//		System.out.printf("나이는 %d살입니다.\n", age, pi); 수정 전
		System.out.printf("나이는 %d살입니다.\n", age);
		// 문장 내 자리와 변수의 개수가 맞지 않음
		
//		System.out.printf("소문자 'c'의 대문자는 'C'입니다.\n", c); 수정 전
		System.out.printf("소문자 '%c'의 대문자는 '%c'입니다.\n", (char)small, c);
		// 문장 내 자리를 지정해줄 때는 %를 넣어야 한다.
		
//		System.out.printf("원주율은 ,%d입니다.\n", pi); 수정 전
		System.out.printf("원주율은 %,.2f입니다.\n", pi);
		// 자료형과 맞지 않은 타입을 사용. 사용 순서도 잘못됨.
		
//		System.out.printf("제가 제일 좋아하는 문자는 %s입니다.\n", c); 수정 전
		System.out.printf("제가 제일 좋아하는 문자는 %c입니다.\n", c);
		// 자료형과 맞지 않은 타입 사용
		
		System.out.printf("오늘 3개의 에러를 발견하고 수정했습니다.\n");
		
		
	}

}











