package com.test.control;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Ex12_HW_question_05 {

	public static void main(String[] args) throws Exception {
		
		// 요구사항 05
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("출력할 행의 갯수 : ");
		int line = Integer.parseInt(reader.readLine());
		
		for (int i=0; i<=line-1; i++) {
			for (int j=line-1; j>=-(line-1); j--) {
				if(j>=0) {
					if(i>=j) {
						System.out.print("*");
					}
					else {
						System.out.print(" ");
					}
				}
				else {
					if(i>=-j) {
						System.out.print("*");
					}
					else {
						System.out.print(" ");
					}
				}
			}
			System.out.print("\r\n");
		}
	}
}
