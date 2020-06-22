package com.test.array;

public class Ex15_Array_question_07 {
	
	public static void main(String[] args) {
		
		// 요구사항 07
		
		int[] num = new int[5];
		for(int i=0; i<num.length; i++) {
			num[i] = (int)(Math.random() * 9 + 1);
			for(int j=0; j<i; j++) {
				if (num[i] == num[j]) {
					i--;
					continue;
				}
			}
		}

		System.out.print("[");
		for (int i=0; i<num.length; i++) {
			if(i != num.length - 1) {
				System.out.printf("%d, ",num[i]);
			} else {
				System.out.printf("%d]\r\n", num[i]);
			}
		}
	}

}
