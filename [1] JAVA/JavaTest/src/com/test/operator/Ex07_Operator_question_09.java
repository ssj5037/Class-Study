package com.test.operator;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Ex07_Operator_question_09 {

	public static void main(String[] args) throws Exception {
		
		// 요구사항 09

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("영문자 입력 : ");
		int letter = reader.read();
		String check = letter >= 97 && letter <= 122 ? "소문자" :
			letter >= 65 && letter <= 90 ? "대문자" : "잘못 입력한 문자";
		// letter가 97에서 122 사이, true면 check에 소문자 대입,
		// false면 65에서 90 사이인지 다시 확인.
		// true면 대문자 대입, false면 잘못 입력한 문자 대입.
			
		System.out.printf("입력한 문자 '%c'는 %s입니다.", (char)letter, check);

	}
}
