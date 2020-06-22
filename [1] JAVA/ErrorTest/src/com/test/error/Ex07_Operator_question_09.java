package com.test.error;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Ex07_Operator_question_09 {

	public static void main(String[] args) throws Exception {

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("영문자 입력 : ");
		int c = reader.read();
		
//		System.out.printf("입력한 문자 '%c'는 %s입니다.", c, c >= 'a' || c <= 'z' ? "소문자" : c >= 'A' || c <= 'Z' ? "대문자"); 수정 전
		System.out.printf("입력한 문자 '%c'는 %s입니다.", c, c >= 'a' && c <= 'z' ? "소문자" : c >= 'A' && c <= 'Z' ? "대문자" : "잘못 입력된 문자");
		// 대소문자를 확인하려면 두 범위 모두 만족해야하므로 or가 아닌 and연산자를 써야 하고, 마지막 ?:: 연산자에서 false일 때의 경우를 작성하지 않아서 오류가 생김.
	}
	
}








