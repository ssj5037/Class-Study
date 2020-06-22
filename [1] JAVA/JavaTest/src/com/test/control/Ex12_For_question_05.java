package com.test.control;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Ex12_For_question_05 {

	public static void main(String[] args) throws Exception {
		
		// 요구사항 05
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("시작 숫자 : ");
		int num1 = Integer.parseInt(reader.readLine());
		System.out.print("종료 숫자 : ");
		int num2 = Integer.parseInt(reader.readLine());
		
		int sum = 0;
		for(int i=num1; i<=num2; i++) {
			sum += i;
			System.out.printf("%d + ", i);
		}
		System.out.printf("\b\b= %d\r\n", sum);
		
		
		// 1 + 2 + 3 + 4 + 5 + 6 + 7 + 8 + 9 + 10 = 55
		
		// 2. 누적 변수를 생성한다.
		// 1. 루프를 생성한다. (for x 10회 ** i 누적 변수 사용) {
		// 3. 숫자(i)를 출력한다. + 숫자(i)를 누적한다.
		// 1. }
		// 4. 누적값을 출력한다.
	}
}
