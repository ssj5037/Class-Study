package com.test.operator;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Ex07_Operator_question_05 {

	public static void main(String[] args)  throws Exception {
		
		// 요구사항 05

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("한달 수입 금액(원) : ");
		String input1 = reader.readLine();
		int income = Integer.parseInt(input1);

		double tax = income * 0.033;			// 세금
		double amountAfterTax = income - tax;	// 세후금액 = 수입 - 세금
		
		System.out.printf("세후 금액(원) : %,.0f원\r\n"
				+ "세금(원) : %,.0f원\r\n", amountAfterTax, tax);

	}
}
