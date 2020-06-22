package com.test.string;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Ex14_String_question_09 {
	
	public static void main(String[] args) throws Exception {
		
		// 요구사항 09
		
		// 주민등록번호 유효성 검사
		// 1. xxxxxx - xxxxxxx
		//    234567   892345
		// 2. 곱해서 다 더함
		// 3. 11로 나눔
		// 4. 11에서 나머지를 뺌
		// 5. 11은 1 10은 0으로 치환 후
		// 6. 마지막 자리랑 같은지 비교한다
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("주민등록번호 : ");
//		String input = "951220-1021547";
		String input = reader.readLine();
		String jumin = input.substring(0,6) + input.substring(input.length()-7);
//		System.out.println(jumin);
		int result = 0, sum = 0;
		for (int i=0, j=2; i<jumin.length()-1; i++, j++) {
			if(j==10) {
				j = 2;
			}
			sum += j * Integer.parseInt(jumin.substring(i,i+1));
		}

		result = 11 - (sum % 11);

		if (result == 11) {
			result = 1;
		} else if (result == 10) {
			result = 0;
		}

		if(result == Integer.parseInt(jumin.substring(12))) {
			System.out.println("올바른 주민등록번호입니다.");
		} else {
			System.out.println("올바르지 않은 주민등록번호입니다.");
		}
		
	}

}
