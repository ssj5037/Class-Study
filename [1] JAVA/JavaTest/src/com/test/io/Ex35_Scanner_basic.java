package com.test.io;

import java.util.Arrays;
import java.util.Scanner;

public class Ex35_Scanner_basic {
	
	public static void main(String[] args) {
		
		// 콘솔 입력
		// 1. System.in.read()
		// 2. BufferedReader
		// 3. Scanner
		
		Scanner scan = new Scanner(System.in);
		
		// 사용자 입력한 데이터를 반환
		// - 실체 : 입력 버퍼의 읽어올 수 있는 다음 데이터 반환
		// scan.nextXXX();
		
		System.out.print("입력: ");
		
		
		// 입력받은 \r\n을 자동으로 버림
//		String input = scan.nextLine(); // = reader.readLine()
//		System.out.println(input);
		
		
//		// 숫자 + 10
//		int num = scan.nextInt();
//		System.out.println(num+10);
//		
//		scan.skip("\r\n");	
//		// scan.nextLine()이 아닌 것들은 엔터를 버리지 않아서 skip을 꼭 넣어줘야함.
//		
//		String input = scan.nextLine();
//		System.out.println(input);
		
		
		// nextLine() : 라인 입력
		// next() : 토큰(Token - 공백으로 구분되는 요소)입력
//		String input = scan.next();
//		System.out.println(input);
		// next()로 모두 받고싶으면 루프를 돌린다.
		
//		String input = "";
//		
//		while ((input = scan.nextLine()) != "") {
//			System.out.println(input);
//		}
		
		String input = scan.nextLine();
		//문자열 메소드
		// String[] split(String splitter)
		String[] result = input.split(",");
		System.out.println(Arrays.toString(result));
		
		
		System.out.println("종료");
	}

}
