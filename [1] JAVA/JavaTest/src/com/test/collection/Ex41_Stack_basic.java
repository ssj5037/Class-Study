package com.test.collection;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Ex41_Stack_basic {
	
	public static void main(String[] args) {
		
		// Stack, 스택
		// - 후입선출
		// - LIFO, Last Input First Output
		
		// Queue, 큐
		// - 선입선출
		// - FIFO, First Input First Output
		
		//m1();
		m2();
		
	}

	private static void m2() {
		
		Queue<String> queue = new LinkedList<String>();
		// Queue는 Interface로만 존재해서 인스턴스를 만들 수 없다.
		
		queue.add("빨강");
		queue.add("파랑");
		queue.add("노랑");
		
		System.out.println(queue.size());
		
		System.out.println(queue.poll());
		System.out.println(queue.poll());
		System.out.println(queue.poll());
		System.out.println(queue.poll());	// 에러 안남 (null)
		
		System.out.println(queue.size());
		
		queue.add("빨강");
		queue.add("파랑");
		queue.add("노랑");
		
		System.out.println(queue.peek());
		System.out.println(queue.peek());
		System.out.println(queue.peek());
		System.out.println();
		
//		while (queue.size() > 0) {
//			System.out.println(queue.poll());
//		}
		
		while (!queue.isEmpty()) {
			System.out.println(queue.poll());
		}
		
		
		
		
		// Collection, queue의 부모인터페이스, 잘 안쓰는게 좋음
		
	}

	private static void m1() {
		
		Stack<String> stack = new Stack<String>();
		
		stack.push("강아지");
		stack.push("고양이");
		stack.push("병아리");
		
		System.out.println(stack.size());
		
//		System.out.println(stack.pop());
//		System.out.println(stack.pop());
//		System.out.println(stack.pop());
//		System.out.println(stack.pop());	// 에러남
		
		// 모든 요소 꺼내기
		while (stack.size() > 0) {
			System.out.println(stack.pop());
		}
		
		//if (stack.size() > 0) {
		if (!stack.isEmpty()) {
			System.out.println(stack.pop());
		}
		
		stack.push("강아지");
		stack.push("고양이");
		stack.push("병아리");
		stack.push("병아리");
		stack.push("병아리");
		
		System.out.println(stack);
		
		stack.clear();
		
		System.out.println(stack);
		
		stack.push("강아지");
		stack.push("고양이");
		stack.push("병아리");

		System.out.println(stack.peek());	//읽기만
		System.out.println(stack.pop());	//읽기+삭제
		
		// Vector 오래된거니 쓰지말기
	
	
	}

}
