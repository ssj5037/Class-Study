package com.test.control;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Ex12_For_question_10 {

	public static void main(String[] args) {
		
		// 요구사항 10
		
		int year = 2020;
		int month = 4;
		int date = 17;
		
		int sum = 0;
		
		// 1년 ~ year년까지 반복
		for (int i=1; i<=year; i++) {
			// 마지막 해가 왔을 때
			if (i == year) {
				// 1월 ~ month월까지 반복
				for (int j=1; j<=month; j++) {
					// 마지막 달이 왔을 때 지정한 일 합산
					if (j == month) {
						sum += date;
					} else {	// 그 외의 달은 몇일인지 체크해서 합산
						sum += monthCheck(year, month);
					}
				}
			} else {	// 마지막이 아닌 해
				// 1월 ~ 12월 반복
				for (int k=1; k<=12; k++) {
					sum += monthCheck(i, k);
				}
			}
		}
		String day = dayCheck(sum);
		System.out.printf("%d년 %d월 %d일은 %s요일이고, %,d일째 되는 날입니다.\r\n"
				, year, month, date, day, sum);
	}

	private static String dayCheck(int sum) {
		// TODO Auto-generated method stub
		int day = sum % 7;
		String whatday = "";
		switch (day) {
			case 1:
				whatday = "일";
				break;
			case 2:
				whatday = "월";
				break;
			case 3:
				whatday = "화";
				break;
			case 4:
				whatday = "수";
				break;
			case 5:
				whatday = "목";
				break;
			case 6:
				whatday = "금";
				break;
			case 0:
				whatday = "토";
				break;
		}
		return whatday;
	}

	private static int monthCheck(int year, int month) {
		// TODO Auto-generated method stub
		int date = 0;
		switch (month) {
			// 1 3 5 7 8 9 10 12월 = 31일
			case 1:
			case 3:
			case 5:
			case 7:
			case 8:
			case 10:
			case 12:
				date = 31;
				break;
			// 4 6 9 11월 = 30일 
			case 4:
			case 6:
			case 9:
			case 11:
				date = 30;
				break;
			// 2월
			case 2:
				// 4로 나누어 떨어지면 재검사
				if(year % 4 == 0) {
					// 100으로 나누어 떨어지면 재검사
					if (year % 100 == 0) {
						// 400으로 나누어 떨어지면 윤년
						if(year % 400 == 0) {
							date = 29;
						} else {	// 400으로 나누어 떨어지지 않으면 평년
							date = 28;
						}
					} else {	// 100으로 나누어 떨어지지 않으면 윤년
						date = 29;
					}
				} else {	// 4로 나누어 떨어지지 않으면 평년
					date = 28;
				}
				break;
		}
		return date;
	}
}
