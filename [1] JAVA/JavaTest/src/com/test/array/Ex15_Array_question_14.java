package com.test.array;

public class Ex15_Array_question_14 {

	public static void main(String[] args) {
		
		// 요구사항 13
		
		int n=1;
		int[][] num = new int[5][5];
		
		// 입력
		for (int i=0; i<num.length; i++) {
			for (int j=0; j<num[0].length; j++) {
				int[] start = {2,1,0,1,2};
				int[] end = {2,3,4,3,2};

				if (j >= start[i] && j <= end[i]) {
					num[i][j] = n;
					n++;
				}
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
