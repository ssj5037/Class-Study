package com.test.object;

public class PencilCase {
	
	private String size; // 대중소
	private String color;
	
//	private String item1; // = "볼펜";
//	private String item2; // = "연필";
//	private String item3; // = "지...
	private String[] items = new String[10];
	
	// Case A.
	// private 변수에 직접 접근이 가능하기 때문에 좋지 않은 코드
	public String[] getItems() {
		return items;
	}

	public void setItems(String[] items) {
		this.items = items;
	}
	
	
	// Case B.
	public void setPencil(String item) {
		int i = 0;
		for (i=0; i<items.length; i++) {
			if (items[i] == null) {
				break;
			}
		}
		this.items[i] = item;
	}
	
	public String getPencil(int index) {
		String item = this.items[index];
		this.items[index] = null;
		return item;
	}
}
