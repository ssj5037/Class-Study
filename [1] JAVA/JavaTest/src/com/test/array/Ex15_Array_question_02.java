package com.test.array;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Ex15_Array_question_02 {
	
	public static void main(String[] args) throws Exception {
		
		// 요구사항 02
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		int[] nums = new int[5];

		for (int i=0; i<5; i++) {
			System.out.print("숫자 : ");
			nums[i] = Integer.parseInt(reader.readLine());
		}
		
		for (int i=4; i>=0; i--) {
			System.out.printf("nums[%d] = %d\r\n", i, nums[i]);
		}
	}

}
