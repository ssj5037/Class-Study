package com.test.string;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Ex14_String_question_07 {

	public static void main(String[] args) throws Exception {
		
		// 요구사항 07
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("단어 : ");
		String inputWord = reader.readLine();
		String resultWord = inputWord.charAt(0) + "";
		
		for (int i=1; i<inputWord.length(); i++) {
			char letter = inputWord.charAt(i);
			if(letter >= 'A' && letter <='Z') {
				resultWord += " " + letter;
			} else {
				resultWord += letter;
			}
		}
		System.out.printf("결과 : %s", resultWord);
	}
}
