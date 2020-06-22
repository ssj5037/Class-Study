package com.test.collection;

public class MyArrayList {
	
	private String[] list;
	private int index; //마지막 방번호
	
	public MyArrayList() {
		this.list = new String[10]; //중요!!!
		this.index = 0;
	}
	
	public void add(String item) {
		
//		if (포화상태) {
//			기존배열 -> 2배 크기 배열 교체
//		}
		
		this.list[this.index] = item;
		this.index++;
	}
	
	public String get(int index) {
		
		//배열(10) : size(5)
		
		if (index >= 0 && index < size()) {
			
			return this.list[index];
 		} else {
 			
 			throw new IndexOutOfBoundsException(); //강제 에러 발생
 		}
		
	}
	
	public int size() {
		
		return this.index;
	}
}
