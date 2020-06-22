package com.test.object;

public class Ex20_Class_basic {

	public static void main(String[] args) {
	
		Person p1 = new Person();
		p1.setName("홍길동");
		
		Person p2 = new Person();
		p2.setName("아무개");
		
		Person p3 = new Person();
		p3.setName("하하하");
		
		
		// 참조형 배열
		Person[] list = new Person[3]; //Person 객체가 몇 개 생성되었습니까? 3개(X) 0개(O)
		// Person타입의 배열
		
		list[0] = new Person();
		list[1] = new Person();
		list[2] = new Person();
		//객체 주소값 대입을 해야 비로소 객체배열을 완성함.
		
		//java.lang.NullPointerException
		// 아무것도 없는데 쓰려고 할 때 나는 에러
		list[0].setName("홍길동");
	}
}

class Person {
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
