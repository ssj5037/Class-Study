package com.test.control;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Ex10_IF_question_07 {

	public static void main(String[] args) throws Exception{
		
		// 요구사항 07
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("[들어온 시간]");
		System.out.print("시 : ");
		int inHour = Integer.parseInt(reader.readLine());
		System.out.print("분 : ");
		int inMin = Integer.parseInt(reader.readLine());
		
		System.out.println("[나간 시간]");
		System.out.print("시 : ");
		int outHour = Integer.parseInt(reader.readLine());
		System.out.print("분 : ");
		int outMin = Integer.parseInt(reader.readLine());
		
		int totalTime = (outHour - inHour) * 60 + (outMin - inMin);
		int cost = 0;
		
		if (totalTime < 30) {
			cost = 0;
		} else {
			cost = ((totalTime - 31) / 10 + 1 ) * 2000;
		}
		
		System.out.printf("주차 요금은 %,d원 입니다.\r\n", cost);
	}
}
