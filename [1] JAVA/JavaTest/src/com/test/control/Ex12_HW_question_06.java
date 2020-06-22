package com.test.control;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Ex12_HW_question_06 {

	public static void main(String[] args) throws Exception {
		
		// 요구사항 06
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("출력할 행의 갯수 : ");
		int num = Integer.parseInt(reader.readLine());
		
		for (int i=1; i<=num; i++) {
			for (int j=1; j<=num; j++) {
				if(i==j) {
					System.out.print("*");
				}
				else {
					System.out.print(" ");
				}
			}
			System.out.print("\r\n");
		}
	}
}
