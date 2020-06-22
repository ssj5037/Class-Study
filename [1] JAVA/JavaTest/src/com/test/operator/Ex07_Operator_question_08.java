package com.test.operator;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Ex07_Operator_question_08 {

	public static void main(String[] args) throws Exception {
		
		// 요구사항 08

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("날짜 입력 : ");
		String input1 = reader.readLine();
		int date = Integer.parseInt(input1);
		
		int dayNum = date % 7;
		String WhatDay = dayNum == 6 ? "월요일" : 
			dayNum == 5 ? "일요일" :
				dayNum == 4 ? "토요일" :
					dayNum == 3 ? "금요일" :
						dayNum == 2 ? "목요일" :
							dayNum == 1 ? "수요일" : "화요일";
		// 나머지가 6이면 월요일 대입
		// 6이 아니면 5인지 확인, 5면 일요일 대입
		// 5가 아니면 ...(중략)
		// 1까지 반복하고 1도 아니면 마지막 요일인 화요일 대입
		
		System.out.printf("입력하신 2020년 4월 %d일은 '%s'입니다.", date, WhatDay);

	}
}
