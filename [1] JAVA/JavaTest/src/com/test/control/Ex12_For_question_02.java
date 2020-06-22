package com.test.control;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Ex12_For_question_02 {

	public static void main(String[] args) throws Exception {
		
		// 요구사항 02

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("시작 숫자 : ");
		int num1 = Integer.parseInt(reader.readLine());		
		System.out.print("종료 숫자 : ");
		int num2 = Integer.parseInt(reader.readLine());
		System.out.print("증가치 : ");
		int num3 = Integer.parseInt(reader.readLine());
		
		for (int i=num1; i<=num2; i+=num3) {
			System.out.println(i);
		}
		
	}
}
