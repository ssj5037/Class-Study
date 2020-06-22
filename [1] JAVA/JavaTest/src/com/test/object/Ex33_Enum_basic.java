package com.test.object;

public class Ex33_Enum_basic {
	
	public static void main(String[] args) {
		
		// 열거형, Enumeration
		// - 클래스
		// - enum 키워드
		
		// 나열된 형태의 데이터가 필요한 경우..
		// -> 옷 쇼핑몰 -> 색상 선택
		
		String color = "빨강";
		
		if (color.equals("빨강") || color.equals("노랑") || color.equals("파랑")) {
			System.out.println("재고 있음");
		} else {
			System.out.println("재고 없음");
		}
		
		
		// 1(빨강), 2(노랑), 3(파랑)
		int color2 = 1;
		
		if (color2 == 1 || color2 == 2 || color2 == 3) {
			System.out.println("재고 있음");
		} else {
			System.out.println("재고 없음");
		}
		
		
		// 열거형
		Color color3 = Color.RED;
		
		if (color3 == Color.RED || color3 == Color.YELLOW || color3 == Color.BLUE) {
			System.out.println("재고 있음");
		} else {
			System.out.println("재고 없음");
		}
		// 오타가 나면 무조건 컴파일 에러가 남.
		
		Employee hong = new Employee();
		hong.name = "홍길동";
		//hong.position = "과장";
		hong.position = 직급.사원;
		hong.position2 = 4;
		hong.position2 = 직급2.사원; //4
		
	}

}

// 열거형 -> 멤버 변수
// 열거형은 자동으로 final이 들어가기 때문에 전부 대문자로 적어주는 것이 관행
enum Color {
	RED,	//public final static int red
	YELLOW,
	BLUE
}

enum 직급 {
	부장,
	과장,
	대리,
	사원
}
// 위 아래가 같은 코드임
class 직급2 {
	public final static int 부장 = 1;
	public final static int 과장 = 2;
	public final static int 대리 = 3;
	public final static int 사원 = 4;	
}

class Employee {
	public String name;
	public 직급 position;
	public int position2;
}
