package com.test.control;

public class Ex12_For_question_17 {

	public static void main(String[] args) {
		
		// 요구사항 17
		
		boolean loop = true;
		
		int a = 1;
		int b = 0;
		int result = 0;
		int sum = 1;
		
		for (;loop;) {
			if (result < 100) {
				System.out.printf("%d + ", a);
				sum += result;
				result = a + b;
				b = a;
				a = result;
			} else {
				loop = false;
			}
		}
		System.out.printf("\b\b= %d\r\n", sum);
	}
	
}
