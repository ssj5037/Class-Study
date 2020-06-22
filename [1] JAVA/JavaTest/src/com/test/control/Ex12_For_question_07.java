package com.test.control;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Ex12_For_question_07 {

	public static void main(String[] args) throws Exception {
		
		// 요구사항 07
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("아래에 입력하세요.");
		
		boolean loop = true;
		for (;loop;) {
			String input = reader.readLine();
			if(input.equals("")) {
				System.out.println("프로그램을 종료합니다.");
				loop = false;
			} else {
				System.out.println(input);
			}
		}
	}
	
}
