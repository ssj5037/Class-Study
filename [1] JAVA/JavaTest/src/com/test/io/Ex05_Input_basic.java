package com.test.io;

// 특정 도구(클래스)를 이 페이지에서 사용하겠습니다.
//import java.io.BufferedReader;		// 클래스 임포트
//import java.io.InputStreamReader;
import java.io.*;	// *(all)

public class Ex05_Input_basic {

	public static void main(String[] args) throws Exception {
		
		// 콘솔 입력
		// 1. System.in.read() 메소드
		// 2. BufferedReader 클래스
		// 3. Scanner 클래스
		
		// System.in.read() : 사용자로부터 키보드 입력받는다.
		// System.out.print()
		
//		System.out.println("입력 전");
		
		// 문자 코드
		// 'A' -> 65 ~ Z -> 90
		// 'a' -> 97 ~ z -> 122
		// '0' -> 48 ~ '9' -> 57
		// '가' -> 44032 ~ '힣' -> 55203
		
		int input = System.in.read();
		System.out.println(input);
		
		input = System.in.read();
		System.out.println(input);
		
		input = System.in.read();
		System.out.println(input);
		
		input = System.in.read();
		System.out.println(input);
		
		input = System.in.read();
		System.out.println(input);
		
		System.out.println("입력 후");
		
		
		// BufferedReader
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("입력 전");
		
		int input1 = reader.read();		// System.in.read() 역할
		System.out.println((char)input1);	// (char) 형변환을 통해 문자코드가 아닌 입력한 값 그대로 가져올 수 있다.
		
		int input2 = reader.read();
		System.out.println((char)input2);
		
		System.out.println("입력 후");
		
		
		// reader.read() 메소드
		// reader.readLine() 메소드 : 문자열을 반환시켜준다. (실제 사용하는 메소드)
		
		System.out.print("이름을 입력하세요 : ");
		String name = reader.readLine();
		System.out.printf("안녕하세요. %s님\n", name);
		
		

		
	}
}
