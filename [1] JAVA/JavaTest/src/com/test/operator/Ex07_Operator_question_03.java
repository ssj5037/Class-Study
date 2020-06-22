package com.test.operator;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Ex07_Operator_question_03 {

	public static void main(String[] args) throws Exception {
		
		// 요구사항 03

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("너비(cm) : ");
		String input1 = reader.readLine();
		int width = Integer.parseInt(input1);
		
		System.out.print("높이(cm) : ");
		String input2 = reader.readLine();
		int height = Integer.parseInt(input2);
		
		int area = width * height;			// 넓이
		int round = (width + height) * 2;	// 둘레
		
		System.out.printf("사각형의 넓이는 %d㎠입니다.\r\n"
				+ "사각형의 둘레는 %dcm입니다.\r\n", area, round);
		
	}
}
