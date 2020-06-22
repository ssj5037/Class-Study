package com.test.array;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Ex15_Array_question_06 {
	
	public static void main(String[] args) throws Exception {
		
		// 요구사항 06
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("최대 범위 : ");
		int maxValue = Integer.parseInt(reader.readLine());
		System.out.print("최소 범위 : ");
		int minValue = Integer.parseInt(reader.readLine());
		
		int[] num = new int[20];
		for (int i=0; i<num.length; i++) {
			num[i] = (int)(Math.random() * 20 + 1);
		}

		System.out.print("원본 :");
		for (int i=0; i<num.length; i++) {
			if (i != num.length-1) {
				System.out.printf(" %d,",num[i]);
			} else {
				System.out.printf(" %d\r\n",num[i]);
			}

		}
		System.out.print("결과 :");
		for (int i=0; i<num.length; i++) {
			if(num[i] >= minValue && num[i] <= maxValue) {
				if (i != num.length-1) {
					System.out.printf(" %d,",num[i]);
				} else {
					System.out.printf(" %d\r\n",num[i]);
				}
			}
		}
	}

}
