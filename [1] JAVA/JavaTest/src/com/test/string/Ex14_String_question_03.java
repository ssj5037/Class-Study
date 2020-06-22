package com.test.string;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Ex14_String_question_03 {

	public static void main(String[] args) throws Exception {
		
		// 요구사항 03
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("숫자 : ");
		String num = reader.readLine();
		
		int sum = 0;
		
		System.out.print("결과 : ");
		for (int i=0; i<num.length(); i++) {
			int split = Integer.parseInt(num.substring(i, i+1));
			sum += split;
			System.out.printf("%d + ", split);
		}
		System.out.printf("\b\b= %d\r\n", sum);
		
	}
	
}
