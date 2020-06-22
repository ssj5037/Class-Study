package com.test.method;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Ex08_Method_question_02 {

	public static void main(String[] args) throws Exception {
		
		// 요구사항 02
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("숫자 입력 : ");
		String input = reader.readLine();
		int num = Integer.parseInt(input);
		digit(num);
		
	}
	
	public static void digit(int num) {
		String sNum = String.valueOf(num);
		String result =  num<10? "000"+sNum : num<100? "00"+sNum : num<1000? "0"+sNum : sNum;
		System.out.printf("%d -> %s\r\n", num, result);
	}
}
