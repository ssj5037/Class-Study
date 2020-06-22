package com.test.control;

public class Ex12_For_use_03 {

	public static void main(String[] args) {
		
		//m1();
		//m2();
		m3();
	}

	private static void m3() {
		// TODO Auto-generated method stub
		
		// 별찍기
		for (int i=0; i<5; i++) {
			for (int j=0; j<5; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		System.out.println();

		for (int i=0; i<5; i++) {	//행
			for (int j=0; j<=i; j++) {	//열
				System.out.print("*");
			}
			System.out.println();
		}
		System.out.println();
		
		for (int i=0; i<5; i++) {
			for (int j=i; j<5; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		System.out.println();
	}

	private static void m2() {
		// TODO Auto-generated method stub
		
		// *****
		for (int i=0; i<10; i++) {
			for(int j=0; j<10; j++) {
				if (j == 5) {
					continue;	// 자신이 포함된 제어문 탈출. j? i?
				}
				System.out.printf("i: %d, j: %d\n", i, j);
			}
		}
	}

	private static void m1() {
		// TODO Auto-generated method stub
		
		// 구구단
		// 2단 ~ 9단
		
		for (int i=2; i<10; i++) {
			System.out.printf("[ %d 단 ]\r\n", i);
			for (int j=1; j<10; j++) {
				System.out.printf("%d x %d = %d\r\n",i, j, i*j);
			}
			System.out.println();
		}
	}
}
