package com.test.control;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Ex10_IF_question_08 {

	public static void main(String[] args) throws Exception {
		
		// 요구사항 08
		// 윤년 -> 2월 29일이 있는 해
		// 윤달 -> 음력, 4월이 한번 더 있는 해
		
		// 윤년
		// 4년마다 하루 넣고 (2월 29일)
		// 100년마다 하루 빼고 (2월 28일)
		// 400년마다 하루 넣고 (2월 29일)
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("년도 입력 : ");
		int year = Integer.parseInt(reader.readLine());
		String what = "";
		if (year % 4 != 0) {
			what = "평년";
		} else {
			if (year % 100 != 0) {
				what = "윤년";
			} else {
				if (year % 400 != 0) {
					what = "평년";
				} else {
					what = "윤년";
				}
			}
		}
		System.out.printf("%d년은 '%s'입니다.\r\n", year, what);
	}
}
