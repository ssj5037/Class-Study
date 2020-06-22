package com.test.inheritance;

public class Ex29_Interface_basic {
	
	public static void main(String[] args) {

		//인터페이스, Interface
		// - 클래스(자료형)
		// - 추상 클래스 유사
		
	}

}

abstract class AbstractTest {
	
	// 구현 멤버(일반 클래스와 동일)
	public int a;
	public void aaa() {
		System.out.println(a);
	}
	
	// 추상 멤버
	public abstract void bbb();
}

class Test extends AbstractTest {

	@Override
	public void bbb() {
		// TODO Auto-generated method stub
		// Test 클래스 맘대로 구현( + bbb()목적을 벗어나면 안된다.)
	}
	
}


/*

class 일반클래스 {
	구현 멤버;
}

abstract class 추상클래스 {
	구현 멤버;
	추상 멤버;
}

interface 인터페이스 {
	추상 멤버;
}

*/


// 인터페이스 선언(설계)
interface ISpeaker {
	
	// 구현 멤버를 가질 수 없다.
	//public int a;
	//public void aaa() {}
	
	// 추상 멤버만 가질 수 있다.
	// 1. public (무조건 퍼블릭, 생략가능)
	// 2. abstract (생략 가능)
	void on();
	public abstract void off();
}

class Bose100 implements ISpeaker {

	@Override
	public void on() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void off() {
		// TODO Auto-generated method stub
		
	}
	
}


