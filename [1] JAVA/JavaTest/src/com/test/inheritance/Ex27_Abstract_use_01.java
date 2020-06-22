package com.test.inheritance;

public class Ex27_Abstract_use_01 {

	public static void main(String[] args) {
		
		// 추상 클래스(추상 메소드) + 배열 + 상속 등등... + 참조형 형변환
		
		// 상황] 전자 제품 대리점 > 프린터 판매
		// 1. HP200 x 5대, LG300 x 3대
		// 2. 하루 1회 > 제품 검수 > 출력 기능 테스트
		
		// 상황 변경]
		// 1. 재고량 증가 > HP200 (100대), LG300 (50대)
		// 2. 브랜드 증가 > Dell400, BenQ500, Samsung600
		// 3. 점검 사항 > 각 제품 본연 기능 테스트
		
		
		// m2() vs m4()
		// - 제품 고유 기능을 자주 사용 + 배열 -> m2() : 해당 타입 배열
		//		- 배열의 개수가 많아진다.
		// - 제품 고옹 기능을 자주 사용 + 배열 -> m4() : 부모 타입 배열
		//		- 배열이 하나로 통합 + 고유 기능 사용을 위해 타입 체크 + 다운캐스팅
		
		
		//m1();
		//m2();
		//m3();
		m4();
		
	}

	private static void m4() {
		// TODO Auto-generated method stub
		
		Printer[] ps = new Printer[8];
		
		for (int i=0; i<ps.length; i++) {
			if(i<5) {
				ps[i] = new HP200();
			} else {
				ps[i] = new LG300();
			}
		}
		
		// 하루 1회 > 정기 점검
		for (int i=0; i<ps.length; i++) {
			ps[i].print();	//HP200 + LG300 -> print()
//			ps[i].call();	// 0~4(O), 5~7(X)
			
			// 다운 캐스팅
//			HP200 hp = (HP200)ps[i];
//			hp.call();
			
			// instanceof 연산자
			// - 2항 연산자
			// - 객체 instanceof 타입
//			System.out.println(ps[i] instanceof HP200);

			if (ps[i] instanceof HP200) {
				HP200 hp = (HP200)ps[i];
				hp.call();
			} else if (ps[i] instanceof LG300) {
				LG300 lg = (LG300)ps[i];
				lg.selfCheck();
			}
			
		}
		
	}

	private static void m3() {
		// TODO Auto-generated method stub
		
		HP200 hp = new HP200();
		LG300 lg = new LG300();
		
		// 부모 = 자식
		// 업캐스팅(100%)
		Printer p1 = hp;
		Printer p2 = new HP200();
		
		Printer p3 = lg;
		Printer p4 = new LG300();
		
		// 같은 부모를 가지는 자시글래스 객체들을 부모 타입의 배열 안에 동시에 넣을 수 있다.
		Printer[] ps = new Printer[2];
		ps[0] = new HP200();
		ps[1] = new LG300();
		
	}

	private static void m2() {
		// TODO Auto-generated method stub
		
		// 반복 패턴 -> 배열 사용
		int hpCount = 5;
		HP200[] hps = new HP200[hpCount];
		// hps[i] = new HP200();
		for (int i=0; i<hps.length; i++) {
			hps[i] = new HP200();
		}
		
		int lgCount = 3;
		LG300[] lgs = new LG300[lgCount];
		for (int i=0; i<lgs.length; i++) {
			lgs[i] = new LG300();
		}
		
		// 하루 1회 > 정기 점검
		for (int i=0; i<hps.length; i++) {
			hps[i].print();
			hps[i].call();
		}
		
		for (int i=0; i<lgs.length; i++) {
			lgs[i].print();
			lgs[i].selfCheck();
		}
		
	}

	private static void m1() {
		// TODO Auto-generated method stub
		
		// 가장 원시적인 방법
		HP200 hp1 = new HP200();
		HP200 hp2 = new HP200();
		HP200 hp3 = new HP200();
		HP200 hp4 = new HP200();
		HP200 hp5 = new HP200();
		
		LG300 lg1 = new LG300();
		LG300 lg2 = new LG300();
		LG300 lg3 = new LG300();
		
		// 하루 1회씩 > 점검
		hp1.print();
		hp2.print();
		hp3.print();
		hp4.print();
		hp5.print();	// hp100.print()
		
		lg1.print();
		lg2.print();
		lg3.print();	// lg50.print()
		
	}
}

// 부모 클래스
// - 회사 or 모델에 상관없이 모든 프린터라고 불리는 기기들이 가져야할 공통사항을 정의하기 위한 클래스
// - 이름 동일 + 행동 다른 메소드가 필요 -> 추상 메소드
abstract class Printer {
	
	// 구현 멤버
	// - 모든 프린터 기기에게 동일한 기능을 상속
	public String model;
	public int price;
	public int ink;
	
	// 추상 멤버
	// - 모든 프린터 기기에게 동일한 기능을 상속 + 내부 구현 각자 알아서
	public abstract void print();
	
}

// HP200 프린터 설계도
class HP200 extends Printer {

	@Override
	public void print() {
		// TODO Auto-generated method stub
		
		// 출력 + HP만의 기술로 구현
		System.out.println("HP200으로 잉크젯 출력을 합니다.");
	}
	
	// HP200만이 가지는 특화된 기능
	public void call() {
		System.out.println("상담원과 연결중입니다.");
	}
	
}

// LG300 프린터 설계도
class LG300 extends Printer {

	@Override
	public void print() {
		// TODO Auto-generated method stub
		
		// 출력 + LG만의 독자적인 기술 구현
		System.out.println("LG300으로 레이저 출력을 합니다.");
	}
	
	// LG300만이 가지는 특화된 기능
	public void selfCheck() {
		System.out.println("자가진단 + 수정합니다.");
	}
	
}
