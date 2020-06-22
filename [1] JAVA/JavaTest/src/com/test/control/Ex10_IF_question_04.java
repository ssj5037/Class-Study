package com.test.control;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Ex10_IF_question_04 {

	public static void main(String[] args) throws Exception{
		
		// 요구사항 04
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("문자 : ");
		String letter = reader.readLine();
		
		if (letter.equals("f") || letter.equals("F")) {
			System.out.println("Father");
		} else if (letter.equals("m") || letter.equals("M")) {
			System.out.println("Mother");
		} else if (letter.equals("s") || letter.equals("S")) {
			System.out.println("Sister");
		} else if (letter.equals("b") || letter.equals("B")) {
			System.out.println("Brother");
		} else {
			System.out.println("바른 문자를 입력하시오. (fFmMsSbB 중 1개)");
		}
	}
}
