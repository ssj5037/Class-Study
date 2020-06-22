package com.test.control;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Ex12_For_question_08 {

	public static void main(String[] args) throws Exception {
		
		// 요구사항 08
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("누적 값 : ");
		int stack = Integer.parseInt(reader.readLine());
		boolean loop = true;
		int sum = 0;
		
		for (int i=1; loop; i++) {
			if (sum > stack) {
				loop = false;
			} else {
				sum += i;
				System.out.printf("%,d + ", i);
			}
		}
		System.out.printf("\b\b= %,d", sum);
	}
	
}
