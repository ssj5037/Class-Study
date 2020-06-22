package com.test.inheritance;

import java.util.Calendar;

public class Ex31_Final_basic {

	public static void main(String[] args) {
		
		// final 키워드
		// - 한번 선언하면 수정이 불가능하다
		
		// 1. 변수에 적용
		//	a. 지역 변수(final)
		// 	b. 멤버 변수(public, private, static, final)
		
		// 2. 메소드에 적용
		// 	- 상속받은 메소드를 수정하면 안되는 경우.
		// 	- 프로그램 안정성을 위해서..
		//	a. 상속 구현 시 (Override 금지)
		
		// 3. 클래스에 적용
		// 	- 상속을 더이상 하지 못하게 막는 역할
		//	a. 상속 구현 시
		
		
		
		// final 변수
		// - 상수(constant) : 변하지 않는 수
		// - 값을 한번 할당하면 다시는 변경할 수 없는 변수
		// - 이름이 있는 리터럴(상수)
		// - 되도록 변수명을 모두 대문자로 (필수사항)
		// - 선언과 동시에 초기화하는 것을 권장함
		
		int a = 10;
		final int b = 20;
		
		//final double pi = 3.14;
		//pi = 3.15;
		final double PI = 3.14;
		
		a = 20;
		//b = 30;
		
		System.out.println(a);
		System.out.println(b);
		
		// 1. final 변수?
		final int YEAR = 1;
		System.out.println(Calendar.YEAR);	//1
		// Calendar.YEAR : static 변수
		
//		MyCalendar my = new MyCalendar();
//		System.out.println(my.YEAR);	//1
		
		System.out.println(MyCalendar.YEAR);
	}
	
}

class MyCalendar {
	public final static int YEAR = 1;
	public final static String PATH = "D:\\Java\\Data";
	public final static String ID = "admin";
	
}

final class FinalParent {
	
	public final void test() {
		System.out.println("뭔가 구현...");
	}
}

//class FinalChild extends FinalParent {
//	
////	@Override
////	public void test() {
////		System.out.println("자식 재정의");
////	}
//	
//}


