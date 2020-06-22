package com.test.control;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Ex12_For_question_11 {

	public static void main(String[] args) throws Exception {
		
		// 요구사항 11
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("최대 숫자 : ");
		int maxNum = Integer.parseInt(reader.readLine());
		
		// 입력 값이 양수인지 확인
		if (maxNum > 0) {
			// 입력 값이 4자리수를 넘어가면 최대치 999로 변경
			if (maxNum > 999) {
				maxNum = 999;
			}
			// 1부터 최대치까지 루프 돌림
			for (int i=1; i<=maxNum; i++) {
				// 100의자리에 3 6 9가 들어가면 짝 1번
				if(i / 100 == 3 || i / 100 == 6 || i / 100 == 9) {
					System.out.print("짝");
					// 10의자리 구분을 위해 100의자리 숫자 뺌
					int j = i - (i / 100) * 100;
					// 10의자리에 3 6 9가 들어가면 짝 2번
					if (j / 10 == 3 || j / 10 == 6 || j / 10 == 9) {
						System.out.print("짝");
						// 1의자리에 3 6 9가 들어가면 짝 3번
						if(j % 10 == 3 || j % 10 == 6 || j % 10 == 9) {
							System.out.print("짝");
						} // 1의자리에 3 6 9 없으면 짝 2번
					// 10의자리에 3 6 9 없으면 짝 1번
					} else {
						// 1의자리에 3 6 9 있으면 짝 2번
						if(j % 10 == 3 || j % 10 == 6 || j % 10 == 9) {
							System.out.print("짝");
						} // 1의자리에 3 6 9 없으면 짝 1번
					}
				// 100의 자리에 3 6 9가 없으면 짝 0번
				} else {
					// 10의자리 구분을 위해 100의자리 숫자 뺌
					int j = i - (i / 100) * 100;
					// 10의자리에 3 6 9가 들어가면 짝 1번
					if (j / 10 == 3 || j / 10 == 6 || j / 10 == 9) {
						System.out.print("짝");
						// 1의자리에 3 6 9가 들어가면 짝 2번
						if(j % 10 == 3 || j % 10 == 6 || j % 10 == 9) {
							System.out.print("짝");
						} // 1의자리에 3 6 9 없으면 짝 1번
					// 10의자리에 3 6 9 없으면 짝 0번
					} else {
						// 1의자리에 3 6 9 있으면 짝 1번
						if(j % 10 == 3 || j % 10 == 6 || j % 10 == 9) {
							System.out.print("짝");
						} else {// 1의자리에 3 6 9 없으면 짝 0번 -> 숫자 i 출력
							System.out.print(i);
						}
					}
				}
				System.out.print(" ");
			}
		} else {
			System.out.println("알맞은 숫자를 입력하시오.");
		}
		
	}
}
