package com.test.control;

public class Ex12_HW_question_09 {

	public static void main(String[] args) {
		
		// 요구사항 09
		
		for (int i=10; i<=100; i+=10) {
			int sum = 0;
			for (int j=1; j<=i; j++) {
				sum += j;
			}
			System.out.printf("1 ~ %3d : %4d\r\n", i, sum);
		}
	}
}
