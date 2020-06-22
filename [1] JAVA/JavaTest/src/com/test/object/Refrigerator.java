package com.test.object;

public class Refrigerator {

	public void add(Item item) {
		System.out.printf("'%s'를 냉장고에 넣었습니다.\r\n", item.getName());
	}
	
	public Item get(String name) {
		Item item = new Item();
//		item.getName() == 
		return item;
	}
}
