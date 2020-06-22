package com.test.control;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Ex12_For_question_12 {

	public static void main(String[] args) throws Exception {
		
		// 요구사항 12
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		String result = "";
		System.out.println("0 ~ 9 사이의 숫자를 입력하시오.");
		
		for(int i=1; i<=10; i++) {
			System.out.print("숫자 : ");
			int num = Integer.parseInt(reader.readLine());
			if (num >= 0 && num < 10) {
				result += hangeul(num);
			} else {
				System.out.println("잘못된 숫자를 입력하였습니다.\r\n프로그램을 종료합니다.");
				break;
			}
			if (i == 10) {
				System.out.printf("결과 : %s", result);
			}
		}
	}

	private static String hangeul(int num) {
		// TODO Auto-generated method stub
		String han = "";
		switch (num) {
			case 0:
				han = "영";
				break;
			case 1:
				han = "일";
				break;
			case 2:
				han = "이";
				break;
			case 3:
				han = "삼";
				break;
			case 4:
				han = "사";
				break;
			case 5:
				han = "오";
				break;
			case 6:
				han = "육";
				break;
			case 7:
				han = "칠";
				break;
			case 8:
				han = "팔";
				break;
			case 9:
				han = "구";
				break;
		}
		
		return han;
	}
}
