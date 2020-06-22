package com.test.datetime;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Calendar;

public class Ex09_DateTime_question_06 {

	public static void main(String[] args) throws IOException {
		
		// 요구사항 06
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		System.out.println("음식을 받기 원하는 시각");
		System.out.print("시 : ");
		String input1 = reader.readLine();
		int hour = Integer.parseInt(input1);
		System.out.print("분 : ");
		String input2 = reader.readLine();
		int min = Integer.parseInt(input2);
		
		delivery(hour, min);
	}

	private static void delivery(int hour, int min) {
		// TODO Auto-generated method stub
		Calendar now = Calendar.getInstance();
		now.set(Calendar.HOUR_OF_DAY, hour);
		now.set(Calendar.MINUTE, min);
		
		now.add(Calendar.MINUTE, -10);
		System.out.printf("짜장면 : %d시 %d분\r\n"
				, now.get(Calendar.HOUR_OF_DAY), now.get(Calendar.MINUTE));
		now.add(Calendar.MINUTE, -8);
		System.out.printf("치킨 : %d시 %d분\r\n"
				, now.get(Calendar.HOUR_OF_DAY), now.get(Calendar.MINUTE));
		now.add(Calendar.MINUTE, -7);
		System.out.printf("피자 : %d시 %d분\r\n"
				, now.get(Calendar.HOUR_OF_DAY), now.get(Calendar.MINUTE));
	}
}
