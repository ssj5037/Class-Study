package com.test.object;

import java.util.Calendar;

public class Ex34_Generic_use_01 {
	
	public static void main(String[] args) {
		
		// 일반클래스, 추상클래스, 인터페이스, 열거형, 제네릭 클래스
		// 제네릭 클래스, Generic Class
		
		//m1();
		
		//m2();
		// refactor - extract interface : 자동으로 메소드로 빼준다.

		
		WrapperInt n1 = new WrapperInt(100);
		System.out.println(n1.getData() + 100);
		n1.setData(200);
		System.out.println(n1);
		
		WrapperObject n2 = new WrapperObject(200);	// Boxing
		System.out.println((int)n2.getData() + 200);
		n2.setData(300);
		System.out.println(n2);

		Wrapper<Integer> n3 = new Wrapper<Integer>(300);
		System.out.println(n3.getData() + 300);
		// 오브젝트처럼 다운캐스팅을 하지 않아도 된다.
		n3.setData(400);
		System.out.println(n3);
		
		
		System.out.println();
		
		
		WrapperString s1 = new WrapperString("홍길동");
		System.out.println(s1.getData());
		s1.setData("아무개");
		System.out.println(s1);
		
		WrapperObject s2 = new WrapperObject("유재석");	// Boxing
		System.out.println(((String)s2.getData()).length());
		s2.setData("강호동");
		System.out.println(s2);
		
		Wrapper<String> s3 = new Wrapper<String>("하하하");
		System.out.println(s3.getData().length());
		s3.setData("호호호");
		System.out.println(s3);
		
		
		System.out.println();
		
		
		WrapperBoolean b1 = new WrapperBoolean(true);
		System.out.println(b1.getData());
		b1.setData(false);
		System.out.println(b1);
		
		WrapperObject b2 = new WrapperObject(true);	// Boxing
		System.out.println((boolean)b2.getData() ? "하하":"호호");
		b2.setData(false);
		System.out.println(b2);
		
		Wrapper<Boolean> b3 = new Wrapper<Boolean>(true);
		System.out.println(b3.getData() ? "통과" : "거절");
		b3.setData(false);
		System.out.println(b3);
				
		
		System.out.println();
		
		
	}

	private static void m2() {
		
		UserTime t1 = new UserTime(2,30);
		System.out.println(t1);
		//위의 코드가 자동으로 아래로 변현됨
		System.out.println(t1.toString()); // 패키지명.클래스명@해시코드
		
		Calendar c1 = Calendar.getInstance();
		System.out.println(c1);
		System.out.println(c1.toString());	// 메소드 오버라이드(재정의)
		// 오브젝트가 표현한걸 다시 뜯어고쳐서 자기가 다시 바꿈
		
		// 모든 자바 개발자는
		// 객체.toString() -> 객체가 가지는 데이터를 문자열로 반환 -> 무조건 기대
		
	}

	private static void m1() {
		// TODO Auto-generated method stub
		
		int a = 10;	// 값형 -> 정수
		Integer b = new Integer(10); // 참조형 -> 정수 Wrapper Class, Util Class
		
		System.out.println(a + b);	// b: 객체임에도 불구하고 값형처럼 쓰일 수 있음
		// 참조형은 피연산자가 될 수 없지만 얘는 자동 언박싱을 해주기 때문에 가능하다.
		
		long c = 10;
		Long d = new Long(10);
		
		Integer.parseInt("10");
		// 숫자 10에 종속된 일을 하는 것이 아니라 범용적으로 사용되는 것이므로 정적메소드를 사용하는게 좋다.
		
		// 1. static 변수
		// 2. final 변수 -> 읽기 전용		
		System.out.println(Integer.MAX_VALUE);
		
	}

}

// 요구사항
// - int -> Integer
// 1. int 값 1개를 중심으로 그 값을 조작하는 클래스를 설계하시오.
// 2. String 값 1개를 중심으로 그 값을 조작하는 클래스를 설계하시오.
// 3. boolean 값 1개를 중심으로 그 값을 조작하는 클래스를 설계하시오.
// 4. double
// 5. char
// 6. byte
// 7. short
// 8. float
// 9. long
// 10. Random
// 11. Calendar
// 12. UserTime

class WrapperInt {
	private int data;	// 중심 데이터

//	public WrapperInt() { 
//	this.data = 0;
//	}
	// 개발자들을 위해 기본 생성자를 만들어주곤한다.
	
	public WrapperInt(int data) {
		this.data = data;
	}
	
	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}
	
	@Override
	public String toString() {
		
		//String.valueOf(this.data)
		return this.data + ""; 
	}
	
}

class WrapperString {
	
	private String data;	// 중심 데이터
	
	public WrapperString(String data) {
		this.data = data;
	}
	
	public String getData() {
		return data;
	}
	
	public void setData(String data) {
		this.data = data;
	}
	
	@Override
	public String toString() {
		
		//String.valueOf(this.data)
		return this.data + ""; 
	}
	
}

class WrapperBoolean {
	
	private boolean data;	// 중심 데이터
	
	public WrapperBoolean(boolean data) {
		this.data = data;
	}
	
	public boolean getData() {
		return data;
	}
	
	public void setData(boolean data) {
		this.data = data;
	}
	
	@Override
	public String toString() {
		
		//String.valueOf(this.data)
		return this.data + ""; 
	}
	
}

class WrapperObject {
	private Object data;
	
	public WrapperObject(Object data) {
		this.data = data;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "WrapperObject [data=" + data + "]";
	}
	
}


class Wrapper<T> {
	
	private T data;
	
	public Wrapper(T data) {
		this.setData(data);
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "Wrapper [data=" + data + "]";
	}
	
}


class UserTime {
	
	private int hour;
	private int min;
	
	public UserTime(int hour, int min) {
		this.hour = hour;
		this.min = min;
	}
	
}


