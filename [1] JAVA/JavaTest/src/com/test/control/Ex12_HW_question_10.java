package com.test.control;

public class Ex12_HW_question_10 {

	public static void main(String[] args) {
		
		// 요구사항 10
		
		for (int i=0; i<=9; i++) {
			int sum = 0;
			for (int j=1; j<=10; j++) {
				sum += (i * 10 + j);
			}
			System.out.printf("%2d ~ %3d : %3d\r\n", i*10+1, i*10+10, sum);
		}
	}
}
