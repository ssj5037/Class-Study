package com.test.operator;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Ex07_Operator_question_10 {

	public static void main(String[] args) throws Exception {
		
		// 요구사항 10

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		System.out.print("섭씨(℃) : ");
		String input1 = reader.readLine();
		int celcius = Integer.parseInt(input1);
		
		double fahrenheit = celcius * 1.8 + 32;
		
		System.out.printf("섭씨 %d℃는 화씨 %.1f℉입니다.", celcius, fahrenheit);
		
	}
}
