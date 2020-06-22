package com.test.control;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Ex10_IF_question_10 {

	public static void main(String[] args) throws Exception {
		
		// 요구사항 10
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("근무 년수 : ");
		int work = Integer.parseInt(reader.readLine());
		int next = 0, prev = 0;
		
		if (work >= 1 && work < 80) {
			if (work < 5) {
				System.out.printf("%d년차 초급 개발자 입니다.\r\n", work);
				System.out.printf("앞으로 %d년 더 근무를 하면 중급 개발자가 됩니다.\r\n", 5 - work);
			} else if (work >= 5 && work < 10) {
				System.out.printf("%d년차 중급 개발자 입니다.\r\n", work);
				System.out.printf("당신은 %d년전까지 초급 개발자였습니다.\r\n", work - 4);
				System.out.printf("앞으로 %d년 더 근무를 하면 중급 개발자가 됩니다.\r\n", 10 - work);
			} else if (work >= 10) {
				System.out.printf("%d년차 고급 개발자 입니다.\r\n", work);
				System.out.printf("당신은 %d년전까지 중급 개발자였습니다.\r\n", work - 9);
			}
		} else {
			System.out.println("잘못된 값을 입력하였습니다.");
		}
		
	}
}
