package com.test.array;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Ex15_Array_question_04 {
	
	public static void main(String[] args) throws Exception {
		
		// 요구사항 04
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("배열의 길이 : ");
		int len = Integer.parseInt(reader.readLine());
		
		int[] nums = new int[len];
		int[] result;
		if(len % 2 == 0) {
			result = new int[len/2];
		} else {
			result = new int[len/2+1];
		}

		System.out.print("nums = [");
		for (int i=0; i<len; i++) {
			nums[i] = (int)(Math.random() * 10 + 1);
			if(i != len-1) {
				System.out.printf(" %d,",nums[i]);
			} else {
				System.out.printf(" %d ]\r\n",nums[i]);
			}
		}
		
		int temp = 0;
		for (int i=0; i<len; i++) {
			if (i % 2 == 0) {
				temp += nums[i];
				result[i/2] = temp;
			} else {
				temp += nums[i];
				result[i/2] = temp;
				temp = 0;
			}
		}
		
		System.out.print("result = [");
		for (int i=0; i<result.length; i++) {
			if(i != result.length-1) {
				System.out.printf(" %d,",result[i]);
			} else {
				System.out.printf(" %d ]\r\n",result[i]);
			}
		}
		
	}

}
