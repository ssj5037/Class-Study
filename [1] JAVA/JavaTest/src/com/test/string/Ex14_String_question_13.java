package com.test.string;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Ex14_String_question_13 {
	
	public static void main(String[] args) throws Exception {
		
		// 요구사항 13
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			System.out.print("연산식 입력 : ");
			String operation = reader.readLine();
	//		String operation = "10 + 2";
			operation = operation.replace(" ", "");
	//		System.out.println(operation);
			
			int index = -1;
			int num1=0, num2=0, result=0;
			String op = "";
			
			if (operation.contains("+")) {
				op = "+";
				index = operation.indexOf(op);
				if(index != 0 && index != operation.length()-1) {
					num1 = Integer.parseInt(operation.substring(0, index));
					num2 = Integer.parseInt(operation.substring(index+1));
					result = num1 + num2;
				} else {
					System.out.println("피연산자가 부족합니다.");
					continue;
				} 
			} else if (operation.contains("-")) {
				op = "-";
				index = operation.indexOf(op);
				if(index != 0 && index != operation.length()-1) {
					num1 = Integer.parseInt(operation.substring(0, index));
					num2 = Integer.parseInt(operation.substring(index+1));
					result = num1 - num2;
				} else {
					System.out.println("피연산자가 부족합니다.");
					continue;
				} 
			} else if (operation.contains("*")) {
				op = "*";
				index = operation.indexOf(op);
				if(index != 0 && index != operation.length()-1) {
					num1 = Integer.parseInt(operation.substring(0, index));
					num2 = Integer.parseInt(operation.substring(index+1));
					result = num1 * num2;
				} else {
					System.out.println("피연산자가 부족합니다.");
					continue;
				} 
			} else if (operation.contains("/")) {
				op = "/";
				index = operation.indexOf(op);
				if(index != 0 && index != operation.length()-1) {
					num1 = Integer.parseInt(operation.substring(0, index));
					num2 = Integer.parseInt(operation.substring(index+1));
					result = num1 / num2;
				} else {
					System.out.println("피연산자가 부족합니다.");
					continue;
				} 
			} else if (operation.contains("%")) {
				op = "%";
				index = operation.indexOf(op);
				if(index != 0 && index != operation.length()-1) {
					num1 = Integer.parseInt(operation.substring(0, index));
					num2 = Integer.parseInt(operation.substring(index+1));
					result = num1 % num2;
				} else {
					System.out.println("피연산자가 부족합니다.");
					continue;
				} 
			} else {
				System.out.println("연산자가 올바르지 않습니다.");
				continue;
			}
			System.out.printf("%d %s %d = %d\r\n", num1, op, num2, result);
	
		}
	}
}
