package com.test.string;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Ex14_String_question_10 {

	public static void main(String[] args) throws Exception {
		
		// 요구사항 10
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("입력 : ");
		String txt = reader.readLine();
		
		String ban1 = "바보";
		String ban2 = "멍청이";
		int index1 = -ban1.length();
		int index2 = -ban2.length();
		int count = 0;
		
		while (true) {
			index1 = txt.indexOf(ban1, index1 + ban1.length());
			if(index1 > -1) {
				txt = txt.replace("바보", "**");
				count++;
			} else {
				break;
			}
		}
		
		while (true) {
			index2 = txt.indexOf(ban2, index2 + ban2.length());
			if (index2 > -1) {
				txt = txt.replace("멍청이", "***");
				count++;
			} else {
				break;
			}
		}
		
		System.out.println(txt);
		System.out.printf("금지어를 %d회 마스킹했습니다.\r\n", count);
	}
	
}
