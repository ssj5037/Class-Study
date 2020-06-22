package com.test.array;

public class Ex15_Array_question_17 {

	public static void main(String[] args) {
			
		// 요구사항 17
		int n=1;
		int[][] num = new int[5][5];
		
		// 입력
		for (int i=0; i<num.length; i++) {
			int k = i;
			for (int j=0; j<=i; j++) {
				if(j != i) {
					num[j][k] = n;
					n++;
					k--;
				} else {
					num[j][k] = n;
					n++;
					break;
				}
			}
		}
		
		for (int j=1; j<num.length; j++) {
			int k = j;
			for (int i=num.length-1; i>0; i--) {
				if(i != j) {
					num[k][i] = n;
					n++;
					k++;
				} else {
					num[k][i] = n;
					n++;
					break;
				}
			}
		}
		
		/*
		00
		01 10
		02 11 20
		03 12 21 30
		04 13 22 31 40
		14 23 32 41
		24 33 42
		34 43
		44
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
