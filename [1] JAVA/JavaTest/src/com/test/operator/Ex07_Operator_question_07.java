package com.test.operator;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Ex07_Operator_question_07 {

	public static void main(String[] args) throws Exception {
		
		// 요구사항 07

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("첫번째 숫자 : ");
		String input1 = reader.readLine();
		int num1 = Integer.parseInt(input1);
		
		System.out.print("두번째 숫자 : ");
		String input2 = reader.readLine();
		int num2 = Integer.parseInt(input2);	
		
		System.out.print("세번째 숫자 : ");
		String input3 = reader.readLine();
		int num3 = Integer.parseInt(input3);
		
		int result12 = num1 >= num2 ? num1 : num2;			// 숫자 1, 2 먼저 비교
		int result123 = num3 >= result12 ? num3 : result12;	// 1,2 중 큰 수와 3과 다시 비교
		
		System.out.printf("%,d, %,d와(과) %,d 중에 가장 큰 숫자는 %,d입니다.",
				num1, num2, num3, result123);
	}
}
