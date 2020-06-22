package com.test.control;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Ex12_HW_question_11 {

	public static void main(String[] args) throws Exception {
		
		// 요구사항 11
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		int accountMoney = 100000;
		boolean loop = true;
		for(;loop;) {
			System.out.println("My Bank를 시작합니다.");
			System.out.println();
			System.out.println("===============");
			System.out.println("    My Bank");
			System.out.println("===============");
			System.out.println("1. 계좌 입금");
			System.out.println("2. 계좌 출금");
			System.out.println("3. 잔액 조회");
			System.out.println("4. 종료");
			System.out.println("===============");
			System.out.print("선택(번호) : ");
			
			int num = Integer.parseInt(reader.readLine());
			
			switch (num) {
				case 1:
					System.out.println("===============");
					System.out.println("   계좌 입금");
					System.out.println("===============");
					accountMoney += accountDeposit();
					continueEnter();
					break;
				case 2:
					System.out.println("===============");
					System.out.println("   계좌 입금");
					System.out.println("===============");
					accountMoney -= accountWithdraw(accountMoney);
					continueEnter();
					break;
				case 3:
					System.out.println("===============");
					System.out.println("   잔액 조회");
					System.out.println("===============");
					System.out.printf("현재 잔액 : %,d원\r\n", accountMoney);
					continueEnter();
					break;
				case 4:
					loop = false;
					break;
				default:
					System.out.println("올바른 번호를 입력하시오.");
					continueEnter();
					break;
			}
			
		}
	}


private static void continueEnter() throws Exception {
		// TODO Auto-generated method stub
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		System.out.println("계속 하시려면 엔터를 입력하세요.");
		reader.readLine();
	}


private static int accountWithdraw(int accountMoney) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		int withdraw = 0;
		String password = "1234";
		System.out.print("계좌 비밀번호 : ");
		String inputPass = reader.readLine();
		if (!inputPass.equals(password)) {
			System.out.println("비밀번호가 틀렸습니다.");
		} else {
			System.out.print("출금액 : ");
			withdraw = Integer.parseInt(reader.readLine());
			if(withdraw > accountMoney) {
				System.out.println("잔액이 부족합니다.");
				withdraw = 0;
			} else {
				System.out.printf("%d원이 출금되었습니다.\r\n", withdraw);
			}
		}
		
		return withdraw;
	}

private static int accountDeposit() throws Exception {
		// TODO Auto-generated method stub
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		int deposit = 0;
		String password = "1234";
		System.out.print("계좌 비밀번호 : ");
		String inputPass = reader.readLine();
		if (!inputPass.equals(password)) {
			System.out.println("비밀번호가 틀렸습니다.");
		} else {
			System.out.print("입금액 : ");
			deposit = Integer.parseInt(reader.readLine());
			System.out.printf("%d원이 입금되었습니다.\r\n", deposit);
		}
		return deposit;
	}
}