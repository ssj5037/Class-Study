package com.test.io;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Ex05_Input_use {

	public static void main(String[] args) throws Exception {

		// BufferedReader
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		// 요구사항] 태어난 년도를 입력받아 나이를 출력하시오.
		// 입력] 태어난 년도(ex. 1995) : 1995
		// 출력] 당신은 26세 입니다.
		//
		// System.out.print("태어난 년도 : ");
		// String year = reader.readLine();

		// 2020 - year
		// 2020 - "1995"

		// 문자열 -> int
		// 형변환이 아니다.
		// int year2 = Integer.parseInt(year);
		// System.out.printf("당신은 %d세입니다.\n", 2020 - year2);

		// "10" -> 10
		// "문자열" -> int : Integer.parseInt("문자열")
		// "문자열" -> byte : Byte.parseByte("문자열")
		// "문자열" -> short : Short.parseShort("문자열")
		// "문자열" -> long : Long.parseLong("문자열")
		// "문자열" -> float : Float.parseFloat("문자열")
		// "문자열" -> double : Double.parseDouble("문자열")
		// "true" -> boolean : Boolean.parseBoolean("문자열")

		// 요구사항] 숫자 2개 입력받아서 + 연산과정과 결과를 출력하시오.
		// 입력] 첫번째 숫자 : 5
		// 두번째 숫자 : 3
		// 출력] 5 + 3 = 8

//		System.out.print("첫번째 숫자 : ");
//		String num1 = reader.readLine(); // 5 -> "5"
//		// public static void main(String[] args) throws Exception
//		// -> throws Exception을 추가해주면 readLine()에 오류가 사라짐
//
//		System.out.print("두번째 숫자 : ");
//		String num2 = reader.readLine();
//
//		int Inum1 = Integer.parseInt(num1);
//		int Inum2 = Integer.parseInt(num2);
//
//		System.out.printf("%,d + %,d = %,d", Inum1, Inum2, Inum1 + Inum2);
		
		
		
		// 클래스.메소드
		// Byte.parseByte("")
		// Integer.parseInt("")
		
		// 유틸 클래스, 래퍼(Wrapper) 클래스
		// byte -> Byte
		// short -> Short
		
		// byte : -128 ~ 127
		// long : -? ~ ?
		System.out.println(Long.MIN_VALUE);
		System.out.println(Long.MAX_VALUE);
		System.out.println(Integer.MAX_VALUE);
		System.out.println(Byte.MAX_VALUE);
		
		System.out.println(Long.SIZE);
		System.out.println(Float.SIZE);
		
		
		
		
		
		
		

	}
}
