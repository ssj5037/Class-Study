package com.test.inheritance;

import java.util.Random;

public class Ex25_Inheritance_use_01 {

	public static void main(String[] args) {
		
		// 난수 생성기
		// 상황] 난수 발생 잦음 > Random 클래스 의존도 높음
		// 1. nextInt() : -21억 ~ 21억
		// 2. 1 ~ 10 사이 : 추가 업무 필요
		// 3. 색상 난수 : 추가 업무 필요
		// 4. nextBoolean() : true, false
		// 5. nextDouble() : 나중에 추가로 필요
		// 6. nextLong() : 나중에 추가로 필요
		
		//m1();
		//m2();
		//m3();
		m4();
		
	}

	private static void m4() {
		// TODO Auto-generated method stub
		
		// 상속
		MyRandom rnd = new MyRandom();
		
		// 1. 
		System.out.println(rnd.nextInt());
		
		// 2.
		System.out.println(rnd.nextSmallInt());
		
		// 3.
		System.out.println(rnd.nextColor());
		
		// 4.
		System.out.println(rnd.nextBoolean());
		
		// 5.
		System.out.println(rnd.nextDouble());
		
		// 6.
		System.out.println(rnd.nextLong());
		
	}

	private static void m3() {
		// TODO Auto-generated method stub
		
		// 코드 재사용 도구 -> 제어문(반복문), 메소드, 클래스, 상속 (뒤로 갈 수록 재사용이 큰 도구들)
		//Random rnd = new Random();
		MyUtil util = new MyUtil();
		
		// 1.
		//System.out.println(rnd.nextInt());
		System.out.println(util.nextInt());

		// 2. 
		System.out.println(util.nextSmallInt());
		
		// 3. 
		System.out.println(util.nextColor());
		
		// 4.
		//System.out.println(rnd.nextBoolean());		
		System.out.println(util.nextBoolean());		
		
	}

	private static void m2() {
		// TODO Auto-generated method stub
		
		// 직접 구현 (Random)
		Random rnd = new Random();
		
		// 1.
		System.out.println(rnd.nextInt());
		System.out.println(rnd.nextInt());
		System.out.println(rnd.nextInt());
		
		// 2.
		System.out.println(rnd.nextInt(10)+1);
		System.out.println(rnd.nextInt(10)+1);
		System.out.println(rnd.nextInt(10)+1);
		
		// 3.
		String[] color = {"red", "yellow", "blue", "white", "black"};
		System.out.println(color[rnd.nextInt(color.length)]);
		System.out.println(color[rnd.nextInt(color.length)]);
		System.out.println(color[rnd.nextInt(color.length)]);
		
		// 4.
		System.out.println(rnd.nextBoolean());
		System.out.println(rnd.nextBoolean());
		System.out.println(rnd.nextBoolean());
		
	}

	private static void m1() {
		// TODO Auto-generated method stub
		
		// 난수 생성
		// 1. Math.random()
		// 2. Random 클래스
		
		Random rnd = new Random();	//util package 안에 들어있음
		System.out.println(rnd.nextInt());	// int 난수 반환 -21억 ~ 21억
		System.out.println(rnd.nextInt(10));	// 0 ~ bound전까지
		System.out.println(rnd.nextBoolean());
		System.out.println(rnd.nextDouble());
		System.out.println(rnd.nextLong());
		
	}
}
