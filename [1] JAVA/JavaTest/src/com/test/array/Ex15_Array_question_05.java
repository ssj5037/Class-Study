package com.test.array;

public class Ex15_Array_question_05 {
	
	public static void main(String[] args) {
		
		// 요구사항 05
		
		int[] num = new int[20];
		for (int i=0; i<num.length; i++) {
			num[i] = (int)(Math.random() * 20 + 1);
		}

		int max = 0, min = 20;
		System.out.print("원본 :");
		for (int i=0; i<num.length; i++) {
			if (i != num.length-1) {
				System.out.printf(" %d,",num[i]);
			} else {
				System.out.printf(" %d\r\n",num[i]);
			}
			
			if (num[i] > max) {
				max = num[i];
			}
			if (num[i] < min) {
				min = num[i];
			}
		}
		System.out.printf("최대값 : %d\r\n최소값 : %d\r\n", max, min);
	}

}
