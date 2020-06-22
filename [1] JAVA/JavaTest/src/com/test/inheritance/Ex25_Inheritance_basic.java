package com.test.inheritance;

public class Ex25_Inheritance_basic {
	
	public static void main(String[] args) {
		
		// 상속, Inheritance
		// - 클래스와 클래스 간에 발생
		// - 부모 클래스 역할 <-> (상속) <-> 자식 클래스 역할
		// - 부모 클래스가 구현한 모든 멤버(변수, 메소드)를 자식 클래스에게 물려주는 기술
		// - 코드 재사용(******)
		
		// 상속 관계에 있는 클래스
		// - 부모 클래스 <-> 자식 클래스
		// - 슈퍼 클래스 <-> 서브 클래스 (클래스 다이어그램 위치에 따른 표현)
		// - 기본 클래스 <-> 확장(파생) 클래스
		
		// 원본 소스를 알 수 없는 컴파일된 class또한 상속받을 수 있다.
		// 이 경우 부모클래스에서 문제가 생긴 경우 디버깅을 할 수 없는 문제가 생긴다.
		// 자바에는 다중 상속을 허용하지 않는다. (N:1)
		// 1:1, 1:N 관계 허용. 부모는 여럿이 될 수 없고 유일해야 한다. 
		
		Child c = new Child();
		
		// 상속된 멤버
		c.a = 10;
		c.b = 20;
		c.aaa();
		
		// 구현된 멤버
		c.c = 30;
		c.d = 40;
		c.bbb();
		
		
		DDD d = new DDD();
		d.a = 10;
		d.b = 20;
		d.c = 30;
		d.d = 40;
		
	}
}

class Parent {
	public int a;
	public int b;
	
	public void aaa() {
		
	}
}

class Child extends Parent {	// 상속 구문 (복사같은 느낌)
	
	// 상속된 멤버
	// a, b, aaa
	
	// 구현한 멤버
	// c, d, bbb
	
	public int c;
	public int d;
	
	public void bbb() {
		
	}
}

class AAA {
	public int a;
}

class BBB extends AAA {
	public int b;
}

class EEE extends AAA {
	public int e;
}

class CCC extends BBB {
	public int c;
}

class DDD extends CCC {
	public int d;
}
