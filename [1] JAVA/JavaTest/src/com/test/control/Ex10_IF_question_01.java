package com.test.control;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Ex10_IF_question_01 {

	public static void main(String[] args) throws Exception {
		
		// 요구사항 01
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("첫번째 숫자 : ");
		int num1 = Integer.parseInt(reader.readLine());
		System.out.print("두번째 숫자 : ");
		int num2 = Integer.parseInt(reader.readLine());
		
		int bigger = 0;
		int smaller = 0;
		
		if (num1 == num2) {
			System.out.printf("두 수는 %d로 동일합니다.\r\n", num1);
		} else {
			if (num1 > num2) {
				bigger = num1;
				smaller = num2;
			} else {
				bigger = num2;
				smaller = num1;				
			}
			System.out.printf("큰 수는 %d이고, 작은수는 %d 입니다.\r\n", bigger, smaller);
			System.out.printf("입력한 두 숫자는 %d가 차이납니다.", bigger - smaller);
		}
		
	}
}
