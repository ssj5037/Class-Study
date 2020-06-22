package com.test.error;

import java.io.BufferedReader;
import java.io.InputStreamReader;
// import가 빠졌음

public class Ex05_Input_use {

	public static void main(String[] args) throws Exception {
		
		BufferedReader reader 
		= new BufferedReader(new InputStreamReader(System.in));
		// BufferedReader, InputStreamReader를 import 해와야 함
		
		System.out.print("첫번째 숫자: ");
		String num1 = reader.readLine();
		
		System.out.print("두번째 숫자: ");
		String num2 = reader.readLine();
		
//		int realNum1 = (int)num1; 수정 전
//		int realNum2 = (int)num2; 수정 전
		int realNum1 = Integer.parseInt(num1);
		int realNum2 = Integer.parseInt(num2);
		// string은 자료형변환을 사용할 수 없음. 메소드 이용		
		
		System.out.printf("%,d + %,d = %,d\n"
								, realNum1
								, realNum2
								, realNum1 + realNum2);
				
		
		
	}
	
}













