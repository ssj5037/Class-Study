package com.test.method;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Ex08_Method_question_07 {

	public static void main(String[] args) throws Exception {
		
		// 요구사항 07
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("국어 : ");
		String input1 = reader.readLine();
		int kor = Integer.parseInt(input1);

		System.out.print("영어 : ");
		String input2 = reader.readLine();
		int eng = Integer.parseInt(input2);
		
		System.out.print("수학 : ");
		String input3 = reader.readLine();
		int math = Integer.parseInt(input3);
		
		System.out.printf("%s입니다.", test(kor, eng, math));
		
	}
	
	public static String test(int n1, int n2, int n3) {
		int avg = (n1 + n2 + n3) / 3;
		String result = n1 < 40 || n2 < 40 || n3 < 40 ? "불합격" : avg >= 60 ? "합격" : "불합격";
		return result;
	}
}
