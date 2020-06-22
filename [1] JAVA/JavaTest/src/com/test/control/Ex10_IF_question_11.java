package com.test.control;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Ex10_IF_question_11 {

	public static void main(String[] args) throws Exception {
		
		// 요구사항 11
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("숫자 입력 : ");
		long num = Long.parseLong(reader.readLine());
		
		if (num <= Long.MAX_VALUE && num >= Long.MIN_VALUE) {
			if (num <= Integer.MAX_VALUE && num >= Integer.MIN_VALUE) {
				if (num <= Short.MAX_VALUE && num >= Short.MIN_VALUE) {
					if (num <= Byte.MAX_VALUE && num >= Byte.MIN_VALUE) {
						System.out.println("byte");
					}
					System.out.println("short");
				}
				System.out.println("int");
			}
			System.out.println("long");
		} else {
			System.out.println("정수를 입력하시오.");
		}
		
	}
}
