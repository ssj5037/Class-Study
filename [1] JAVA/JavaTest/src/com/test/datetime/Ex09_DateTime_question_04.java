package com.test.datetime;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Calendar;

public class Ex09_DateTime_question_04 {

	public static void main(String[] args) throws IOException {
		
		// 요구사항 04
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		System.out.print("남자 이름 : ");
		String mName = reader.readLine();
		System.out.print("여자 이름 : ");
		String wName = reader.readLine();
		
		System.out.print("만난날(년) : ");
		String input1 = reader.readLine();
		int year = Integer.parseInt(input1);
		System.out.print("만난날(월) : ");
		String input2 = reader.readLine();
		int month = Integer.parseInt(input2);
		System.out.print("만난날(일) : ");
		String input3 = reader.readLine();
		int date = Integer.parseInt(input3);
		
		anniversary(mName, wName, year, month, date);
	}

	private static void anniversary(String mName, String wName, int year, int month, int date) {
		// TODO Auto-generated method stub
		
		Calendar anniversary = Calendar.getInstance();
		anniversary.set(year, month, date);
		
		System.out.printf("'%s'과(와) '%s'의 기념일\r\n", mName, wName);
		anniversary.add(Calendar.DATE, 100);
		System.out.printf("100일 : %tF\r\n", anniversary);
		anniversary.add(Calendar.DATE, 100);
		System.out.printf("200일 : %tF\r\n", anniversary);
		anniversary.add(Calendar.DATE, 100);
		System.out.printf("300일 : %tF\r\n", anniversary);
		anniversary.add(Calendar.DATE, 200);
		System.out.printf("500일 : %tF\r\n", anniversary);
		anniversary.add(Calendar.DATE, 500);
		System.out.printf("1000일 : %tF\r\n", anniversary);
	}
}
