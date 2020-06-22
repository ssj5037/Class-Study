package com.test.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Ex39_ArrayList_use {
	
	public static void main(String[] args) {
		
		//m1();
		m2();
		
	}

	private static void m2() {

		// 요소의 타입
		// 1. 단일값 배열
		// 2. 다중값 배열
		
		int[] list1 = new int[3];			//단일값 배열(방 1개 = int)
		String[] list2 = new String[3];		//단일값 배열(방 1개 = String)
		Item[] list3 = new Item[3];			//다중값 배열(방 1개 = 데이터 3개)
		
		ArrayList<Integer> list4 = new ArrayList<Integer>();	//단일값 배열
		ArrayList<String> list5 = new ArrayList<String>();		//단일값 배열
		ArrayList<Item> list6 = new ArrayList<Item>();			//다중값 배열

		list3[0] = new Item(); //*
		list3[1] = new Item();
		list3[2] = new Item();
		
		list3[0].a = 100;
		list3[0].b = 200;
		list3[0].c = "홍길동";
		
		
		list6.add(new Item()); //*
		list6.add(new Item());
		list6.add(new Item());
		
		list6.get(0).a = 100;
		list6.get(0).b = 200;
		list6.get(0).c = "홍길동";
		
		int[][] list7 = new int[2][3];
		list7[0][0] = 100;
		
		ArrayList<ArrayList<Integer>> list8 = new ArrayList<ArrayList<Integer>>();
		// 어느 방법을 쓰든 상관없음
		//1.
		list8.add(new ArrayList<Integer>());
		list8.add(new ArrayList<Integer>());
		
		list8.get(0).add(100);
		list8.get(0).add(200);
		list8.get(0).add(300);
		
		//2.
		ArrayList<Integer> sub = new ArrayList<Integer>();
		sub.add(700);
		sub.add(800);
		sub.add(900);
		list8.add(sub);
		
	}

	private static void m1() {
		
		//배열 vs ArrayList
		// - 길이 고정?
		
		// 요구사항] 학생 명단 관리
		// 1. 5명 고정 > 배열 사용
		// 2. 고정 불확실 > ArrayList 사용
		
		Scanner scan = new Scanner(System.in);
		
//		String[] names = new String[5];
		ArrayList<String> names = new ArrayList<String>(); // 가변
		//int count = 5;
		
		//for (int i=0; i<count; i++) {
		for(;;) {
			System.out.print("이름: ");
			
			String input = scan.nextLine();
			if(input.equals("exit")) {
				break;
			}
			names.add(input);
		}
		
		System.out.println();
		System.out.println(names);
	}

}

class Item {
	public int a;
	public int b;
	public String c;
}
