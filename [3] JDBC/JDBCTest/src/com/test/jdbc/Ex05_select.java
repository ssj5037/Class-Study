package com.test.jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.Scanner;

public class Ex05_select {
	
	public static void main(String[] args) {
		
		//Ex05_select.java
		//m1();
		//m2();
		//m3();
		//m4();
		//m5();
		//m6();
		m7();
				
	}//main

	private static void m7() {
		
		// 개발부 직원 명단을 출력 + 직원수 출력
		
		Connection conn = null;
		Statement stat = null;
		ResultSet rs = null;
		DBUtil util = new DBUtil();
		
		try {

			conn = util.open();
			stat = conn.createStatement();

			String sql = String.format("select count(*) as cnt from tblinsa where buseo = '개발부'");
			
			rs = stat.executeQuery(sql);
			if(rs.next()) {
				System.out.printf("직원수: %s\n", rs.getString("cnt"));
			}
			
			rs.close();

			System.out.println("[이름]\t[직위]\t[지역]\t[연락처]\t[급여]");
			
			sql = String.format("select * from tblinsa where buseo = '개발부'");

			// rs == select 결과
			rs = stat.executeQuery(sql); //레코드수? > 확인 불가
			
//			int count = 0;
			
			while(rs.next()) {
				//개발부 + 부장 -> 커서 맞춰져 있는 상태
				System.out.printf("%s\t%s\t%s\t%s\t%s\r\n"
						, rs.getString("name")
						, rs.getString("jikwi")
						, rs.getString("city")
						, rs.getString("tel")
						, rs.getString("basicpay"));
//				count++;
			}
			
//			System.out.println("직원수: " + count);
			
			rs.close();
			
						
			stat.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void m6() {
		
		// 중첩된 select
		
		Connection conn = null;
		Statement stat = null;
		ResultSet rs = null;
		DBUtil util = new DBUtil();

		try {

			conn = util.open();
			stat = conn.createStatement();

			String sql = String.format("select distinct buseo from tblinsa order by buseo");

			rs = stat.executeQuery(sql);
			
			while (rs.next()) { // 부서 x 7바퀴
				System.out.printf("[[%s]]\n", rs.getString("buseo"));
				sql = String.format("select * from tblinsa where buseo = '%s' order by case\r\n" + 
						"    when jikwi = '부장' then 1\r\n" + 
						"    when jikwi = '과장' then 2\r\n" + 
						"    when jikwi = '대리' then 3\r\n" + 
						"    when jikwi = '사원' then 4\r\n" + 
						"end, name", rs.getString("buseo"));
				
				Statement stat2 = conn.createStatement();
				ResultSet rs2 = stat2.executeQuery(sql);
				
				while(rs2.next()) { //각 부서별 직원들...
					System.out.printf("%s(%s)\n"
							, rs2.getString("name")
							, rs2.getString("jikwi"));
				}
				System.out.println();
				rs2.close();
			}
			
			rs.close();

			stat.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	private static void m5() {
		
		//tblAddress -> 주소 검색
		//검색어: 주소 키워드
		
		Connection conn = null;
		Statement stat = null;
		ResultSet rs = null;
		DBUtil util = new DBUtil();
		Scanner scan = new Scanner(System.in);
		
		try {

			// 검색어 입력
			System.out.print("검색어 입력: ");
			String word = scan.nextLine();
			
			conn = util.open();
			stat = conn.createStatement();

			String sql = String.format("select name, gender, age, address from tbladdressbook where replace(lower(address), ' ', '') "
					+ "like '%%' || replace(lower('%s'), ' ','') || '%%' order by address", word);

			rs = stat.executeQuery(sql);
			
			System.out.println("[이름]\t[성별]\t[나이]\t[주소]");
			
			while (rs.next()) {
				System.out.printf("%s\t%s\t%s\t%s\n"
						, rs.getString("name")
						, rs.getString("gender")
						, rs.getString("age")
						, rs.getString("address"));
			}
			
			rs.close();

			stat.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	private static void m4() {
		
		//tblInsa
		//1. 직원 1명: 개발부(부장)
		//2. 직원 모두: 개발부(나머지)
		
		Connection conn = null;
		Statement stat = null;
		ResultSet rs = null;
		DBUtil util = new DBUtil();
		
		System.out.println("[이름]\t[직위]\t[지역]\t[연락처]\t[급여]");

		try {

			conn = util.open();
			stat = conn.createStatement();

			String sql = String.format("select * from tblinsa where buseo = '개발부' and jikwi = '부장'");

			// rs == select 결과
			rs = stat.executeQuery(sql);
			
			if(rs.next()) {
				//개발부 + 부장 -> 커서 맞춰져 있는 상태
				System.out.printf("%s\t%s\t%s\t%s\t%s\r\n"
						, rs.getString("name")
						, rs.getString("jikwi")
						, rs.getString("city")
						, rs.getString("tel")
						, rs.getString("basicpay"));
				
			}
			
			rs.close();
			
			System.out.println("------------------------------------------------");
			
			// 또 다른 select 실행
			sql = "select * from tblinsa where buseo = '기획부' and jikwi <> '부장' order by jikwi";
			
			// rs에 새로운 참조변수 넣음
			rs = stat.executeQuery(sql);
			
			while (rs.next()) { //결과셋의 레코드 개수만큼 반복
				System.out.printf("%s\t%s\t%s\t%s\t%s\r\n"
						, rs.getString("name")
						, rs.getString("jikwi")
						, rs.getString("city")
						, rs.getString("tel")
						, rs.getString("basicpay"));
			}
			
			rs.close();
						
			stat.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	private static void m3() {
		
		// m2() -> m3() 확장
		// 직원 번호 입력 -> 직원 정보 출력
		
		Scanner scan = new Scanner(System.in);
		System.out.print("직원 번호: ");
		String num = scan.nextLine();
		
		Connection conn = null;
		Statement stat = null;
		ResultSet rs = null;
		DBUtil util = new DBUtil();

		try {

			conn = util.open();
			stat = conn.createStatement();

			String sql = String.format("select * from tblinsa where num = %s", num);

			rs = stat.executeQuery(sql);
			
			if(rs.next()) {
				
				System.out.println("이름: " + rs.getString("name"));
				System.out.println("부서: " + rs.getString("buseo"));
				System.out.println("직위: " + rs.getString("jikwi"));
				System.out.println("지역: " + rs.getString("city"));
				System.out.printf("급여: %,d원\n",rs.getInt("basicpay"));
				
				System.out.println();
				
				//1. 컬럼값 얻어오기(******)
				System.out.println(rs.getString(1));
				System.out.println(rs.getString("name"));
				
				//2. 레코드(컬럼) 정보 얻어오기
				ResultSetMetaData rsmd = rs.getMetaData();
				System.out.println(rsmd.getColumnCount()); //결과셋의 컬럼개수
				
				for(int i=1; i<=rsmd.getColumnCount(); i++) {
					System.out.println(rs.getString(i));
				}
				
				System.out.println();
				// 컬럼 index -> label
				System.out.println(rsmd.getColumnLabel(2));
				System.out.println(rsmd.getColumnLabel(3));
				System.out.println();
				
				System.out.println(rsmd.getColumnTypeName(2));
				System.out.println(rsmd.getColumnTypeName(3));
				System.out.println();
				
				System.out.println(rsmd.getColumnDisplaySize(2));
				System.out.println(rsmd.getColumnDisplaySize(3));
				System.out.println();
				
				
			} else {
				System.out.println("잘못됐거나 존재하지 않는 직원 번호를 입력했습니다.");
			}

			stat.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	private static void m2() {
		
		Connection conn = null;
		Statement stat = null;
		ResultSet rs = null;
		DBUtil util = new DBUtil();

		try {

			conn = util.open();
			stat = conn.createStatement();

			String sql = String.format("select max(ibsadate) as ibsadate from tblinsa");

			rs = stat.executeQuery(sql); //select -> rs
			
			if (rs.next()) {
				
				// 컬럼값 취하기
				// 오라클(date) -> 자바(java.sql.Date)
//				Date ibsadate = rs.getDate("ibsadate");
//				System.out.printf("%tF %tT\r\n",ibsadate, ibsadate);
				
				
				// 오라클(date) -> 자바(String)
				// 보통 출력말고는 잘 안하기 때문에 보통 String을 많이 쓴다.
				// 추가 작업은 보통 sql developer에서 완료를 하고 오기 때문에.
				String date = rs.getString("ibsadate");
				System.out.println(date);
				
				
			}

			stat.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}//m2

	private static void m1() {
		
		// 단일값 반환
		// - select > 1행 1열

		Connection conn = null;
		Statement stat = null;
		ResultSet rs = null;
		DBUtil util = new DBUtil();

		try {

			conn = util.open();
			stat = conn.createStatement();

			String sql = String.format("select count(*) as cnt from tbladdress where seq = 3");

//			stat.executeUpdate(sql); > insert, update, delete, create ..
//			stat.executeQuery(sql); > select
			
			rs = stat.executeQuery(sql); //ResultSet 열기
			
			//ResultSet 탐색(*****)
//			rs.next(); // 커서를 다음 레코드로 이동하기
			
			if(rs.next()) {
				
				String cnt = rs.getString(1);
				// 모두 동일한데 자료형만 다른 것이다.
				//int cnt2 = rs.getInt(1);
				//double cnt3 = rs.getDouble(1);
				
				// 가독성의 이유로 getString으로 컬럼명을 받아온다.
				cnt = rs.getString("cnt");
				
				System.out.println(cnt);
			} else {
				System.out.println("select 결과 없음");
			}
			
			stat.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}//m1

}
