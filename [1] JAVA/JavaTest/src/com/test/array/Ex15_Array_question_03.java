package com.test.array;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Ex15_Array_question_03 {
	
	public static void main(String[] args) throws Exception {
		
		// 요구사항 03
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("학생 수 : ");
		int student = Integer.parseInt(reader.readLine());
		
		String[] name = new String[student];
		for (int i=0; i<student; i++) {
			System.out.print("학생명 : ");
			name[i] = reader.readLine();
		}
		
		System.out.printf("입력한 학생은 총 %d명입니다.\r\n", student);
		for (int i=student-1, j=1; i>=0; i--, j++) {
			System.out.printf("%d. %s\r\n", j, name[i]);
		}
	}

}
