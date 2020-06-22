package com.test.object;

import java.util.Arrays;

public class Ex19_Class_basic {
	
	public static void main(String[] args) {
		
		// 클래스의 멤버 > 배열 멤버
		// PencilCase.java
		
		// Case A-a.
		PencilCase c1 = new PencilCase();
		
		String[] items = new String[10];
		items[0] = "볼펜";
		items[1] = "연필";
		items[2] = "만년필";
		
		c1.setItems(items);
		
		System.out.println(Arrays.toString(c1.getItems()));
		
		
		// Case A-b.
		PencilCase c2 = new PencilCase();
		
		c2.getItems()[0] = "연필";
		c2.getItems()[1] = "만년필";
		c2.getItems()[2] = "볼펜";
		// getItems()의 리턴값 items 배열
		
		System.out.println(Arrays.toString(c2.getItems()));

		
		// Case B.
		PencilCase c3 = new PencilCase();
		
		c3.setPencil("볼펜");
		c3.setPencil("연필");
		c3.setPencil("만년필");
		
		System.out.println(c3.getPencil(1));
		System.out.println(c3.getPencil(1));
	
	
	}

}
