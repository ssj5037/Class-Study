package com.test.method;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Ex08_Method_question_06 {

	public static void main(String[] args) throws Exception{
		
		// 요구사항 06
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("숫자 : ");
		String input = reader.readLine();
		int num = Integer.parseInt(input);
		
		System.out.printf("입력하신 숫자 '%d'는(은) '%s'입니다.", num, getNumber(num));
	}
	
	public static String getNumber(int num) {
		String result = num % 2 == 1 ? "홀수" : "짝수";
		return result;
	}
}
