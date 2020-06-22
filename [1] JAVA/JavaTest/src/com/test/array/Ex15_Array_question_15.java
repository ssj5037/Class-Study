package com.test.array;

public class Ex15_Array_question_15 {
	
	public static void main(String[] args) {
		
		// 요구사항 15
		int n=1;
		int[][] num = new int[5][5];
		
		// 입력
		for (int i=0; i<num.length-1; i++) {
			for (int j=0; j<num[0].length-1; j++) {
				num[i][j] = n;
				num[i][4] += num[i][j];
				num[4][j] += num[i][j];
				num[4][4] += num[i][j];
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
