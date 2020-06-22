package com.test.collection;

import java.util.Arrays;

public class MyQueue {
	
	private String[] list;
	private int index;
	
	public MyQueue () {
		this.list = new String[10];
		this.index = 0;
	}
	
	void add(String value) {
		this.list[this.index] = value;
		this.index++;
	}
	
	String poll() {
		String result = this.list[0];
		for(int i=0; i<this.list.length-1; i++) {
			this.list[i] = this.list[i+1];
		}
		this.index--;
		
		return result;
	}
	
	int size() {
		return this.index;
	}
	
	String peek() {
		return this.list[0];
	}
	
	void clear() {
		this.index = 0;
	}
	
	void trimToSize() {
		String[] temp = new String[this.index];
		for(int i=0; i<this.index; i++) {
			temp[i] = this.list[i];
		}
		this.list = temp;
	}

	@Override
	public String toString() {
		return "MyQueue [list=" + Arrays.toString(list) + ", index=" + index + "]";
	}
	
	
	
}
