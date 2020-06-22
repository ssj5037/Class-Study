package com.test.control;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Ex12_For_question_13 {

	public static void main(String[] args) throws Exception {
	
		// 요구사항 13
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("컴퓨터가 1~10 사이의 숫자를 1개 생각했습니다.\r\n");
		double num = Math.random();
		int comNum = (int)(num * 10) + 1;
		
		boolean loop = true;
		for (int i=1; loop; i++) {
			System.out.print("숫자 : ");
			int input = Integer.parseInt(reader.readLine());
			if(input == comNum) {
				System.out.println("맞췄습니다.\r\n");
				System.out.printf("컴퓨터가 생각한 숫자는 %d입니다.\r\n", comNum);
				System.out.printf("정답을 맞추는데 시도한 횟수는 %d회입니다.\r\n", i);
				loop = false;
			} else {
				System.out.println("틀렸습니다.\r\n");
			}
		}
		System.out.println();
		System.out.println("프로그램을 종료합니다.");
	}
	
}
