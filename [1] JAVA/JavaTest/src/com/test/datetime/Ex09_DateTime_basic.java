package com.test.datetime;

import java.util.Calendar;
import java.util.Date;

public class Ex09_DateTime_basic {

	public static void main(String[] args) {
		
		// 날짜 + 시간 데이터
		
		// 시각(순간), 시간(시각과 시각의 간격, 양)
		// 시각 + 시각 = X
		// 시각 - 시각 = 시간
		// - 특정 날짜를 잡아서 각 시각 간에 흐른 시간을 구해서 둘의 차이를 구한다.
		// - 보통 자바에서는 ms 단위를 사용한다. tick값을 구해라, 라는 식으로 표현함.
		
		// 전부 int로 연산한다. 따로 시간 자료형을 안 씀.
		// 시간 + 시간 = 시간
		// 시간 - 시간 = 시간
		
		// 시각 + 시간 = 시각
		// 시각 - 시간 = 시각
		
		// 1. Date 클래스, JDK 1.0
		// 2. Calendar 클래스, JDK 1.1
		// 3. java.time 패키지 + 클래스, JDK 1.8
		
		
		// 현재 시각 얻어오기
		//Tue Apr 14 12:36:12 KST 2020
		Date d1 = new Date(); // ***
		System.out.println(d1);
		
		//java.util.GregorianCalendar[time=1586835372701,areFieldsSet=true,areAllFieldsSet=true,lenient=true,zone=sun.util.calendar.ZoneInfo[id="Asia/Seoul",offset=32400000,dstSavings=0,useDaylight=false,transitions=30,lastRule=null],firstDayOfWeek=1,minimalDaysInFirstWeek=1,ERA=1,YEAR=2020,MONTH=3,WEEK_OF_YEAR=16,WEEK_OF_MONTH=3,DAY_OF_MONTH=14,DAY_OF_YEAR=105,DAY_OF_WEEK=3,DAY_OF_WEEK_IN_MONTH=2,AM_PM=1,HOUR=0,HOUR_OF_DAY=12,MINUTE=36,SECOND=12,MILLISECOND=701,ZONE_OFFSET=32400000,DST_OFFSET=0]
		Calendar c1 = Calendar.getInstance(); // ***
		System.out.println(c1);
		
		// 캘린더 내의 원하는 요소를 추출하기
		// - int get(int field)
		System.out.println(c1.get(1));	// YEAR
		System.out.println(c1.get(2));	// MONTH
		System.out.println(c1.get(3));	
		System.out.println(c1.get(4));	
		System.out.println(c1.get(5));	
		
		int year = 1;
		int month = 2;
		
		System.out.println(c1.get(year));
		System.out.println(c1.get(month));
		
		// 캘린더 상수
		System.out.println(Calendar.YEAR);	// 1
		System.out.println(Calendar.MONTH);	// 2
		
		System.out.println(c1.get(Calendar.YEAR));
		System.out.println();
		
		
		// 자바는 순서를 셀 때 0부터 센다.
		// -> 서수를 0부터 시작 -> Zero-based Index
		System.out.println(c1.get(Calendar.YEAR));	//년도
		System.out.println(c1.get(Calendar.MONTH)); //월(0~11) -> 배열(0~) (수치형 데이터가 아님, 열거형임)
		System.out.println(c1.get(Calendar.DATE));	//일
		System.out.println(c1.get(Calendar.HOUR));	//시간(12H)
		System.out.println(c1.get(Calendar.MINUTE));	//분
		System.out.println(c1.get(Calendar.SECOND));	//초
		System.out.println(c1.get(Calendar.MILLISECOND));	//밀리초
		System.out.println(c1.get(Calendar.HOUR_OF_DAY));	//시(24H)
		System.out.println(c1.get(Calendar.DAY_OF_WEEK));	//요일(일1~토7)
		System.out.println(c1.get(Calendar.AM_PM));	//AM 0, PM 1
		
		System.out.println();
		
		
		// 오늘은 2020년 4월 14일입니다. 지금 시간은 오후 2시 21분입니다.
		System.out.printf("오늘은 %d년 %d월 %d일입니다. 지금 시간은 %s %d시 %d분입니다.\r\n"
				, c1.get(Calendar.YEAR)
				, c1.get(Calendar.MONTH)+1
				, c1.get(Calendar.DATE)
				, c1.get(Calendar.AM_PM) == 0 ? "오전" : "오후"
				, c1.get(Calendar.HOUR)
				, c1.get(Calendar.MINUTE));
		
		
		// 시각 출력하기 + printf() 메소드
		System.out.printf("%tF\r\n", c1);
		System.out.printf("%d-%02d-%02d\r\n", c1.get(Calendar.YEAR), c1.get(Calendar.MONTH) + 1, c1.get(Calendar.DATE));
		System.out.printf("%tT\r\n", c1);	// 초있는 24H
		System.out.printf("%tA\r\n", c1);	//요일(로케일 출력, 지역설정)
		System.out.printf("%tR\r\n", c1);	// 초없이 24H
		System.out.printf("%tr\r\n", c1);	// 초있는 12H
	}
}
