package com.test.inheritance;

public class Ex29_Interface_use_02 {

	public static void main(String[] args) {
		
		// 1. 추상메소드 -> 추상클래스 vs 인터페이스
		// 2. 추상클래스(인터페이스) 반드시 사용?
		
		// 5년
//		M706 m1 = new M706();
//		m1.click();
//		m1.drag();
		
		// 구입
//		S300 m2 = new S300();
//		m2.click();
//		//m2.drag();
//		m2.wheel();
		
		
		
		// 참조 변수
//		M706 m1 = new M706();
//		m1.click();	// 마우스 공통기능
//		m1.drag();	// 로지텍 특화기능
//		m1.wheel();	// 마우스 공통기능
//					// -> 기능이 코드 만으로는 구분이 가지 않음
//		
//		S300 m2 = new S300();
//		m2.click();
//		m2.drag();
//		m2.wheel();
		// -> 애초에 처음부터 사용자들을 공통 기능만 쓸 수 있도록 길들여야함(
		
		
		
		// 인터페이스 변수
		//M706 m1 = new M706();
		IMouse m1 = new M706();
		m1.click();
		m1.wheel();
		
		M706 temp = (M706)m1;	// 공통기능이 아닌 것을 사용할 때 다운 캐스팅
		temp.drag();			// 로지텍 특화 기능임이 구분이 감
		
		//S300 m2 = new S300();
		IMouse m2 = new S300();
		m2.click();
		m2.wheel();
		
	}
}

// 공통 기능 : click(), wheel()
// 부모 역할 : 인터페이스 
//			   (잘 모르겠으면 인터페이스 -> 왜냐면 인터페이스가 부담이 적음)
interface IMouse {
	void click();
	void wheel();
}

abstract class AMouse {
	
	// 구현 멤버 -> 모든 마우스가 가져야할 멤버
	public String model;
	public String color;
	public int button;
	public int seight;
	public int size;
	public int level;
	
	public abstract void click();
	public abstract void wheel();
	
}


// 일반 마우스
class M706 implements IMouse {
	
	// 멤버 변수
	
	// 멤버 메소드
	public void click() {
		System.out.println("로지텍 기술 + 클릭!!");
	}
	
	// ? 그대로 vs 버려 -> 보통 그대로 둠
	public void drag() {
		System.out.println("로지텍 기술 + 드래그~");
	}

	@Override
	public void wheel() {
		// TODO Auto-generated method stub
		System.out.println("로지텍 기술 + 휠!!");
	}
	
}

class S300 implements IMouse{
	
	// 멤버 변수
	
	// 멤버 메소드
	public void click() {
		System.out.println("삼성 기술 + 클릭!!");
	}
	
	public void wheel() {
		System.out.println("삼성 기술 + 스크롤~~");
	}
	
}


// 새로운 마우스 설계 > 독자 vs 규격 > 규격
class N500 extends AMouse {

	// 6개 구현 멤버 변수
	// -> 인터페이스의 경우 멤버변수들의 이해를 할 필요가 없기 때문에 부담이 적음
	// 	  심지어 이미 정의되어 있기 때문에 추상메소드에 비해 더 어려움
	// 2개 추상 메소드
	
	@Override
	public void click() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void wheel() {
		// TODO Auto-generated method stub
		
	}
	
}

