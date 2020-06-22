package com.test.object;

public class Barista {

	public Espresso makeEspresso(int bean) {
		Espresso espresso = new Espresso();
		espresso.setBean(bean);
		Coffee.esspresso++;
		Coffee.bean += bean;
		return espresso;
	}
	
	public Espresso[] makeEspressoes(int bean, int count) {
		Espresso[] espresso = new Espresso[count];
		for (int i=0; i<count; i++) {
			espresso[i] = new Espresso();
			espresso[i].setBean(bean);
			Coffee.esspresso++;
			Coffee.bean += bean;
		}
		return espresso;
	}

	public Latte makeLatte(int bean, int milk) {
		Latte latte = new Latte();
		latte.setBean(bean);
		latte.setMilk(milk);
		Coffee.latte++;
		Coffee.bean += bean;
		Coffee.milk += milk;
		return latte;
	}

	public Latte[] makeLattes(int bean, int milk, int count) {
		Latte[] latte = new Latte[count];
		for (int i=0; i<count; i++) {
			latte[i] = new Latte();
			latte[i].setBean(bean);
			latte[i].setMilk(milk);
			Coffee.latte++;
			Coffee.bean += bean;
			Coffee.milk += milk;
		}
		return latte;
	}
	
	public Americano makeAmericano(int bean, int water, int ice) {
		Americano americano = new Americano();
		americano.setBean(bean);
		americano.setWater(water);
		americano.setIce(ice);
		Coffee.americano++;
		Coffee.bean += bean;
		Coffee.water += water;
		Coffee.ice += ice;
		return americano;
	}
	
	public Americano[] makeAmericanos(int bean, int water, int ice, int count) {
		Americano[] americano = new Americano[count];
		for (int i=0; i<count; i++) {
			americano[i] = new Americano();
			americano[i].setBean(bean);
			americano[i].setWater(water);
			americano[i].setIce(ice);
			Coffee.americano++;
			Coffee.bean += bean;
			Coffee.water += water;
			Coffee.ice += ice;
		}
		return americano;
	}
	
	public void result() {
		Coffee.beanTotalPrice = Coffee.bean * Coffee.beanUnitPrice;
		Coffee.waterTotalPrice = Coffee.water * Coffee.waterUnitPrice;
		Coffee.iceTotalPrice = Coffee.ice * Coffee.beanUnitPrice;
		Coffee.milkTotalPrice = Coffee.milk * Coffee.milkUnitPrice;
		
		System.out.println("===================");
		System.out.println("     판매 결과");
		System.out.println("===================");
		System.out.println();
		System.out.println("-------------------");
		System.out.println("음료 판매량");
		System.out.println("-------------------");
		System.out.printf("에스프레소 : %d잔\r\n아메리카노 : %d잔\r\n라테 : %d잔\r\n"
				, Coffee.esspresso, Coffee.americano, Coffee.latte);
		System.out.println();
		System.out.println("-------------------");
		System.out.println("원자재 소비량");
		System.out.println("-------------------");
		System.out.printf("원두 : %,dg\r\n물 : %,dml\r\n얼음 : %,d개\r\n우유 : %,dml\r\n"
				, Coffee.bean, Coffee.water, Coffee.ice, Coffee.milk);
		System.out.println();
		System.out.println("-------------------");
		System.out.println("매출액");
		System.out.println("-------------------");
		System.out.printf("원두 : %,dg\r\n물 : %,.1fml\r\n얼음 : %,d개\r\n우유 : %,dml\r\n"
				, Coffee.beanTotalPrice, Coffee.waterTotalPrice, Coffee.iceTotalPrice, Coffee.milkTotalPrice);
		System.out.println();
		
	}
}
