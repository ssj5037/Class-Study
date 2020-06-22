package com.test.control;

public class Ex12_HW_question_01 {

	public static void main(String[] args) {
		
		// 요구사항 01
		
		for (int i=1; i<=5; i++) {
			for (int j=1; j<=5; j++) {
				if(i > j) {
					continue;
				}
				System.out.printf("i : %d, j : %d\r\n", i, j);
			}
		}

	}
}
