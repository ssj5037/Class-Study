package com.test.control;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Ex12_For_question_06 {

	public static void main(String[] args) throws Exception{
		
		// 요구사항 06
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("시작 숫자 : ");
		int num1 = Integer.parseInt(reader.readLine());
		System.out.print("종료 숫자 : ");
		int num2 = Integer.parseInt(reader.readLine());
		
		int sum = 0;
		for(int i=num1; i<=num2; i++) {
			sum += i;
			System.out.printf("%d - ", i);
			i++;
			if(i <= num2) {
				sum -= i;
				System.out.printf("%d + ", i);
			}
		}
		System.out.printf("\b\b= %d\r\n", sum);
	}
}
