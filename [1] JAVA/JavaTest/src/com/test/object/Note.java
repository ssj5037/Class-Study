package com.test.object;

public class Note {

	private String size;
	private String color;
	private int page;
	private String owner;
	private int price;
	
	// 크기 쓰기
	public void setSize(String size) {
		String[] standard = {"A3", "A4", "A5", "B3", "B4", "B5"};
		for (int i=0; i<standard.length; i++) {
			if (size == standard[i]) {
				this.size = size;
			}
		}
	}
	
	// 색상 쓰기
	public void setColor(String color) {
		String[] standard = {"검정색", "흰색", "노란색", "파란색"};
		for (int i=0; i<standard.length; i++) {
			if (color == standard[i]) {
				this.color = color;
			}
		}
	}
	
	// 페이지 수 쓰기
	public void setPage(int page) {
		if (page >= 10 && page <= 200) {
			this.page = page;
		}
	}
	
	// 소유자 이름 쓰기
	public void setOwner(String owner) {
		if (checkOwner(owner)) {
			this.owner = owner;
		}
	}
	
	// 소유자 이름 유효성 검사
	private boolean checkOwner(String owner2) {
		// TODO Auto-generated method stub
		
		if(owner2.length() < 2 && owner2.length() > 5) {
			return false;
		}
		
		for (int i=0; i<owner2.length(); i++) {
			char c = owner2.charAt(i);
			if(c <'가' && c > '힣') {
				return false;
			}
		}
		return true;
	}
	
	public String info() {
		String pageSize = "";
		if (page >= 10 && page <= 50) {
			pageSize = "얇은";
		} else if (page >= 51 && page <=100) {
			pageSize = "보통";
		} else if (page >= 101 && page <=200) {
			pageSize = "두꺼운";
		}
		
		price = 500;
		if (size == "A3") {
			price += 400;
		} else if (size == "A4") {
			price += 200;
		} else if (size == "B3") {
			price += 500;
		} else if (size == "B4") {
			price += 300;
		} else if (size == "B5") {
			price += 100;
		}
		
		if (color == "검정색") {
			price += 100;
		} else if (color == "노란색") {
			price += 200;
		} else if (color == "파란색") {
			price += 200;
		}
		
		if (page > 10) {
			price += (page - 10) * 10;
		}
		
		String result;
		result = "■■■■■■■ 노트 정보 ■■■■■■■\r\n";
		if (this.owner != null) {
//			result += "소유자 : " + this.owner + "\r\n"
//					+ "특성 : " + this.color 
//					+ " " + pageSize
//					+ " " + this.size + "노트\r\n"
//					+ "가격 : " + this.price + "원\r\n";
			result += String.format("소유자 : %s\r\n"
					+ "특성 : %s %s %s노트\r\n"
					+ "가격 : %,d원\r\n"
					, this.owner
					, this.color, pageSize, this.size
					, this.price);
		} else {
			result += "주인 없는 노트\r\n";
		}
		result += "■■■■■■■■■■■■■■■■■■■■■■■■■";

		return result;
	}
}
