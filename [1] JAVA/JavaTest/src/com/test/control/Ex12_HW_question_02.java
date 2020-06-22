package com.test.control;

public class Ex12_HW_question_02 {

	public static void main(String[] args) {
		
		// 요구사항 02
		
		for(int i=1; i<=5; i++) {
			for (int j=5; j>=1; j--) {
				if(i>j) {
					continue;
				}
				System.out.printf("i : %d, j : %d\r\n", i, j);
			}
		}
	}
}
