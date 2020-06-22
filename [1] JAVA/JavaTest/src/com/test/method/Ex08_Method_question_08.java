package com.test.method;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Ex08_Method_question_08 {

	public static void main(String[] args) throws Exception {
		
		// 요구사항 08
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("시간대(평상:1, 출근:2, 퇴근:3) : ");
		String input1 = reader.readLine();
		int condition = Integer.parseInt(input1);

		System.out.print("역의 개수 : ");
		String input2 = reader.readLine();
		int station = Integer.parseInt(input2);

		System.out.print("환승역의 개수 : ");
		String input3 = reader.readLine();
		int transfer = Integer.parseInt(input3);
		
		System.out.printf("총 소요 시간은 %d분입니다.\r\n", getTime(condition, station, transfer));
	}
	
	public static int getTime(int time, int station, int transfer) {
		int transTime = time == 1 ? 3 : time == 2 ? 4 : time == 3? 5 : 0;
		int totalTime = (station * 2) + (transTime * transfer);
		return totalTime;
	}
}
