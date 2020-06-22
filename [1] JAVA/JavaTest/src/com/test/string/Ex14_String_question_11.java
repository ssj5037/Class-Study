package com.test.string;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Ex14_String_question_11 {

	public static void main(String[] args) throws Exception {
		
		// 요구사항 11
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("금액(원) : ");
		String inputMoney = reader.readLine();
		int money = Integer.parseInt(inputMoney);
		String hangeulMoney = "";
		int moneyLen = inputMoney.length();
		if(moneyLen <= 5) {
			switch (moneyLen) {
			case 5:
				hangeulMoney += hangeulChange(money/10000) + "만";
			case 4:
				hangeulMoney += hangeulChange(money%10000/1000) + "천";
			case 3:
				hangeulMoney += hangeulChange(money%1000/100) + "백";
			case 2:
				hangeulMoney += hangeulChange(money%100/10) + "십";
			case 1:
				hangeulMoney += hangeulChange(money%10) + "원";
				break;
			}
		} else {
			System.out.println("최대 5자리 금액만 입력 가능.");
		}
		System.out.printf("일금 %s",hangeulMoney);
	}

	private static String hangeulChange(int i) {
		// TODO Auto-generated method stub
		String num = "";
		switch(i) {
		case 1:
			num = "일";
			break;
		case 2:
			num = "이";
			break;
		case 3:
			num = "삼";
			break;
		case 4:
			num = "사";
			break;
		case 5:
			num = "오";
			break;
		case 6:
			num = "육";
			break;
		case 7:
			num = "칠";
			break;
		case 8:
			num = "팔";
			break;
		case 9:
			num = "구";
			break;
		}
		return num;
	}
	
}
