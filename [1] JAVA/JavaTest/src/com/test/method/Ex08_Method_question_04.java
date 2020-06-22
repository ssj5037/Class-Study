package com.test.method;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Ex08_Method_question_04 {

	public static void main(String[] args) throws Exception {
		
		// 요구사항 04
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("이름 : ");
		String name = reader.readLine();
		
		name = getName(name);
		System.out.printf("고객 : %s\r\n", name);
	}
	
	public static String getName(String name) {
		return name+"님";
	}
}
