package com.test.object;

public class Ex16_Class_question_01 {

	public static void main(String[] args) {
		
		// Ex16_Class_question_01.java : 테스트 중심
		// Book.java : 설계 중심
		
		Book oracle = new Book();
		oracle.setTitle("Do It 오라클로 배우는 데이터베이스 입문");
		oracle.setPrice(25000);
		oracle.setAuthor("이지훈");
		oracle.setPublisher("이지스퍼블리싱");
		oracle.setPage(528);
		oracle.setIsbn("1163030309");
		System.out.println(oracle.info());
		
	}
}
