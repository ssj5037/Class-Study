package com.test.string;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Ex14_String_question_12 {
	
	public static void main(String[] args) throws Exception {
		
		// 요구사항 12
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		System.out.print("문장을 입력하시오. : ");
		String sentence = reader.readLine();
		
		int sum = 0;
		
		for (int i=0; i<sentence.length(); i++) {
			char c = sentence.charAt(i);
			if (c >= 48 && c <= 57) {
				sum += (int)c - 48;
			}
		}
		
		System.out.printf("문장에 존재하는 모든 숫자의 합은 %d입니다.\r\n", sum);
	}

}
