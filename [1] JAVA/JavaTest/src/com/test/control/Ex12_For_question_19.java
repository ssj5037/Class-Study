package com.test.control;

public class Ex12_For_question_19 {

	public static void main(String[] args) {
		
		// 요구사항 19
		
		for (int i=1; i<=100; i++) {
			int divisor = 0;
			for (int j=1; j<i; j++) {
				if(i % j == 0) {
					divisor += j;
				}
			}
			if(divisor == i) {
				System.out.printf("%d = [",i);
				for(int k=1; k<i; k++) {
					if(i % k == 0) {
						System.out.printf("%d, ",k);
					}
				}
				System.out.print("\b\b]\r\n");
			}
		}
	}
}
