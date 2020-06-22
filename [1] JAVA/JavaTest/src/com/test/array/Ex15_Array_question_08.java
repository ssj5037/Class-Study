package com.test.array;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Ex15_Array_question_08 {
	
	public static void main(String[] args) throws Exception {
		
		// 요구사항 08
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("삽입 위치 : ");
		int position = Integer.parseInt(reader.readLine());
		System.out.print("값 : ");
		int value = Integer.parseInt(reader.readLine());
		
		int[] num = new int[10];
		System.out.print("원본 : [");
		for (int i=0; i<num.length; i++) {
			num[i] = (int)(Math.random() * 10);
			if(i != num.length - 1) {
				System.out.printf("%d, ",num[i]);
			} else {
				System.out.printf("%d]\r\n", num[i]);
			}
		}
		
		for (int i=num.length-1; i>=position; i--) {
			if(i==position) {
				num[i] = value;
			} else {
				num[i] = num[i-1];
			}
		}
		
		System.out.print("결과 : [");
		for (int i=0; i<num.length; i++) {
			if(i != num.length - 1) {
				System.out.printf("%d, ",num[i]);
			} else {
				System.out.printf("%d]\r\n", num[i]);
			}
		}
	}
}
