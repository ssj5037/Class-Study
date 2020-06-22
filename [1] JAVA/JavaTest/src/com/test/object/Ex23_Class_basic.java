package com.test.object;

public class Ex23_Class_basic {

	public static void main(String[] args) {
	
		// 생산된 키보드 세기
		//m1();
		//m2();
		m3();
		
	}

	private static void m3() {
		// TODO Auto-generated method stub
		
		Keyboard k1 = new Keyboard();
		Keyboard.setTcount(Keyboard.getTcount() + 1);
		
		Keyboard k2 = new Keyboard();
		Keyboard.setTcount(Keyboard.getTcount() + 1);
		
		Keyboard k3 = new Keyboard();
		Keyboard.setTcount(Keyboard.getTcount() + 1);
		
		System.out.println(Keyboard.getTcount());
	}

	private static void m2() {
		// TODO Auto-generated method stub
		
		Keyboard k1 = new Keyboard();
//		System.out.println(k1.getCount());
		k1.setCount(k1.getCount() + 1); // count = count + 1;
		
		Keyboard k2 = new Keyboard();
		k1.setCount(k1.getCount() + 1);
		
		Keyboard k3 = new Keyboard();
		k1.setCount(k1.getCount() + 1);
		
		System.out.println(k1.getCount());
		System.out.println(k2.getCount());
		System.out.println(k3.getCount());
	}

	private static void m1() {
		// TODO Auto-generated method stub
	
		// 문제점
		// 1. 마우스 생산 행동 <-> (느슨한 결합) <-> 카운트 행동
		// 2. 변수의 성질이 문법적인 수준에서 보장받지 못한다.
		int count = 0;	// 누적 변수
		
		Keyboard k1 = new Keyboard();
		count++;
		
		Keyboard k2 = new Keyboard();
		count++;
		
		Keyboard k3 = new Keyboard();
		count++;
		
		System.out.println("키보드 개수 : " + count);
	}
}

class Keyboard {
	
	private String model;
	private int price;
	private int count;	// 객체 데이터
	private static int tcount;	// 공용 데이터
	
	public static int getTcount() {
		return tcount;
	}
	public static void setTcount(int tcount) {
		Keyboard.tcount = tcount;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	
}
