package com.test.object;

public class Latte {
	
	private int bean;
	private int milk;
	
	public void setBean(int bean) {
		this.bean = bean;
	}
	public void setMilk(int milk) {
		this.milk = milk;
	}
	
	public void drink() {
		System.out.printf("원두 %dg, 우유 %dml로 만들어진 라테를 마십니다.\r\n"
				, bean, milk);
	}
}
