package com.test.control;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Ex12_HW_question_07 {
	
	public static void main(String[] args) throws Exception {
		
		// 요구사항 07
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("출력할 행의 갯수 : ");
		int line = Integer.parseInt(reader.readLine());
		int initChar = 97;
		
		for (int i=1; i<=line; i++) {
			int temp=0;
			for (int j=line; j>=-line; j--) {
				if(j==0) {
					continue;
				}
				if(j>0) {
					if(i>=j) {
						System.out.printf("%c", (char)(initChar + temp));
						temp++;
					}
					else {
						System.out.print(" ");
					}
				}
				else {
					if(i>=-j) {
						temp--;
						System.out.printf("%c", (char)(initChar + temp));
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
