package com.test.operator;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Ex07_Operator_question_06 {

	public static void main(String[] args) throws Exception {
		
		// 요구사항 06

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("문자 입력(a ~ z) : ");
		int small = reader.read();
		int capital = small - (97 - 65);
		// 소문자 : a(97) ~ z(122)
		// 대문자 : A(65) ~ Z(90)
		// 아스키코드로 대소문자가 (97-65)의 값 만큼 일대일 대응.
		
		System.out.printf("소문자 '%c'의 대문자는 '%c'입니다.",
				(char)small, (char)capital);
		
	}
}
