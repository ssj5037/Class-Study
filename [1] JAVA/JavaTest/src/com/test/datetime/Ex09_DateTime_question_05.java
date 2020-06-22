package com.test.datetime;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Calendar;

import javax.xml.ws.FaultAction;

public class Ex09_DateTime_question_05 {

	public static void main(String[] args) throws IOException {
		
		// 요구사항 05
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		System.out.print("아빠 생일(년) : ");
		String input1 = reader.readLine();
		int f_year = Integer.parseInt(input1);
		System.out.print("아빠 생일(월) : ");
		String input2 = reader.readLine();
		int f_month = Integer.parseInt(input2);
		System.out.print("아빠 생일(일) : ");
		String input3 = reader.readLine();
		int f_date = Integer.parseInt(input3);
		
		System.out.print("딸 생일(년) : ");
		String input4 = reader.readLine();
		int d_year = Integer.parseInt(input4);
		System.out.print("딸 생일(월) : ");
		String input5 = reader.readLine();
		int d_month = Integer.parseInt(input5);
		System.out.print("딸 생일(일) : ");
		String input6 = reader.readLine();
		int d_date = Integer.parseInt(input6);
		
		birthCompare(f_year, f_month, f_date, d_year, d_month, d_date);
		
	}

	private static void birthCompare(int f_year, int f_month, int f_date, int d_year, int d_month, int d_date) {
		// TODO Auto-generated method stub
		Calendar fatherBirth = Calendar.getInstance();
		fatherBirth.set(f_year, f_month, f_date);
		long fatherTick = fatherBirth.getTimeInMillis();
		
		Calendar daughterBirth = Calendar.getInstance();
		daughterBirth.set(d_year, d_month, d_date);
		long daughterTick = daughterBirth.getTimeInMillis();
		
		System.out.printf("아빠는 딸보다 총 %,d일을 더 살았습니다.\r\n"
				, (daughterTick - fatherTick) / 1000 / 60 / 60 / 24);
	}
}
