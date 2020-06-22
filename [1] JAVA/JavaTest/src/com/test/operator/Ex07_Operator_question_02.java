package com.test.operator;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Ex07_Operator_question_02 {

	public static void main(String[] args) throws Exception {
		
		// 요구사항 02

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("첫번째 숫자 : ");
		String input1 = reader.readLine();
		int num1 = Integer.parseInt(input1);
		
		System.out.print("두번째 숫자 : ");
		String input2 = reader.readLine();
		int num2 = Integer.parseInt(input2);
		
		System.out.printf("%,d + %,d = %,d\r\n", num1, num2, num1 + num2);
		System.out.printf("%,d - %,d = %,d\r\n", num1, num2, num1 - num2);
		System.out.printf("%,d * %,d = %,d\r\n", num1, num2, (long)num1 * num2);
		System.out.printf("%,d / %,d = %,.1f\r\n", num1, num2, (double)num1 / num2);
		System.out.printf("%,d %% %,d = %,d\r\n", num1, num2, num1 % num2);
		
	}
}
