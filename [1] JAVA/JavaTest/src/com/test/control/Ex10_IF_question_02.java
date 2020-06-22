package com.test.control;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Ex10_IF_question_02 {
	
	public static void main(String[] args) throws Exception {
		
		// 요구사항 02
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("점수 : ");
		int score = Integer.parseInt(reader.readLine());
		char scoreResult = 'F';
		
		if (score >= 0 && score <= 100) {
			if (score >= 90 && score <= 100) {
				scoreResult = 'A';
			} else if (score >= 80 && score < 90) {
				scoreResult = 'B';
			} else if (score >= 70 && score < 80) {
				scoreResult = 'C';
			} else if (score >= 60 && score < 70) {
				scoreResult = 'D';
			} else if (score >= 0 && score < 60) {
				scoreResult = 'F';
			}
			System.out.printf("입력한 %d점은 성적 %c입니다.", score, scoreResult);
		} else {
			System.out.println("유효한 점수가 아닙니다.");
		}
	}

}
