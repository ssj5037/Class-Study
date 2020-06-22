package com.test.method;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Ex08_Method_question_09 {

	public static void main(String[] args) throws Exception {
		
		// 요구사항 09
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		System.out.print("맑은 날 : ");
		String input1 = reader.readLine();
		int sunny = Integer.parseInt(input1);
		
		System.out.print("흐린 날 : ");
		String input2 = reader.readLine();
		int cloudy = Integer.parseInt(input2);
		
		System.out.printf("사과가 총 %d개 열렸습니다.\r\n", getApple(sunny, cloudy));
		
	}
	
	public static int getApple(int sunny, int cloudy) {
		int tree = (sunny * 5) + (cloudy * 2);
		int apple = tree >= 100 ? (tree-100) / 10 + 1 : 0; 
		return apple;
	}
}
