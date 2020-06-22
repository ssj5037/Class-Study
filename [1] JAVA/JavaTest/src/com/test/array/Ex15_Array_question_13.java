package com.test.array;

public class Ex15_Array_question_13 {

	public static void main(String[] args) {
		
		// 요구사항 13
		
		int n=1;
		int[][] num = new int[5][5];
		
		// 입력
		for (int i=0; i<num.length; i++) {
			for (int j=0; j<5-i; j++) {
				num[i][j] = n;
				n++;
			}
		}
		
		// 출력
		for (int i=0; i<num.length; i++) {
			for (int j=0; j<num[0].length; j++) {
				System.out.printf("%2d\t", num[i][j]);
			}
			System.out.println();
		}
	}

}
