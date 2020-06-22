package com.test.collection;

import java.util.Arrays;

public class MyStack {
	
	private String[] list;
	private int index;

	public MyStack() {
		this.list = new String[10];
		this.index = 0;
	}
	
	void push(String value) {
		this.list[this.index] = value;
		this.index++;
	}
	
	String pop() {
		this.index--;
		return this.list[this.index];
	}
	
	int size() {
		return this.index;
	}
	
	String peek() {
		return this.list[this.index-1];
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
		return "MyStack [list=" + Arrays.toString(list) + ", index=" + index + "]";
	}
	
}
