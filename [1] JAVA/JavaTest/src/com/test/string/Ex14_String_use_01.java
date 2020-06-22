package com.test.string;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Ex14_String_use_01 {

	public static void main(String[] args) throws Exception {
		
		//m1();
		//m2();
		//m3();
		//m4();
		//m5();
		//m6();
		//m7();
		//m8();
		m9();
		
	}

	private static void m9() {
		// TODO Auto-generated method stub
		
		String jumin = "950420-2087456";
		
		// 남자? 여자?
		System.out.println(jumin.charAt(7) == '1'? "남자" : "여자");
		System.out.println(jumin.indexOf("1") == 7 ? "남자" : "여자");
		System.out.println(jumin.substring(7,8).equals("1") ? "남자" : "여자");
		
		// 생년?
		System.out.println(jumin.substring(0,2));
		System.out.println(jumin.substring(2,4));
		System.out.println(jumin.substring(4,6));
		
		//일부 내용 추출
		// E:\class\java\JavaTest\src\Hello.java
		String path = "E:\\class\\java\\JavaTest\\src\\Hello.java";
		
		// 1. 파일명 추출 -> Hello.java
		int index = path.lastIndexOf("\\");	// lastIndexOf > 오른쪽부터 차례대로 찾아줌
		//System.out.println(index);
		String name = path.substring(index+1);
		System.out.println(name);
		
		// 2. 확장자 추출 -> .java
		// - Hello.java
		index = name.lastIndexOf(".");
		String ext = name.substring(index);
		System.out.println(ext);
		
		// 3. 확장자 뺀 파일명
		String filenameWithoutExt = name.substring(0, index);
		System.out.println(filenameWithoutExt);
		
	}

	private static void m8() {
		// TODO Auto-generated method stub
		
		// 파일명 -> dog.jpg
		// - 이미지? 동영상? 문서?
		// - 이미지(jpg, gif, png)
		// - 동영상(mp4)
		// - 문서(hwp, doc)
		String filename = "우리집 멍멍이.doc";
		
		if (filename.toLowerCase().indexOf(".jpg") == filename.length()-4
				|| filename.toLowerCase().indexOf(".gif") == filename.length()-4
				|| filename.toLowerCase().indexOf(".png") == filename.length()-4) {
			System.out.println("이미지 파일");
		} else if (filename.toLowerCase().indexOf(".mp4") == filename.length()-4) {
			System.out.println("동영상 파일");
		} else if (filename.toLowerCase().indexOf(".hwp") == filename.length()-4
				|| filename.toLowerCase().indexOf(".doc") == filename.length()-4) {
			System.out.println("문서 파일");
		}
		
		if (filename.toLowerCase().endsWith(".jpg")
				|| filename.toLowerCase().endsWith(".gif")
				|| filename.toLowerCase().endsWith(".png")) {
			System.out.println("이미지 파일");
		} else if (filename.toLowerCase().endsWith(".mp4")) {
			System.out.println("동영상 파일");
		} else if (filename.toLowerCase().endsWith(".hwp")
				|| filename.toLowerCase().endsWith(".doc")) {
			System.out.println("문서 파일");
		}
	}

	private static void m7() {
		// TODO Auto-generated method stub
		
		// java -> 8종류 자바 동일 취급
		System.out.println("JAVA".equals("java"));
		
		String word1 = "Java";
		String word2 = "JAVA";
		String word3 = "java";
		
		System.out.println(word1.equals(word2));
		// 메소드 체인
		System.out.println(word1.toUpperCase().equals(word2.toUpperCase()));
		
		
		String txt = "안녕하세요. 저는 Java를 공부합니다.";
		String word = "java";
		
//		if (txt.indexOf(word) > -1) {
		// 검색률 낮음, 정밀도 높음
		if (txt.toLowerCase().indexOf(word.toLowerCase()) > -1) {
		// 검색률 높음, 정밀도 낮음
			System.out.println("O");
		} else {
			System.out.println("X");
		}
		
	}

	private static void m6() {
		// TODO Auto-generated method stub
		
		// 검색어 모두 찾기!!
		String txt = "안녕하세요. 홍길동입니다. 반갑습니다. 홍길동입니다. 다시 홍길동입니다.";
		String word = "홍길동";
		int index = -1;	// -1은 문자열에 없다는 의미이기 때문에 0보단 -1을 넣는게 안전하다.
		
//		index = txt.indexOf(word);
//		if (index > -1) {
//			System.out.printf("%d번 위치에서 발견\n", index);
//		}
//		
//		index = txt.indexOf(word, index + word.length());
//		if (index > -1) {
//			System.out.printf("%d번 위치에서 발견\n", index);
//		}
		
		index = -word.length(); // -3
		//word = "홍길동" -> length() -> 3
		
		while(true) {
			index = txt.indexOf(word, index + word.length());
			// 처음 발견을 하면 그 위치가 index에 저장되어서,
			// 그 다음에는 발견한 곳+단어길이 의 뒤에서부터 찾기 시작
			// 그러다가 더이상 찾지 못하면 -1을 반환
			// else로 넘어가서 break; while문 종료.
			if (index > -1) {
				System.out.printf("%d번 위치에서 발견\n", index);
			} else {
				break;
			}
		}
	}

	private static void m5() throws Exception {
		// TODO Auto-generated method stub
		
		// 게시판 글쓰기
		// - 관리자 모드 : 금지어 설정
		
		String content = "안녕하세요. 방금 가입했습니다~ 바보야!!!";
		
		// 금지어
		String word = "바보";
		
		if (content.indexOf(word) == -1) {
			System.out.println("글쓰기 진행...");
		} else {
			System.out.println("금지어 사용 불가!!!");
		}
		
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		// for -> 횟수가 고정
		// while -> 횟수가 가변
		while (true) {
			System.out.print("내용 : ");
			content = reader.readLine();
			
			if (content.indexOf(word) == -1) {
				break;
			} else {
				System.out.println("금지어가 발견되었습니다!!");
			}
		}
		System.out.println("글쓰기 진행...");
		
	}

	private static void m4() {
		// TODO Auto-generated method stub
		
		// 사용자 > 주민등록번호 입력 > '-' 반드시 입력
		String jumin = "950420-1012345";
		
		if (jumin.charAt(6) == '-') {
			System.out.println("올바른 주민번호");
			
			if(jumin.charAt(7) == '1') {
				System.out.println("남자");
			} else if(jumin.charAt(7) == '2') {
				System.out.println("여자");
			}
		} else {
			System.out.println("올바르지 않은 주민번호");
		}
		
	}

	private static void m3() {
		// TODO Auto-generated method stub
		
		String txt = "안녕하세요. 홍길동님.";
		
		// 모든 문자 추출(0 ~ 11)
		//for (int i=0; i<=10; i++) {} //
		//for (int i=1; i<10; i++) {}	// 많이 사용
		
		
		for (int i=0; i<txt.length(); i++) {
			char c = txt.charAt(i);
			System.out.println(c);
		}
		
		
		// 아이디 입력 (영어 소문자로만 구성)
		// -> 특정 문자로 구성 -> 문자 코드값 의존 -> String(X), char(O)
		String id = "홍";
		boolean result = false;
		
		for (int i=0; i<id.length(); i++) {
			char c = id.charAt(i);
			//System.out.println(c);
			//System.out.println((int)c);
//			if (c >= 'a' && c <= 'z') {
//				System.out.println("소문자 O");
//			} else {
//				System.out.println("소문자 X");
//			}
			
			// 유효성 검사 -> 되도록 잘못된 부분을 찾는 조건을 만든다.
			//if (c < 'a' || c > 'z') {     ///소문자
			//if ((c < 'a' || c > 'z') && (c < 'A' || c > 'Z')) {    ///소+대문자
			//if ((c < 'a' || c > 'z') 
			//	&& (c < 'A' || c > 'Z')
			//	&& (c < '0' || c > '9')) {    ///소+대문자+숫자
				if (c < '가' || c > '힣') {
			//System.out.println("소문자 X");
			result = true;
			break;
			}
		}
		
		// 유효성검사에 걸렸는지 안걸렸는지 확인하는 방법
		if (!result) {
			System.out.println("사용 가능합니다.");
		} else {
			System.out.println("사용 불가능합니다.");
		}
		System.out.println("완료");
	}

	private static void m2() throws Exception {
		// TODO Auto-generated method stub
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		// 유효성 검사
		// - 문자열 길이
		System.out.print("이름(2~5자이내) : ");
		String name = reader.readLine();
		
		if(name.length() >= 2 && name.length() <= 5) {
			// 통과
			System.out.println("회원 가입 완료!!");
		} else {
			// 거절
			System.out.println("이름은 2~5자 이내로 입력하세요.");
		}
	}

	private static void m1() throws Exception {
		// TODO Auto-generated method stub
		
		String txt = "안녕하세요. 홍길동입니다.";
		System.out.println(txt.length());
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("문장 : ");
		txt = reader.readLine();
		System.out.println(txt.length());
	}
}
