package com.test.datetime;

import java.util.Calendar;

public class Ex09_DateTime_question_02 {

	public static void main(String[] args) {
		
		// 요구사항 02
		
		baby();
	
	}

	private static void baby() {
		// TODO Auto-generated method stub
		
		Calendar hundred = Calendar.getInstance();
		hundred.add(Calendar.DATE, 100);
		System.out.printf("백일 : %tF\r\n", hundred);
		Calendar oneYear = Calendar.getInstance();
		oneYear.add(Calendar.YEAR, 1);
		System.out.printf("첫돌 : %tF\r\n", oneYear);
	}
}
