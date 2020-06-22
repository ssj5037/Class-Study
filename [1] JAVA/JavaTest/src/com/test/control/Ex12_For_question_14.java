package com.test.control;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Ex12_For_question_14 {

	public static void main(String[] args) throws Exception {
		
		// 요구사항 14
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		for (;;) {
			menu();
			System.out.print("금액 투입(원) : ");
			int coin = Integer.parseInt(reader.readLine());
			System.out.println("-----------------------");
			
			System.out.print("음료 선택(번호) : ");
			int select = Integer.parseInt(reader.readLine());
			
			changes(coin, select);
			
			System.out.println("\r\n계속하시려면 엔터를 입력하세요.");
			reader.readLine();
		}
	}

	private static void changes(int coin, int select) {
		// TODO Auto-generated method stub
		
		int price = 0;
		String menu = "";
		
		switch (select) {
			case 1:
				menu = "콜라를";
				price = 700;
				break;
			case 2:
				menu = "사이다를";
				price = 600;
				break;
			case 3:
				menu = "비타500을";
				price = 500;
				break;
		}
		
		if (coin >= price) {
			System.out.printf("+%s 제공합니다.\r\n", menu);
			System.out.printf("잔돈 %d원을 제공합니다.\r\n", coin - price);
		} else if (coin == price) {
			System.out.printf("+%s 제공합니다.\r\n", menu);
			System.out.printf("잔돈이 없습니다.\r\n");
		} else {
			System.out.printf("돈 %d원이 부족합니다.\r\n", price - coin);
		}
	}

	private static void menu() {
		// TODO Auto-generated method stub
		System.out.println("=======================");
		System.out.println("\t자판기");
		System.out.println("=======================");
		System.out.println("1. 콜라\t\t: 700원");
		System.out.println("2. 사이다\t: 600원");
		System.out.println("3. 비타500\t: 500원");
		System.out.println("-----------------------");
	}
	
}
