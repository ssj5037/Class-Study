package com.test.error;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Ex12_For_use_01 {
	
	public static void main(String[] args) throws Exception {
		
		m1();
		//m2();
		//m3();
		
	}

	private static void m3() throws Exception {
		
		//사용자가 짝수를 입력하면 누적, 홀수를 입력하면 중단하시오. 횟수는 무제한입니다.
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
//		int sum;
		// 초기화 해주어야한다.
		int sum = 0;
		int i;
		
//		for (i=0;;i++) {
		// 횟수는 1부터 시작
		for (i=1;;i++) {
			
			System.out.print("숫자: ");
			int num = Integer.parseInt(reader.readLine());
			
//			if (num % 2 == 1) {
			// 나머지가 0인게 짝수임
			if (num % 2 == 0) {
//				sum = num;
				// 누적을 하려면 +=
				sum += num;
			} else {
				break;
			}
			
		}
		
		System.out.printf("%d회 입력 결과: %,d\n", i, sum);		
		
	}

	private static void m2() {
		
		//1 ~ 10까지의 합을 구하시오.
//		int sum;
		// 초기화
		int sum = 0;
		
		for (int i=1; i<=10; i++) {
			System.out.println(i);
//			sum = i;
			// 누적은 +=
			sum += i;
		}
		
		System.out.println(sum);
		
		
	}

	private static void m1() {
		
		//구구단 출력
		// - 9단을 출력합니다.
		
		int dan = 9;
		
//		for (int i=1; i==9; i++) {
		// i가 9일때만 실행하게 했는데 시작이 1이기 때문에 절대 실행하지 않음
		for (int i=1; i<=dan; i++) {
			
			System.out.printf("%d x %d = %2d\n"
								, dan, i, dan * i);
			
		}
		
	}

}






