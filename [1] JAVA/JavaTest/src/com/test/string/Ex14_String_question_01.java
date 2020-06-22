package com.test.string;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Ex14_String_question_01 {

	public static void main(String[] args) throws Exception {
		
		// 요구사항 01
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("문장 입력 : ");
		String txt = reader.readLine();
		
		System.out.print("역순 결과 : ");
		for (int i=txt.length()-1; i>=0; i--) {
			System.out.print(txt.charAt(i));
		}
		
	}
	
}
