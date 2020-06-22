package com.test.operator;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Ex07_Operator_question_04 {

	public static void main(String[] args) throws Exception {
		
		// 요구사항 04

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("사용자가 페달을 밟은 횟수 : ");
		String input1 = reader.readLine();
		int pedalCount = Integer.parseInt(input1);
		
		System.out.print("기어비(1~4) : ");
		String input2 = reader.readLine();
		int gear = Integer.parseInt(input2);
		
		double wheelRoundMeter = 3.141592 * 26 * 0.0254;	// 바퀴의 둘레
		// 1inch = 2.54cm = 0.0254m
		// 원의 둘레 = 2 * pi * r(반지름) = pi * 지름
		
		double distance = pedalCount * wheelRoundMeter * gear;	// 총 거리
		
		System.out.printf("사용자가 %d단 기어로 총 %,d회 페달을 밟아 자전거가 총 %,.0fm를 달렸습니다.\r\n", gear, pedalCount, distance);
		
	}
}
