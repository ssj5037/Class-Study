package com.test.array;

public class Ex15_Array_question_19 {

	public static void main(String[] args) {
		
		// 요구사항 17
		int n=1;
		int[][] num = new int[3][3];
		
		// 입력
		for(int k=0; k<num.length/2; k++) {
			for (int i=k; i<num.length-k; i++) {
				
			}
		}

		/*
		
		12
		03 > 01
		-12 > 22
		
		
		*/
		
		// 출력
		for (int i=0; i<num.length; i++) {
			for (int j=0; j<num[0].length; j++) {
				System.out.printf("%2d\t", num[i][j]);
			}
			System.out.println();
		}
	}
}
