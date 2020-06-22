package com.test.method;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Ex08_Method_use_01 {
	
	public static void main(String[] args) throws Exception {
		
		// 메소드
		// - 코드의 집합
		// - 자주 사용하는 반복적인 코드를 단위(모듈, 메소드)로 묶어 놓고 재사용할 수 있는 요소
		
		// 메소드 선언하기(x1) > (호출하기(xN + 재사용 효과)
		
		// 메소드 특징
		// 1. 코드 재사용 x 반복적인 행동
		// 2. 재사용과 무관하게 독립적인 행동
		
		// 호출하기
//		m1();
//		m1();
//		m1();
//		
//		m2();
		
		m3(10);	//실인자

		// The method m3(int) is not applicable for the arguments ()
		//m3(); 
		//m3(10, 20);
		//m3("홍길동");
		
		m4(10, 20);
		m4(5, 11);
		m4(534, 22);
		
		m5("홍길동", 1);
		m5("호호호", 2);
		//m5(2, "하하하");
		
	}//main

//	public static int m8() {
//		return true;
//	}
	
//	public static int m7() {
//		This method must return a result of type int	
//	}
	
	public static void m6() {
		//Void methods cannot return a value
		//return 10;
	}
	
	public static void m5(String name, int jumin) {
		String gender = jumin == 1 ? "남자" : "여자";
		System.out.printf("안녕하세요. %s님. 당신은 %s입니다.\n", name, gender);
	}
	
	public static void m4(int a, int b) {
		System.out.printf("%d + %d = %d\n", a, b, a + b);
	}
	
	public static void m3(int a) {	//가인자
		System.out.println(a + a);
	}

	
	
	// 메소드 헤더 == 메소드 서명(Signagture)
	public static void m1() {
		
		System.out.println("메소드 m1을 호출했습니다.");
		
	}
	
	public static void m2() throws Exception {
		
		// 사용자 이름 입력 > 인사하는 코드
		// Ctrl + Shift + O : 해당 페이지의 모든 import 자동 완성
		// 없는건 만들어주고, 필요없는건 지워준다.
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("이름 : ");
		
		// 1. reader.read();
		// - 한 문자 입력
		// - 문자코드 변환
		// - \r\n 포함
		// 2. reader.readline();
		// - 라인 입력
		// - 문자열 반환
		// - \r\n 제거
		
		String name = reader.readLine();
		
		System.out.printf("안녕~ %s\n", name);
		
	}

	
	
}//Ex08
