package com.test.datetime;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Calendar;

public class Ex09_DateTime_question_03 {

	public static void main(String[] args) throws IOException {
		
		// 요구사항 03
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("태어난 년도 : ");
		String input = reader.readLine();
		int year = Integer.parseInt(input);
		
		age(year);
	}

	private static void age(int year) {
		// TODO Auto-generated method stub
		
		Calendar now = Calendar.getInstance();
		System.out.printf("나이 : %d세\r\n", now.get(Calendar.YEAR) - year +1);
	}
}
