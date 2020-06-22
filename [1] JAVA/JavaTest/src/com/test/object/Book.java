package com.test.object;

public class Book {

	private String title;				// 읽쓰, 한영수 최대 50자 이내
	private int price;					// 읽쓰, 0 ~ 1,000,000원
	private String author;				// 읽쓰, 제한x
	private String publisher;			// 쓰
	private String pubYear = "2020";	// 읽
	private String isbn;				// 읽쓰
	private int page;					// 읽쓰, 1~무제한
	
	// 제목 읽기
	public String getTitle() {
		return title;
	}
	
	// 제목 쓰기
	public void setTitle(String title) {
		if (checkTitle(title)) {
			this.title = title;
		} else {
			System.out.println("유효하지 않은 제목입니다.");
		}
	}
	
	// 제목 유효성 검사 (한영수)
	private boolean checkTitle(String title2) {
		// TODO Auto-generated method stub
		
		if (title.length() <= 0 && title.length() > 50) {
			return false;
		}
		
		for (int i=0; i<title2.length(); i++) {
			char c = title2.charAt(i);
			if((c < '가' || c > '힣')
					&& (c < 'A' || c > 'Z')
					&& (c < 'a' || c > 'z')
					&& (c < '0' || c > '9')
					&& (c != ' ')){
				return false;
			}
		}
		return true;
	}
	
	// 가격 읽기
	public int getPrice() {
		return price;
	}
	
	// 가격 쓰기
	public void setPrice(int price) {
		if (price >= 0 && price <= 1000000) {
			this.price = price;
		} else {
			System.out.println("유효하지 않은 가격입니다.");
		}
	}
	
	// 저자 읽기
	public String getAuthor() {
		return author;
	}
	
	// 저자 쓰기
	public void setAuthor(String author) {
		this.author = author;
	}
	
	// ISBN 읽기
	public String getIsbn() {
		return isbn;
	}
	
	// ISBN 쓰기
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	
	// 페이지수 읽기
	public int getPage() {
		return page;
	}
	
	// 페이지수 쓰기
	public void setPage(int page) {
		if (page >= 1) {
			this.page = page;
		} else {
			System.out.println("유효하지 않은 페이지수입니다.");
		}
	}
	
	// 발행년도 읽기
	public String getPubYear() {
		return pubYear;
	}
	
	// 출판사 쓰기
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	
	public String info() {
		String result = "[" + title + "]\r\n"
				+ author + " 저 / "
				+ publisher + " / "
				+ pubYear + "년 / "
				+ isbn + "\r\n"
				+ "총 " + page + "p / "
				+ price + "원\r\n";
		return result;
	}
	
}
