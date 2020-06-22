package com.test.control;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Ex12_For_question_15 {

	public static void main(String[] args) throws Exception {
		
		// 요구사항 15
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("9자리 숫자 입력 : ");
		long num = Long.parseLong(reader.readLine());
		
		int evenSum = 0;
		int oddSum = 0;
		
		if (num < 1000000000) {
			// 10의자리까지 하나씩 빼서 홀짝 구분
			for (int i=8; i>0; i--) {
				int eachNum = (int)(num / Math.pow(10, i));
				if(eachNum % 2 == 0) {
					evenSum += eachNum;
				} else {
					oddSum += eachNum;
				}
				num = num - (long)(eachNum * Math.pow(10, i));
			}
			// 1의자리 홀짝 구분
			int eachNum = (int)(num % 10);
			if(eachNum % 2 == 0) {
				evenSum += eachNum;
			} else {
				oddSum += eachNum;
			}
			
			System.out.printf("짝수의 합 : %d\r\n", evenSum);
			System.out.printf("홀수의 합 : %d\r\n", oddSum);
			
		} else {
			System.out.println("9자리 이내로 입력하시오.\r\n프로그램을 종료합니다.");
		}
	}
}
