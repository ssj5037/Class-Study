package com.test.inheritance;

import java.util.Calendar;
import java.util.Random;

public class Ex32_Object_basic {

	public static void main(String[] args) {
		
		// Object 클래스
		// - java.lang.Object
		// - 중요 클래스
		// - Class Object is the root of the class hierarchy.Every class has Object as a superclass. All objects,including arrays, implement the methods of this class.
		
		Temp t = new Temp();
		
		t.a = 10;
		//t.equals();
		//t.hashCode();
		//t.toString();
		System.out.println(t.hashCode());	//임시 ID (식별자) : 메모리상의 저장 위치(주소값)
		System.out.println(t.toString());	// 16진수로 표현되어있음
		
		Object o1 = new Object();
		Object o2 = new AA();
		Object o3 = new BB();
		Object o4 = new CC();
		Object o5 = new Random();
		Object o6 = Calendar.getInstance();	//그레고리력 태국이면 태국 달력을 반환 (지역간의 차를 없애려고)
		//java.util.Calendar : 추상클래스
		Object o7 = "홍길동";
		// 위는 참조형, 밑은 값형
		Object o8 = 10;
		Object o9 = true;
		// Object에 담을 수 없는 것이 없다.
		Object[] list = new Object[10];
		
		AA a = new AA();
		AA b = new BB();
		AA c = new CC();
		
		
		Object rnd1 = new Random();
		Object rnd2 = new Random();
		
		list[0] = new Random();
		
		//System.out.println(rnd1.nextInt());
		//System.out.println((Random)rnd1.nextInt());
		System.out.println(((Random)rnd1).nextInt());	// ***
		System.out.println(((Random)list[0]).nextInt());
		
		
		int num1 = 10;
		Object num2 = 20;	// Boxing - 성능저하
		// 값형 데이터를 object에 넣으면 자동으로 boxing이 된다.
		// num2에 20을 넣은 Wrapper class의 주소값이 저장이 됨.
		
		System.out.println(num1 + 10);
		System.out.println((Integer)num2 + 10);
		System.out.println((int)num2 + 10);	//UnBoxing - 성능저하
		// 다운캐스팅으로 하면 unboxing이 내부적으로 발생한다.
		
		// 박싱, 언박싱은 참조형과 값형 사이의 변환에서 일어난다.
		
	}

}

class AA {
	
}

class BB extends AA {
	
}

class CC extends BB {
	
}

class Temp { // class Temp (extends Object) 컴파일시에 Object를 자동으로 부모클래스로 받는다.
	public int a;
}
