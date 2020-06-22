package com.test.array;

public class Ex15_Array_question_18 {

	public static void main(String[] args) {
			
		// 요구사항 17
		int n=1;
		int[][] num = new int[7][7];
		
		// 입력
		for(int k=0; k<num.length/2; k++) {
			for (int i=k; i<num.length-k; i++) {
				for (int j=k; j<num.length-k; j++) {
					if(i == k) {
						num[i][j] = n;
						n++;
					} else {
						num[i][num.length-1-k] = n;
						n++;
						break;
					}
				}
			}
			
			for (int i=num.length-1-k; i>k ; i--) {
				for (int j=num.length-2-k; j>=k; j--) {
					if(i == num.length-1-k) {
						num[i][j] = n;
						n++;
					} else {
						num[i][k] = n;
						n++;
						break;
					}
				}
			}
		}
		if(num.length % 2 == 1) {
			num[num.length/2][num.length/2] = n;
		}
		
//		for (int i=0; i<num.length; i++) {
//			for (int j=0; j<num.length; j++) {
//				if(i == 0) {
//					num[i][j] = n;
//					n++;
//				} else {
//					num[i][num.length-1] = n;
//					n++;
//					break;
//				}
//			}
//		}
		
//		for (int i=num.length-1; i>0 ; i--) {
//			for (int j=num.length-2; j>=0; j--) {
//				if(i == num.length-1) {
//					num[i][j] = n;
//					n++;
//				} else {
//					num[i][0] = n;
//					n++;
//					break;
//				}
//			}
//		}
		
//		for (int i=1; i<num.length-1; i++) {
//			for (int j=1; j<num.length-1; j++) {
//				if(i == 1) {
//					num[i][j] = n;
//					n++;
//				} else {
//					num[i][num.length-2] = n;
//					n++;
//					break;
//				}
//			}
//		}
		
//		for (int i=num.length-2; i>1 ; i--) {
//			for (int j=num.length-3; j>=1; j--) {
//				if(i == num.length-2) {
//					num[i][j] = n;
//					n++;
//				} else {
//					num[i][1] = n;
//					n++;
//					break;
//				}
//			}
//		}
		
		/*
		
		00 01 02 03 04 14 24 34 44
		43 42 41 40 30 20 10
		11 12 13 23 33
		32 31 21
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
