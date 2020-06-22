package com.test.io;

public class Ex04_Output_use_01 {

	public static void main(String[] args) {
		

//		// Case A.
//		System.out.println(100);
//		System.out.println(90);
//		System.out.println(80);
//		
//		// Case B.
//		int kor = 100;
//		int eng = 90;
//		int math = 80;
//		
//		System.out.println(kor);
//		System.out.println(eng);
//		System.out.println(math);
		
		
		// print() & println()
		
		// 학생 3명 + 국영수 -> 성적 출력
		String name1 = "홍길동";
		int kor1 = 100;
		int eng1 = 90;
		int math1 = 80;
		
		String name2 = "아무개";
		int kor2 = 95;
		int eng2 = 92;
		int math2 = 76;
		
		String name3 = "호호호";
		int kor3 = 87;
		int eng3 = 67;
		int math3 = 99;
		
		
		// println()
		System.out.println("[이름]\t[국어]\t[영어]\t[수학]");
		System.out.println("--------------------------------");
		System.out.println(name1 + '\t' + kor1 + '\t' + eng1 + '\t' + math1);
		System.out.println(name2 + '\t' + kor2 + '\t' + eng2 + '\t' + math2);
		System.out.println(name3 + '\t' + kor3 + '\t' + eng3 + '\t' + math3);
		
		System.out.println();
		System.out.println();
		
		System.out.println("[이름]\t[국어]\t[영어]\t[수학]");
		System.out.println("--------------------------------");
		System.out.print(name1 + '\t' + kor1 + '\t' + eng1 + '\t' + math1 + "\r\n");
		System.out.print(name2 + '\t' + kor2 + '\t' + eng2 + '\t' + math2 + "\r\n");
		System.out.print(name3 + '\t' + kor3 + '\t' + eng3 + '\t' + math3 + "\r\n");
		
		System.out.println();
		System.out.println();
		
		// printf(), print format 메소드
		
		// 요구사항] "홍길동님 안녕하세요." 출력
		// 추가사항] "홍길동님 안녕하세요. 홍길동님 오랜만입니다. 출력
		String name = "홍길동";
		System.out.println(name + "님 안녕하세요.");
		System.out.printf("%s님 안녕하세요.\r\n", name);
		
		System.out.println(name + "님 안녕하세요. " + name + "님 오랜만입니다.");
		System.out.printf("%s님 안녕하세요. %s님 오랜만입니다.\r\n", name, name);
		
//		System.out.printf("%s\t%d\t%d\t%d\r\n", name1, kor1, eng1, math1);
//		System.out.printf("%s\t%d\t%d\t%d\r\n", name2, kor2, eng2, math2);
//		System.out.printf("%s\t%d\t%d\t%d\r\n", name3, kor3, eng3, math3);
		
		System.out.println();
		System.out.println();
		
		
		// SQL
		// - 데이터베이스에 레코드(행)을 추가하는 명령어
		
		// - "insert into tblScore (name, kor, eng, math) values ('홍길동', 100, 90, 80);"
		System.out.println("insert into tblScore (name, kor, eng, math) values ('" + name1 + "', " + kor1 + ", " + eng1 + ", " + math1 + ");");
		System.out.printf("insert into tblScore (name, kor, eng, math) values ('%s', %d, %d, %d);", name1, kor1, eng1, math1);
		
		System.out.println();
		System.out.println();
		
		// java.util.IllegalFormatConversionException
		// java.util.MissingFormatConversionException
		
		System.out.printf("제 이름은 %s입니다. 나이는 %d살입니다. 원주율은 %f입니다. \"나는 남자다\"라는 문장은 %b입니다. 제가 제일 좋아하는 문자는 %c입니다.\n"
				, "홍길동"
				, 20
				, 3.14
				, true
				, 'G');
		
		System.out.println();
		System.out.println();
		
		int num = 10;
		
		// 숫자 : 좌측? 우측(수치)
		// 문자 : 좌측(O) 우측?
		System.out.printf("[%d]\n", num);
		System.out.printf("[%10d]\n", num);
		System.out.printf("[%-10d]\n", num);
		
		System.out.println();
		System.out.println();
		
		System.out.println("==========");
		System.out.println("[가격(원)]");
		System.out.println("==========");
		System.out.printf("%,10d\n", 1000000);
		System.out.printf("%,10d\n", 2500);
		System.out.printf("%,10d\n", 35840);
		System.out.printf("%,10d\n", 154780);
		System.out.printf("%,10d\n", 25600);
		
		System.out.println();
		System.out.println();
		
		double a = 1000000;
		double b = 3;
		
		System.out.printf("%f\n", a / b);
		System.out.printf("%,20.1f\n", a / b);
		System.out.printf("%,20.10f\n", a / b);
		
		
		double c = 3.145678;
		System.out.printf("%.3f\n", c);
		
		
		
	}
}
