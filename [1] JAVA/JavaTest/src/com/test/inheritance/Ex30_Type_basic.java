package com.test.inheritance;

public class Ex30_Type_basic {
	
	public static void main(String[] args) {
		
		// 일반클래스 vs 추상클래스 vs 인터페이스
		// 1. 객체 생성 유무 : 일반클래스만 만들 수 있다.
		// 2. 서로간의 상속 관계
		
		// 1.
		M706 m1 = new M706();	// 일반클래스
		//AMouse m2 = new AMouse();	// 추상클래스
		//IMouse m3 = new IMouse();	// 인터페이스
		
		// 2.
		// a. 일반클래스(자식) -> 일반클래스(부모) : O
		// b. 일반클래스(자식) -> 추상클래스(부모) : O (extends)
		// c. 일반클래스(자식) -> 인터페이스(부모) : O (implements)
		// d. 추상클래스(자식) -> 일반클래스(부모) : O -> 사용하지 말것. 논리적으로 말이 안됨
		// e. 인터페이스(자식) -> 일반클래스(부모) : X -> 구현멤버가 상속되기 때문에
		// f. 추상클래스(자식) -> 추상클래스(부모) : O (extends)
		// g. 인터페이스(자식) -> 인터페이스(부모) : O -> 할 일이 점점 늘어남(extends)
		// h. 일반클래스 -> (추상클래스) -> 인터페이스
	
	}

}

class AAAA {
	public int a;
}

abstract class BBBB extends AAAA {

}

//interface CCCC extends AAAA {
//	
//}

abstract class DDDD {
	public int a;
	public abstract void aaaa();
}

abstract class EEEE extends DDDD {
	
	// 선택 -> 부모의 추상 메소드 구현 O vs 구현X\
	public void aaaa() {
		
	}
}

class FFFF extends EEEE {
	
}

interface GGGG {
	void aaa();
	void bbb();
}

interface HHHH extends GGGG {
	// 선택X
	// 되물림 행동 말고는 할 수 있는 것이 없다.
	// 메소드를 늘리는 역할을 한다.
	void ccc();
}

class IIII implements HHHH {

	@Override
	public void aaa() { }

	@Override
	public void bbb() { }

	@Override
	public void ccc() { }
	
}



// 직원
// 1. 정규직
//	a. 간부
//	b. 사원
// 2. 계약직
//	a. 사원

interface 직원 {
	void 출근하다();
	void 퇴근하다();
}

interface 정규직 extends 직원 {
	void 보너스지급();
	void 연차지급();
}

interface 계약직 extends 직원 {
	void 근무조정가능();
}

class 정규직간부 implements 정규직 {

	@Override
	public void 출근하다() { }

	@Override
	public void 퇴근하다() { }

	@Override
	public void 보너스지급() { }

	@Override
	public void 연차지급() { }
	
}

class 계약직사원 implements 계약직 {

	@Override
	public void 출근하다() { }

	@Override
	public void 퇴근하다() { }

	@Override
	public void 근무조정가능() { }
	
}



// 다중 상속
// - 2개의 부모를 가지는 상속 (자바는 불가능)
// - 인터페이스에 한해서 다중 사속이 가능하다. (부모가 인터페이스라면 여러개 부모로부터 상속 가능하다.)

interface AAAAA {
	void aaa();
}

interface BBBBB {
	void bbb();
}

class CCCCC implements AAAAA, BBBBB {

	@Override
	public void bbb() { }

	@Override
	public void aaa() { }
	
}



interface 아빠 {
	void 책임진다();
	void 돈을번다();
}

interface 과장 {
	void 프로젝트를책임진다();
	void 보고서를작성한다();
}

interface 남자 {
	void 군대를간다();
}

class 아무개 implements 과장, 남자 {

	@Override
	public void 군대를간다() { }

	@Override
	public void 프로젝트를책임진다() { }

	@Override
	public void 보고서를작성한다() { }
	
}

class 호호호 implements 과장 {

	@Override
	public void 프로젝트를책임진다() { }

	@Override
	public void 보고서를작성한다() { }
	
}

class 홍길동 implements 아빠, 과장, 남자 {

	@Override
	public void 군대를간다() { }

	@Override
	public void 프로젝트를책임진다() { }

	@Override
	public void 보고서를작성한다() { }

	@Override
	public void 책임진다() { }

	@Override
	public void 돈을번다() { }
	
}
