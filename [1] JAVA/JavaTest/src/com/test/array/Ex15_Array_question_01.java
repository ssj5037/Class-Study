package com.test.array;

public class Ex15_Array_question_01 {

	public static void main(String[] args) {
		
		// 요구사항 01
		
		int[] list = new int[4];
		list[0] = 10;
		list[1] = 20;
		list[2] = 30;
		list[3] = 40;
		String result = dump(list);
		System.out.printf("nums = %s\n", result);
	}

	private static String dump(int[] list) {
		// TODO Auto-generated method stub
		
		String result = "[ ";
		
		for (int i=0; i<list.length; i++) {
			
			if(i != list.length -1) {
				result += list[i] + ", ";
			} else {
				result += list[i] + " ]";
			}
		}		
		return result;
	}
}
