package com.test.control;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Ex10_IF_question_05 {

	public static void main(String[] args) throws Exception {
		
		// 요구사항 05
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("문자 : ");
		int letter = reader.read();
		
		if(letter >= 97 && letter <= 122) {
			System.out.printf("결과 : %c", (char)(letter-32));
		} else if(letter >= 65 && letter <= 90) {
			System.out.printf("결과 : %c", (char)(letter+32));
		} else {
			System.out.println("대소문자를 입력하시오.");
		}
	}
}
