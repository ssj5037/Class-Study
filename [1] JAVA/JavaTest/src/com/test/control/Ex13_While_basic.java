package com.test.control;

public class Ex13_While_basic {

	public static void main(String[] args) {
		
		//m1();
		m2();
		
	}

	private static void m2() {
		// TODO Auto-generated method stub
		
		/*
		
		do while문
		
		while문 -> 선조건, 후실행
		do while문 -> 선실행, 후조건 : 조건 불만족 최소 1회 실행
		
		do { //컴파일이 헷갈리지 않도록 임시 머리 역할을 하는 것. 아무 의미 없다.
			실행코드;
		}
		while (조건);
		
		*/
		
		int n = 11;
		
		do {
			System.out.println(n);
			n++;
		} while (n<=10);
		
	}

	private static void m1() {
		// TODO Auto-generated method stub

		/*
		
		while 문
		- for문 유사
		- 조건에 따라 반복 제어를 한다.
		- 조건식을 만족하는 동안 반복을 한다.
		
		while (조건식) {
			실행코드;
		}
		
		 */
		
		// 숫자 1~10까지 출력
		
		for (int i=1; i<=10; i++) {
			System.out.printf("%3d", i);
		}
		System.out.println();
		
		int num = 1;
		while (num<=10) {
			System.out.printf("%3d",num);
			num++;
		}
		System.out.println();
		
		
		// while문 연습 -> for문 예제 + 문제
		
		// 누적값 구하기
		// - 누적값이 1000이 넘으면 Stop
		int sum = 0;
		int i;
		for(i=1;;i++) {
			sum += i;
			if (sum>1000) {
				break;
			}
		}
		System.out.printf("%d %d", i, sum);
		System.out.println();
		
		
		sum = 0;
		num = 1;
		while (true) {
			sum += num;
			num++;
			if (sum>1000) {
				break;
			}
		}
		System.out.printf("%d %d", i, sum);
		System.out.println();
		
		
		sum = 0;
		num = 1;
		while (sum<1000) {
			sum += num;
			num++;
		}
		System.out.printf("%d %d", i, sum);
		System.out.println();
		
		
		sum = 0;
		i = 0;
		for(i=1; sum<1000; i++) {
			sum += i;
		}
		System.out.printf("%d %d", i, sum);
		System.out.println();
	}
}
