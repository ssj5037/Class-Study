package com.test.control;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Ex12_For_question_20 {

	public static void main(String[] args) throws Exception {
		
		// 요구사항 20
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("첫번째 숫자 : ");
		int num1 = Integer.parseInt(reader.readLine());
		System.out.print("두번째 숫자 : ");
		int num2 = Integer.parseInt(reader.readLine());
		
		System.out.printf("%d의 약수 : ", num1);
		for(int i=1; i<=num1; i++) {
			if (num1 % i == 0) {
				System.out.printf("%d, ", i);
			}
		}
		System.out.printf("\b\b\r\n");
		
		System.out.printf("%d의 약수 : ", num2);
		for(int i=1; i<=num2; i++) {
			if (num2 % i == 0) {
				System.out.printf("%d, ", i);
			}
		}
		System.out.printf("\b\b\r\n");
		
		System.out.printf("%d와 %d의 공약수 : ", num1, num2);
		for(int i=1; i<=num1 || i<=num2; i++) {
			if (num1 % i == 0 && num2 % i == 0) {
				System.out.printf("%d, ", i);
			}
		}
		System.out.printf("\b\b\r\n")
		;
		
		
	}
}
