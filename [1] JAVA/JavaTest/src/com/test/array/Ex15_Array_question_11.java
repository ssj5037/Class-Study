package com.test.array;

public class Ex15_Array_question_11 {
	
	public static void main(String[] args) {
		
		// 요구사항 11
		
		int n=1;
		int[][] num = new int[5][5];
		
		// 입력
		for (int i=num.length-1; i>=0; i--) {
			for (int j=num[0].length-1; j>=0; j--) {
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
