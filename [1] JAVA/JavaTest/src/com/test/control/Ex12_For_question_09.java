package com.test.control;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Ex12_For_question_09 {

	public static void main(String[] args) throws Exception {
		
		// 요구사항 09
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("입력할 숫자의 개수 : ");
		int input = Integer.parseInt(reader.readLine());
		System.out.print("누적 값 : ");
		int stack = Integer.parseInt(reader.readLine());
		
		boolean loop = true;
		int sum = 0;
		String numSum = "";
		
		for (int i=1; loop; i++) {
			// 입력할 숫자의 개수 만큼 루프를 돌림
			if(i <= input) {	
				// 숫자 입력
				System.out.print("숫자 : ");
				int num = Integer.parseInt(reader.readLine());
				// 누적값이 지정된 값보다 크면 루프 종료
				if(sum > stack) {
					loop = false;
				} else {
					// 처음 입력된 숫자인지 구분
					if(i == 1) {
						// 처음 입력된 숫자는 짝수일 경우 앞에 + 부호 생략
						// 홀수는 빼줘야 하므로 그대로 - 부호 붙임
						if(num % 2 == 0) {
							sum += num;
							numSum += num;
							// string에 값 저장
						} else {
							sum -= num;
							numSum += " - " + num;
						}
					} else {
						// 짝수는 더하고 홀수는 빼주고
						if(num % 2 == 0) {
							sum += num;
							numSum += " + " + num;
						} else {
							sum -= num;
							numSum += " - " + num;
						}
					}
				}
			} else {	//지정한 개수만큼 숫자 입력하면 루프 종료
				loop = false;
			}
		}
		System.out.printf("%s = %d", numSum, sum);
		
		
	}
	
}
