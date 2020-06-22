package com.test.control;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Ex10_IF_question_03 {

	public static void main(String[] args) throws Exception {
		
		// 요구사항 03
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("첫번째 숫자 : ");
		int num1 = Integer.parseInt(reader.readLine());
		
		System.out.print("두번째 숫자 : ");
		int num2 = Integer.parseInt(reader.readLine());
		
		System.out.print("연산자(+-*/%) : ");
		char op = (char)reader.read();
		
		if (op == '+') {
			System.out.printf("%,d %c %,d = %,d", num1, op, num2, (long)num1 + num2);
		} else if (op == '-') {
			System.out.printf("%,d %c %,d = %,d", num1, op, num2, num1 - num2);
		} else if (op == '*') {
			System.out.printf("%,d %c %,d = %,d", num1, op, num2, (long)num1 * num2);
		} else if (op == '/') {
			System.out.printf("%d %c %d = %.1f", num1, op, num2, (double)num1 / num2);
		} else if (op == '%') {
			System.out.printf("%,d %c %,d = %,d", num1, op, num2, num1 % num2);
		} else {
			System.out.println("산술 연산자만 입력하시오.");
		}
		
	}
}
