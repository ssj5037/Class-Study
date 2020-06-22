package com.test.object;

public class Ex22_Class_basic {
	
	public static void main(String[] args) {
		
		// 시작 -> 클래스 로딩 -> 설계도 읽기
		// 클래스 로딩 과정에 static 변수는 미리 메모리상에 만들어 둔다.
		// 객체변수는 new StaticItem()에 오는 순간 만들어진다.
		// main 메소드를 빠져나가는 순간 지역변수 item은 죽는데, 객체변수 a는 죽지 않는다.
		// 하지만 a를 찾아갈 수 있는 주소값을 가진 데이터가 없기 때문에 찾아갈 수 없음.
		// -> 모든 참조가 끊긴 object, garbage값.
		// 가비지 컬렉터가 가비지를 회수하는 순간 죽어버림.
		// 하지만 주소값을 모르니 a에 찾아갈 수 있는 방법은 없기 때문에,
		// 객체 변수는 지역변수 item이 죽는 순간 죽는다고 해도 무방함.
		// static 변수는 프로그램이 종료되는 순간 사라짐.
		// 메모리를 계속 차지하고 있어서 자칫하다간 프로그램이 무거워지고 느려지기 때문에 써먹기가 어려움.
		
		StaticItem item = new StaticItem();
		
		System.out.println(item.a);
		// 객체 변수는 객체 참조 변수를 통해 접근
		System.out.println(StaticItem.b);
		// 정적 변수는 클래스를 통해 접근
		//System.out.println(item.b); // 절대 사용 금지, The static field StaticItem.b should be accessed in a static way
		
		
	}

}

class StaticItem {
	
	// 생명 주기
	// - 객체 변수 : 객체 생성 태어남 ~ 객체 소멸 죽음(객체 참조 변수 소멸 시 같이 소멸)
	// - 정적 변수 : main() 시작 전 태어남 ~ main() 종료 후 죽음
	// - 정적 변수 > 객체 변수 > 지역 변수
	public int a = 10;			// 객체 변수
	public static int b = 20;	// 정적 변수, 공용 변수, 클래스 변수
	
	// 객체 멤버 메소드
	public void aaa() {
		System.out.println(a);
		System.out.println(b);
		// 정석 표현
		System.out.println(this.a);			// 객체 변수
		System.out.println(StaticItem.b);	// 정적 변수
		// this : 객체 접근 연산자
	}
	
	// 정적 멤버 메소드
	// 정적 메소드 안에서는 this를 쓸 수 없음.
	public static void bbb() {
//		System.out.println(a);
		System.out.println(b);
//		System.out.println(this.a);
		System.out.println(StaticItem.b);
	}
	
}
