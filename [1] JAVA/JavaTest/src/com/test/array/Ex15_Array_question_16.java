package com.test.array;

public class Ex15_Array_question_16 {

	public static void main(String[] args) {
		
		// 요구사항 16
		
		int kor = 8;
		int eng = 5;
		int math = 7;
		
		String[][] score = new String[10][3];
		
		//입력
		for (int i=0; i<score[0].length; i++) {
			for (int j=score.length-1; j>=0; j--) {
				if (i == 0 && j+kor > 9) {
					score[j][i] = "■";
				} else if (i == 1 && j+eng > 9) {
					score[j][i] = "■";
				} else if (i == 2 && j+math > 9) {
					score[j][i] = "■";
				} else {
					score[j][i] = "";
				}
			}
		}
		
		
		// 출력
		for (int i=0; i<score.length; i++) {
			for (int j=0; j<score[0].length; j++) {
				System.out.printf("%2s\t", score[i][j]);
			}
			System.out.println();
		}
		System.out.println("--------------------");
		System.out.println("국어\t영어\t수학");
		
	}
}
