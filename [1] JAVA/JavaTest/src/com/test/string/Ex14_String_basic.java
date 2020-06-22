package com.test.string;

public class Ex14_String_basic {

	public static void main(String[] args) {
		
		// 문자열, String
		// - 숫자, 문자, 논리, 문자열, 날짜시간
		
		// 문자열 조작 기능
		// -> 메소드 제공
		
		//m1();
		//m2();
		//m3();
		//m4();
		//m5();
		//m6();
		//m7();
		//m8();
		//m9();
		m10();
	}

	private static void m10() {
		// TODO Auto-generated method stub
		
		// "10" -> 10
		String str = "10";
		System.out.println(Integer.parseInt(str));
		
		// 10 -> "10"
		int num = 10;
		System.out.println(String.valueOf(num)); // 정석
		System.out.println(num + ""); // 10 + "" -> "10"
		System.out.println("" + num); // "" + 10 -> "10"
		System.out.println(true + "");
		
		
		
	}

	private static void m9() {
		// TODO Auto-generated method stub
		
		// 문자열 치환
		// - String replace(char old, char new)
		// - String replace(String old, String new)
		
		String txt = "안녕하세요. 홍길동입니다.";
		
		System.out.println(txt.replace("홍길동", "아무개"));
		System.out.println(txt);
		System.out.println(txt.replace("하하하", "아무개"));
		
		// 모든 문자열 메소드는 원본을 건드리지 않는다.
		
		txt = "     하나     둘     셋     ";
		System.out.println(txt.replace(" ", ""));	// 전체 공백 삭제

	}

	private static void m8() {
		// TODO Auto-generated method stub
		
		// 문자열 검색
		// - indexOf()
		// - lastIndexOf()
		// - boolean contains(String)

		String txt = "안녕하세요. 홍길동입니다.";
		
		System.out.println(txt.contains("홍길동"));
		System.out.println(txt.indexOf("홍길동") > -1);
		System.out.println(txt.contains("아무개"));
	}

	private static void m7() {
		// TODO Auto-generated method stub
		
		// 문자열 추출
		// - char charAt(int index) : 문자 추출
		// - String substring(int start, int end) : 문자열 추출
		//		- start : inclusive
		//		- end : exclusive
		
		String txt = "안녕하세요. 홍길동입니다.";
		
		System.out.println(txt.substring(3,8));
		System.out.println(txt.substring(3,3));	//지정된 범위가 없음
		System.out.println(txt.substring(3,4));

		// 끝위치 지정을 안했기 때문에 끝까지 출력
		System.out.println(txt.substring(3));
		System.out.println(txt.substring(3, txt.length()));	//위와 동일
		
	}

	private static void m6() {
		// TODO Auto-generated method stub
		
		// (패턴)검색
		// - boolean startsWith(String word)
		// - boolean endsWith(String word)
		
		String name = "홍길동";
		
		//'홍'씨?
		System.out.println(name.charAt(0) == '홍');
		System.out.println(name.indexOf('홍') == 0);
		System.out.println(name.startsWith("홍"));
		// 가독성을 높이기 위해 만든 메소드
		
		// '동'으로 끝나느냐?
		System.out.println(name.charAt(2) == '동'); //좋은 코드 아님(일반). 마지막 글자가 3번째가 아닐수도 있음.
		System.out.println(name.charAt(name.length()-1) == '동'); //좋은
		System.out.println(name.indexOf("동") == 2); //일반
		System.out.println(name.indexOf("동") == name.length()-1); //좋은
		System.out.println(name.endsWith("동"));

	}

	private static void m5() {
		// TODO Auto-generated method stub
		
		// 대소문자 변환
		// - String toUpperCase() : 전부 대문자
		// - String toLowerCase() : 전부 소문자
		
		String txt = "Hello Hong";
		System.out.println(txt.toUpperCase());
		System.out.println(txt.toLowerCase());
		
	}

	private static void m4() {
		// TODO Auto-generated method stub
		
		// 문자열 검색
		// - 문자열 내에서 원하는 문자(문자열) 검색 -> 발견한 위치 반환
		// - int indexOf(char c)
		// - int indexOf(String s)
		// - int indexOf(char c, int index)
		// - int indexOf(String s, int index)
		
		String txt = "안녕하세요. 홍길동입니다. 반갑습니다. 홍길동입니다.";
		int index = txt.indexOf('홍');
		System.out.println(index);
		index = txt.indexOf("홍");
		System.out.println(index);
		index = txt.indexOf("홍길동");
		System.out.println(index);
		index = txt.indexOf("아무개");	// -1
		System.out.println(index);
		// 있다면 0~13 반환, 없다면 그 외의 숫자를 반환
		
		// 문장 내에 '아무개'가 있느냐?
		if (txt.indexOf("아무개") > -1) {
			System.out.println("발견O");
		} else {
			System.out.println("없음;;;");
		}
		
		
		index = txt.indexOf("홍길동", 0);
		System.out.println(index);
		
		index = txt.indexOf("홍길동", 10);
		System.out.println(index);
		
	}

	private static void m3() {
		// TODO Auto-generated method stub
		
		// 문자열 공백 제거
		// - String trim()
		String txt = "     하나     둘     셋     ";
		System.out.printf("[%s]\n", txt);
		System.out.printf("[%s]\n", txt.trim());
		
	}

	private static void m2() {
		// TODO Auto-generated method stub
		
		// 문자열 추출
		// - 특정 위치의 문자를 반환
		// - char charAt(int index)
		// - zero-based Index
		
		String txt = "안녕하세요. 홍길동님.";
		System.out.println(txt.charAt(3));
		System.out.println(txt.charAt(txt.length()-1));	// 최대 index

		// 문자열 길이가 맞지 않음. 최대가 11인데 100 입력해서 오류 생김.
		//System.out.println(txt.charAt(100));
	}

	private static void m1() {
		// TODO Auto-generated method stub
		
		// 문자열 길이
		// - 문자열을 구성하는 문자의 갯수
		// - int length()
		
		String txt = "Hello";
		System.out.println(txt.length());
		System.out.println("Bye".length());
		System.out.println("안녕하세요.".length());
		
		
	}
}
