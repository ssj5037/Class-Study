package com.test.error;

public class Ex06_Casting_use {
	
	public static void main(String[] args) {
		
		byte a = 10;
		byte b = 20;
		byte c = 0;
		
//		c = a + b; 수정 전
		c = (byte)(a + b);
		// + 연산자는 두  피연산자의 자료형을 int로 변환한 다음 연산을 하기 때문에,
		// 큰 자료형 int에서 작은 자료형 byte로 바꾸려면 형변환을 명시해주어야 한다.
		
		System.out.printf("%d + %d = %d\n", a, b, c);
		
		
		int n1 = 1234567;
		int n2 = 654321;
		
//		System.out.printf("%,d * %,d = %,d\n", n1, n2, n1 * n2); 수정 전
		System.out.printf("%,d * %,d = %,d\n", n1, n2, (long)n1 * (long)n2);
		// int와 int를 곱하면 결과는 int로 나오기 때문에 이미 오버플로우된 값을 long으로 형변환 해 봤자 값은 변하지 않는다.
		// 따라서 계산하기 전에 미리 피연산자들의 타입을 long으로 형변환 해주어야 한다.
		
		
	}

}












