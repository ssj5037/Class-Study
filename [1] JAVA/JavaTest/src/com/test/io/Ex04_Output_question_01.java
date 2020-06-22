package com.test.io;

public class Ex04_Output_question_01 {

	public static void main(String[] args) {
		
		// 요구사항 01
		
		String name = "홍길동";
		int age = 20;
		String gender = "남자";
		String address = "서울시 강남구 역삼동";
		
		System.out.printf("안녕하세요. 제 이름은 '%s'입니다.\r\n나이는 %d살이고 %s입니다.\r\n저는 '%s'에 살고 있습니다.\r\n"
				, name, age, gender, address);

		// --- 줄바꿈 ---
		
		System.out.println();
		System.out.println();
		
		// 요구사항 02
		
		String student1 = "홍길동";
		int kor1 = 80, eng1 = 90, math1 = 95;
		int average1 = (kor1 + eng1 + math1) /3;
		
		String student2 = "아무개";
		int kor2 = 76, eng2 = 86, math2 = 79;	
		int average2 = (kor2 + eng2 + math2) /3;	
		
		String student3 = "하하하";
		int kor3 = 89, eng3 = 92, math3 = 85;
		int average3 = (kor3 + eng3 + math3) /3;
		
		System.out.println("[학생]\t[국어]\t[영어]\t[수학]\t[평균]");
		System.out.println("--------------------------------------");
		System.out.printf("%s%8d%8d%8d%8d\r\n", student1, kor1, eng1, math1, average1);
		System.out.printf("%s%8d%8d%8d%8d\r\n", student2, kor2, eng2, math2, average2);
		System.out.printf("%s%8d%8d%8d%8d\r\n", student3, kor3, eng3, math3, average3);
		
		// --- 줄바꿈 ---
		
		System.out.println();
		System.out.println();
		
		// 요구사항 03
		
		String date01 = "2020-01-01";
		String date02 = "2020-01-02";
		String date03 = "2020-01-03";
		
		String coffee = "카페라테";
		int coffeePrice = 4800;
		String meal = "돼지불백";
		int mealPrice = 8500;
		String market = "마트 장본것들";
		int marketPrice = 125840;
		String trafficCard = "교통 카드 충전";
		int trafficCardPrice = 45000;
		String convenience = "편의점";
		int conveniencePrice = 16200;
		
		System.out.println("[날짜]\t\t[내역]\t\t\t[금액]");
		System.out.println("----------------------------------------------");
		System.out.printf("%s\t%s\t%,12d원\r\n", date01, coffee, coffeePrice);
		System.out.printf("%s\t%s\t%,12d원\r\n", date01, meal, mealPrice);
		System.out.printf("%s\t%s\t%,12d원\r\n", date02, market, marketPrice);
		System.out.printf("%s\t%s\t%,12d원\r\n", date03, trafficCard, trafficCardPrice);
		System.out.printf("%s\t%s\t\t%,12d원\r\n", date03, convenience, conveniencePrice);
		
	
	}
}
