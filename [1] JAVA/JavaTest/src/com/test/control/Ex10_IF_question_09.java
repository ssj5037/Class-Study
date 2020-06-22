package com.test.control;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Calendar;

public class Ex10_IF_question_09 {

	public static void main(String[] args) throws Exception {
		
		// 요구사항 09
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("년 : ");
		int year = Integer.parseInt(reader.readLine());
		System.out.print("월 : ");
		int month = Integer.parseInt(reader.readLine());
		System.out.print("일 : ");
		int date = Integer.parseInt(reader.readLine());
		
		Calendar now = Calendar.getInstance();
		now.set(year, month-1, date);
		int day = now.get(Calendar.DAY_OF_WEEK);
		
		if (day >= 2 && day <= 6) {
			if (day == 2) {
				now.set(Calendar.DATE, date + 5);
			} else if (day == 3) {
				now.set(Calendar.DATE, date + 4);
			} else if (day == 4) {
				now.set(Calendar.DATE, date + 3);
			} else if (day == 5) {
				now.set(Calendar.DATE, date + 2);
			} else if (day == 6) {
				now.set(Calendar.DATE, date + 1);
			} 
			System.out.println("입력하신 날짜는 '평일'입니다.");
			System.out.println("해당 주의 토요일로 이동합니다.");
			System.out.printf("이동한 날짜는 '%tF'입니다.", now);
		} else {
			System.out.println("입력하신 날짜는 '휴일'입니다.");
			System.out.println("결과가 없습니다.");
		}
		
		
	}
}
