package com.test.collection;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Ex39_ArrayList_test {

	private static Output output;
	private static Scanner scan;
	private static ArrayList<Student> list;
	
	static {	//정적 생성자
		output = new Output();
		scan = new Scanner(System.in);
		list = new ArrayList<Student>();
	}
	
	public static void main(String[] args) {
		
		// 학생 정보 관리 프로그램
		
		// 학생 정보
		// - 이름
		// - 나이
		// - 주소
		// - 연락처
		// - 번호 (1 ~ 순차적 할당)
		
		// 기능
		// - 학생 추가
		// - 학생 목록
		// - 학생 삭제
		// - 학생 검색
		// - 학생 수정(X)
		
		// 생각?
		// 1. 학생 1명 정보 > 관리 > 클래스 선언 > Student
		// 2. 학생 여러명 관리 > 집합 자료형 > 가변 > ArrayList<Student>
		
		// 클래스 파일 추가
		// 1. Student.java : 학생 정보
		// 2. Output.java : 출력 코드 담당 클래스(업무 분산)
		
		// 프로그램 흐름
		// -> (메뉴 출력 -> 항목 선택 -> 기능 실행) x 무한 반복


		//Output output = new Output();
		//Scanner scan = new Scanner(System.in);
		
		dummy();
		
		output.begin();
		
		boolean loop = true;
		
		while (loop) {
			
			output.menu();
			String sel = scan.nextLine();
			
			if (sel.equals("1")) {
				//학생 추가
				add();
			} else if (sel.equals("2")) {
				//학생 목록
				list();
			} else if (sel.equals("3")) {
				//학생 삭제
				delete();
			} else if (sel.equals("4")) {
				//학생 검색
				search();
			} else {
				//프로그램 종료
				loop = false;
			}
			
		}
		
		output.end();
		
	}

	private static void dummy() {
		
		// 테스트용 데이터 x 10명
		String[] temp1 = { "김", "이", "박", "최", "정" };
		String[] temp2 = { "유", "정", "석", "인", "지", "은", "형", "순", "성", "민" };
		String[] temp3 = { "서울시", "인천시", "부산시", "대전시", "광주시" };
		String[] temp4 = { "강남구", "강서구", "강북구", "강동구" };
		
		Random rnd = new Random();
		
		for (int i=0; i<10; i++) {
			Student s = new Student();
			
			Student.temp++;
			s.setSeq(Student.temp);
			
			String name = temp1[rnd.nextInt(temp1.length)]
					+ temp2[rnd.nextInt(temp2.length)]
					+ temp2[rnd.nextInt(temp2.length)];
			int age = rnd.nextInt(10) + 20;
			String address = temp3[rnd.nextInt(temp3.length)]
					+ " "
					+ temp4[rnd.nextInt(temp4.length)];
			String tel = "010-" + (rnd.nextInt(9000) + 1000)
					+ "-" +  + (rnd.nextInt(9000) + 1000);
			s.setName(name);
			s.setAge(age);
			s.setAddress(address);
			s.setTel(tel);
			
			list.add(s);
			
		}
	}
	
	private static void search() {
		
	}

	private static void delete() {
		
	}

	private static void list() {
		
		output.title(Title.LIST);
		
		listName();
		
		output.pause(scan);
		
	}

	private static void listName() {

		System.out.println("[번호]\t[이름]\t[나이]\t[연락처]\t[주소]");
		
		for (Student s : list) {
			System.out.printf("%5d\t%s\t%5d\t%s\t%s\n"
							, s.getSeq()
							, s.getName()
							, s.getAge()
							, s.getTel()
							, s.getAddress());
		}
		
	}

	private static void add() {
		
		output.title(Title.ADD);
		
		System.out.print("이름: ");
		String name = scan.nextLine();
		
		System.out.print("나이: ");
		int age = scan.nextInt();
		scan.skip("\r\n"); // nextInt() -> scan.skip() (: 꼭 넣어야함***) -> nextLine()
		
		System.out.print("주소: ");
		String address = scan.nextLine();
		
		System.out.println("연락처: ");
		String tel = scan.nextLine();
		
		// 입력받은 정보 > Student 객체 포장
		Student s = new Student();
		
		Student.temp++;		//일련 번호
		
		s.setSeq(Student.temp);
		s.setName(name);
		s.setAge(age);
		s.setAddress(address);
		s.setTel(tel);
		
		//학생 목록 추가(*****)
		list.add(s);
		
		// 잠시 멈춤
		output.pause(scan);
		
	}

}
