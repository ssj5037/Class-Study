package com.test.control;

public class Ex12_For_question_16 {

	public static void main(String[] args) {
		
		// 요구사항 16
		
		boolean loop = true;
		int a = 1;
		int sum = 0;
		for (int i=1; loop; i++) {
			if(a < 100) {
				sum += a;
				System.out.printf("%d + ",a);
			} else {
				loop = false;
			}
			a += i; 
		}
		System.out.printf("\b\b= %d\r\n", sum);
	}
	
}
