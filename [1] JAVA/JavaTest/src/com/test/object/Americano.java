package com.test.object;

public class Americano {

	private int bean;
	private int water;
	private int ice;
	
	public void setBean(int bean) {
		this.bean = bean;
	}
	public void setWater(int water) {
		this.water = water;
	}
	public void setIce(int ice) {
		this.ice = ice;
	}
	
	public void drink() {
		System.out.printf("원두 %dg, 물 %dml, 얼음 %d개로 만들어진 아메리카노를 마십니다.\r\n"
				, bean, water, ice);
	}
}
