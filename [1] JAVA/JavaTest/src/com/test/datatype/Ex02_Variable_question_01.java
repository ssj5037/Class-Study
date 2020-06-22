package com.test.datatype;

public class Ex02_Variable_question_01 {

	public static void main(String[] args) {
		
		// 문제. 9개 자료형 -> 주변 데이터 검색 -> 자료형 선택 -> 변수 생성 -> 값을 대입 -> 문장으로 출력하기
		
		byte pill;
		pill = 10;
		System.out.println("오늘 구매한 약은 한 통에 알약이 총 " + pill + "개가 들어있습니다.");
		
		int bill;
		bill = 6200;
		System.out.println("이 제품은 " + bill + "원 입니다.");
		
		float distance;
		distance = 42.195F;
		System.out.println("마라톤 풀코스의 완주 거리는 "+ distance + "km입니다.");
		
		double depth;
		depth = 1642;
		System.out.println("세계에서 가장 깊은 호수인 바이칼 호수의 깊이는 약 " + depth + "m라고 합니다.");
		
		String tool;
		tool = "이클립스";
		System.out.println("저는 요즘 자바를 배우는데, " + tool + "라는 툴을 사용합니다.");
		
		long budget;
		budget = 513500000000000L;
		System.out.println("기재부가 발표한 국가재정운용계획에 따르면 우리나라의 예산은 올해 " + budget + "원입니다.");
		// http://news.einfomax.co.kr/news/articleView.html?idxno=4045761 : 출처 연합뉴스
		// 513조5천억원
		
		short party;
		party = 35;
		System.out.println("20년 총선 비례대표 선거에 나선 정당은 " + party + "군데입니다.");
		
		char lastName;
		lastName = '신';
		System.out.println("저는 " + lastName + "씨입니다.");
		
		boolean center;
		center = true;
		System.out.println("쌍용교육센터는 역삼에 있습니다. : " + center);
		
		int line;
		line = 49;
		System.out.println("현재 작성하고 있는 위치는 " + line + "번 째 라인입니다.");
		
	}
}
