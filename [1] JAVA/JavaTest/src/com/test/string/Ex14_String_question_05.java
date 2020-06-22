package com.test.string;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Ex14_String_question_05 {

	public static void main(String[] args) throws Exception {
		
		// 요구사항 05
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("숫자 : ");
		String num = reader.readLine();
		
		int commaStart = num.length() % 3;
		System.out.print("결과 : ");
		if(commaStart != 0) {
			System.out.printf("%s", num.substring(0, commaStart));
			for (int i=0;i<(num.length()-commaStart);i+=3) {
				System.out.printf(",%s", num.substring(commaStart+i, commaStart+(i+3)));
			}
		} else {
			commaStart = 3;
			System.out.printf("%s", num.substring(0, commaStart));
			for (int i=0;i<(num.length()-commaStart);i+=3) {
				System.out.printf(",%s", num.substring(commaStart+i, commaStart+(i+3)));
			}
		}
	}
}
