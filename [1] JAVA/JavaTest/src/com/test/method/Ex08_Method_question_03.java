package com.test.method;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Ex08_Method_question_03 {

	public static void main(String[] args) throws Exception{
		
		// 요구사항 03
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("첫번째 숫자 : ");
		String input1 = reader.readLine();
		int n1 = Integer.parseInt(input1);
		System.out.print("두번째 숫자 : ");
		String input2 = reader.readLine();
		int n2 = Integer.parseInt(input2);
		
		add(n1, n2);
		add(n1, n1);
		
		subtract(n1, n2);
		
		multiply(n1, n2);
		multiply(n1, n1);
		
		divide(n1, n2);
		
		mod(n1, n2);
	}
	
	public static void add(int num1, int num2) {
		System.out.printf("%d + %d = %d\r\n", num1, num2, num1 + num2);
	}
	
	public static void subtract(int num1, int num2) {
		System.out.printf("%d - %d = %d\r\n", num1, num2, num1 - num2);
	}
	
	public static void multiply(int num1, int num2) {
		System.out.printf("%d * %d = %d\r\n", num1, num2, num1 * num2);
	}
	
	public static void divide(int num1, int num2) {
		System.out.printf("%d / %d = %.1f\r\n", num1, num2, (double)num1 / num2);
	}
	
	public static void mod(int num1, int num2) {
		System.out.printf("%d %% %d = %d\r\n", num1, num2, num1 % num2);
	}
}
