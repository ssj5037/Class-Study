package com.test.error;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Ex12_For_use_03 {
	
	public static void main(String[] args) throws Exception {
		
		m1();
		//m2();
		
	}

	private static void m2() throws Exception {

		//별찍기(행 입력)
		//*
		//**
		//***
		//****
		//*****
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("행: ");
		
//		int row = (int)reader.readLine();
		// 메소드를 사용하여 형변환 해야한다.
		int row = Integer.parseInt(reader.readLine());
		
//		for (int i=0; i<=row; i++) {
		for (int i=0; i<row; i++) {
			for (int j=0; j<=i; j++) {
//				System.out.println("*");
				// for문이 한번 끝나기 전엔 줄바꿈을 하지 않아야하므로 print 사용
				System.out.print("*");
			}
			System.out.println();
		}
		
	}

	private static void m1() {
		
		//구구단
		//2단 ~ 9단
				
		for (int j=2; j<10; j++) {
		
//			for (int i=1; i<10; j++) {
			// i는 증가하지 않기 때문에 무한루프에 빠짐.
			for (int i=1; i<10; i++) {
				System.out.printf("%d x %d = %2d\n", j, i, j * i);
			}
			
			System.out.println();
			
		}
		
	}

}









