package com.test.method;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Ex08_Method_question_05 {

	public static void main(String[] args) throws Exception {
		
		// 요구사항 05
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("첫번째 숫자 : ");
		String input1 = reader.readLine();
		int n1 = Integer.parseInt(input1);
		System.out.print("두번째 숫자 : ");
		String input2 = reader.readLine();
		int n2 = Integer.parseInt(input2);
		
		int result = add(n1, n2);
		System.out.println(result);
		result = add(n1, n1);
		System.out.println(result);
		
		result = subtract(n1, n2);
		System.out.println(result);
		
		result = multiply(n1, n2);
		System.out.println(result);
		result = multiply(n1, n1);
		System.out.println(result);
		
		double dResult = divide(n1, n2);
		System.out.println(dResult);
		
		result = mod(n1, n2);
		System.out.println(result);
	}
	
	public static int add(int num1, int num2) {
		return num1 + num2;
	}
	
	public static int subtract(int num1, int num2) {
		return num1 - num2;
	}
	
	public static int multiply(int num1, int num2) {
		return num1 * num2;
	}
	
	public static double divide(int num1, int num2) {
		return (double)num1 / num2;
	}
	
	public static int mod(int num1, int num2) {
		return num1 % num2;
	}
}
