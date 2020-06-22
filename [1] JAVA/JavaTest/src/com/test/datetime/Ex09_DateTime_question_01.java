package com.test.datetime;

import java.util.Calendar;

public class Ex09_DateTime_question_01 {

	public static void main(String[] args) {
		
		// 요구사항 01
		
		nowTime();
		nowTime_AMPM();
	}

	private static void nowTime() {
		// TODO Auto-generated method stub
		Calendar now = Calendar.getInstance();
		System.out.printf("현재 시간 : %d시 %d분 %d초\r\n"
				, now.get(Calendar.HOUR_OF_DAY)
				, now.get(Calendar.MINUTE)
				, now.get(Calendar.SECOND));
	}
	
	private static void nowTime_AMPM() {
		// TODO Auto-generated method stub
		Calendar now = Calendar.getInstance();
		System.out.printf("현재 시간 : %s %d시 %d분 %d초\r\n"
				, now.get(Calendar.AM_PM) == 0 ? "오전" : "오후"
				, now.get(Calendar.HOUR)
				, now.get(Calendar.MINUTE)
				, now.get(Calendar.SECOND));
	}
}
