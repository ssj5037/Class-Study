package com.test.array;

public class Ex15_Array_question_12 {

	public static void main(String[] args) {
		
		// 요구사항 12
		
		int n=1;
		int[][] num = new int[5][5];
		
		// 입력
		for (int i=0; i<num.length; i++) {
			for (int j=0; j<num[0].length; j++) {
				num[j][i] = n;
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
