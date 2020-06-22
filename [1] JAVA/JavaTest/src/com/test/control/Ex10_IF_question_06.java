package com.test.control;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Ex10_IF_question_06 {

	public static void main(String[] args) throws Exception {
		
		// 요구사항 06
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("숫자 입력 : ");
		int num1 = Integer.parseInt(reader.readLine());
		System.out.print("숫자 입력 : ");
		int num2 = Integer.parseInt(reader.readLine());
		System.out.print("숫자 입력 : ");
		int num3 = Integer.parseInt(reader.readLine());
		System.out.print("숫자 입력 : ");
		int num4 = Integer.parseInt(reader.readLine());
		System.out.print("숫자 입력 : ");
		int num5 = Integer.parseInt(reader.readLine());
		
		int odd = 0, even = 0;
		
		if ((num1 >= 1 && num1 <= 10)
				&& (num2 >= 1 && num2 <= 10) 
				&& (num3 >= 1 && num3 <= 10)
				&& (num4 >= 1 && num4 <= 10)
				& (num5 >= 1 && num5 <= 10)) {
			if (num1 % 2 == 0) {
				even += 1;
			} else {
				odd += 1;
			}
			if (num2 % 2 == 0) {
				even += 1;
			} else {
				odd += 1;
			}
			if (num3 % 2 == 0) {
				even += 1;
			} else {
				odd += 1;
			}
			if (num4 % 2 == 0) {
				even += 1;
			} else {
				odd += 1;
			}
			if (num5 % 2 == 0) {
				even += 1;
			} else {
				odd += 1;
			}
			System.out.printf("짝수는 %d개 홀수는 %d개 입력했습니다.\r\n", even, odd);
			if (even > odd) {
				System.out.printf("짝수가 홀수보다 %d개 더 많습니다.\r\n", even - odd);
			} else {
				System.out.printf("홀수가 짝수보다 %d개 더 많습니다.\r\n", odd - even);
			}
		} else {
			System.out.println("1~10 사이의 정수만 입력하시오.");
		}
	
	}
}
