package com.test.one;

public class Student {
	
	// 접근 지정자
	// - private, public, protected, default(=friendly)
	
	// 1. private
	//		- 모두 비공개
	// 2. public
	// 		- 모두 공개
	// 3. protected
	//		- 같은패키지 : public
	//		- 다른패키지 : private
	//		- 다른패키지 + 자식클래스 : public
	// 4. default
	//		- 같은패키지 : public
	//		- 다른패키지 : private
	
	
	private int a = 100;
	public int b = 200;
	protected int c = 300;
	int d = 400;			//아무것도 안쓰는게 default
	// protected, default: 어떤 경우엔 공개, 어떤 경우엔 비공개
	// 					private, public의 중간적 성질을 가짐.
	
	public void test() {
		System.out.println("같은 클래스 내에서 접근");
		System.out.println("private a   : " + this.a);
		System.out.println("public b    : " + this.b);
		System.out.println("protected c : " + this.c);
		System.out.println("default d   : " + this.d);
	}

}
