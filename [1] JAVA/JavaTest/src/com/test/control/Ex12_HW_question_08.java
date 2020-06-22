package com.test.control;

public class Ex12_HW_question_08 {

	public static void main(String[] args) {
		
		// 요구사항 08
		
		for (int k=1; k<=2; k++) {
			for (int i=1; i<=9; i++) {
				if(k==1) {
					for (int j=2; j<=5; j++) {
						System.out.printf("%d x %d = %2d  ", j, i, j*i);
					}
					System.out.print("\r\n");
				} else {
					for (int j=6; j<=9; j++) {
						System.out.printf("%d x %d = %2d  ", j, i, j*i);
					}
					System.out.print("\r\n");
				}
			}
			System.out.println();
		}
	}
}
