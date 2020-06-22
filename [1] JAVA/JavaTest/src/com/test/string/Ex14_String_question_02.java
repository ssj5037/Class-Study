package com.test.string;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Ex14_String_question_02 {

	public static void main(String[] args) throws Exception {
		
		// 요구사항 02
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("이메일 : ");
		String email = reader.readLine();
		int index = email.indexOf("@");
		//System.out.println(index);
		
		System.out.printf("아이디 : %s\r\n", email.substring(0, index));
		System.out.printf("도메일 : %s\r\n", email.substring(index+1));
	}
	
}
