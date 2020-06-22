package com.test.operator;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Ex07_Operator_question_01 {

	public static void main(String[] args) throws Exception {
		
		// 요구사항 01
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("태어난 년도 : ");
		
		String input = reader.readLine();
		int year = Integer.parseInt(input);
		int age = 2020 - year + 1;
		// 2020년 기준으로 작성하였음
		// 우리나라 나이 = 만 나이 + 1
		
		System.out.printf("나이 : %d세\n", age);
	}
}
