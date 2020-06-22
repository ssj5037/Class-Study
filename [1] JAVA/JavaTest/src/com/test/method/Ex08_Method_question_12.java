package com.test.method;

public class Ex08_Method_question_12 {

	public static void main(String[] args) {
		
		// 요구사항 12
		
		int count = positive(10);
		System.out.printf("양수: %d개\r\n", count);
		count = positive(10, 20);
		System.out.printf("양수: %d개\r\n", count);
		count = positive(10, 20, -30);
		System.out.printf("양수: %d개\r\n", count);
		count = positive(10, 20, -30, 40);
		System.out.printf("양수: %d개\r\n", count);
		count = positive(10, 20, -30, 40, 50);
		System.out.printf("양수: %d개\r\n", count);
	}
	
	public static int positive(int a) {
		int count = 0;
		count = a % 2 == 1 ? count : ++count;
		return count;
	}
	
	public static int positive(int a, int b) {
		int count = 0;
		count = a % 2 == 1 ? count : ++count;
		count = b % 2 == 1 ? count : ++count;
		return count;
	}
	
	public static int positive(int a, int b, int c) {
		int count = 0;
		count = a % 2 == 1 ? count : ++count;
		count = b % 2 == 1 ? count : ++count;
		count = c % 2 == 1 ? count : ++count;
		return count;
	}
	
	public static int positive(int a, int b, int c, int d) {
		int count = 0;
		count = a % 2 == 1 ? count : ++count;
		count = b % 2 == 1 ? count : ++count;
		count = c % 2 == 1 ? count : ++count;
		count = d % 2 == 1 ? count : ++count;
		return count;
	}
	
	public static int positive(int a, int b, int c, int d, int e) {
		int count = 0;
		count = a % 2 == 1 ? count : ++count;
		count = b % 2 == 1 ? count : ++count;
		count = c % 2 == 1 ? count : ++count;
		count = d % 2 == 1 ? count : ++count;
		count = e % 2 == 1 ? count : ++count;
		return count;
	}
}
