package com.test.io;

public class Ex04_Output_question {

	public static void main(String[] args) {
		
		
		String name = "홍길동";
		int age = 20;
		String sex = "남자";
		String live = "서울시 강남구 역삼동";
		
		System.out.printf("안녕하세요.제 이름은 %s 입니다.\n 나이는 %d살이고 %s입니다.\n 저는 '%s'에 살고 있습니다.", name, age, sex,live);
		System.out.println("\n");
		
		
		String name1 = "홍길동";
		int kor1 = 80;
		int eng1 = 90;
		int math1 = 95;
		
		String name2 = "아무개";
		int kor2 = 76;
		int eng2 = 86;
		int math2 = 79;
		
		String name3 = "하하하";
		int kor3 = 89;
		int eng3 = 92;
		int math3 = 85;
		
		System.out.println("[학생]\t[국어]\t[영어]\t[수학]\t[평균]");
		System.out.println("--------------------------------------");
		System.out.printf("%s\t%d\t%d\t%d\t%d\n", name1, kor1,eng1,math1, (kor1+eng1+math1 )/3);
		System.out.printf("%s\t%d\t%d\t%d\t%d\n", name2, kor2,eng2,math2, (kor2+eng2+math2 )/3);
		System.out.printf("%s\t%d\t%d\t%d\t%d\n", name3, kor3,eng3,math3, (kor3+eng3+math3 )/3);
		System.out.println();
		
		String day1 = "2020-01-01";
		String day2 = "2020-01-02";
		String day3 = "2020-01-03";
	
		
		String coffee = "카페라테";
		String pig = "돼지불백";
		String mart = "마트 장본것들";
		String bus = "교통 카트 충전";
		String cu = "편의점";
		
		int c1 = 4800;
		int p1 = 8500;
		int m1 = 125840;
		int b1 = 45000;
		int cu1 = 16200;
		
		System.out.println("[날짜]\t\t[내역]\t\t[금액]");
		System.out.println("----------------------------------------");
		System.out.printf("%s\t%s\t%,10d원\n", day1 , coffee, c1);
		System.out.printf("%s\t%s\t%,10d원\n", day1 , pig, p1);
		System.out.printf("%s\t%s\t%,10d원\n", day2 , mart, m1);
		System.out.printf("%s\t%s\t%,10d원\n", day3 , bus, b1);
		System.out.printf("%s\t%s\t%,18d원\n", day3 , cu, cu1);
		
		
		
		
		
		
		
		
		
	}
}
