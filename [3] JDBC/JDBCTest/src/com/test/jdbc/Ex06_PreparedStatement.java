package com.test.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Ex06_PreparedStatement {
	
	public static void main(String[] args) {
		
		//Ex06_PreparedStatement.java
		//insert 작업
		//m1(); //Statement > 정적 쿼리
		m2(); //PreparedStatement > 동적 쿼리
		
		// Statement vs PreparedStatement
		//1. SQL 매개변수 유무
		// - select * from tblInsa; > Statement
		// - select * from tblInsa where num = ?; > PreparedStatement
		
	}//main

	private static void m2() {
		
		// 사용자 입력
		String name = "아무개";
		String age = "25";
		String tel = "010-1212-1212";
		String address = "서울시 강남구's 역삼동";
		
		Connection conn = null;
		PreparedStatement stat = null;
		ResultSet rs = null;
		DBUtil util = new DBUtil();

		try {

			conn = util.open();

			String sql = "insert into tbladdress (seq, name, age, tel, address, regdate) "
					+ "values (seqaddress.nextval, ?, ?, ?, ?, default)";
			
			//stat = conn.createStatement();
			stat = conn.prepareStatement(sql);
			
			// 자바 쿼리 자료형이 String이어서 setString 넣음
			stat.setString(1, name);
			stat.setString(2, age);
			stat.setString(3, tel);
			stat.setString(4, address);
			
			stat.executeUpdate();
			
			System.out.println("실행 완료");

			stat.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}//m2

	private static void m1() {
		
		// 사용자 입력
		String name = "아무개";
		String age = "25";
		String tel = "010-1212-1212";
		String address = "서울시 강남구's 역삼동";
		
		Connection conn = null;
		Statement stat = null;
		ResultSet rs = null;
		DBUtil util = new DBUtil();

		try {

			conn = util.open();
			stat = conn.createStatement();

			String sql = String.format("insert into tbladdress (seq, name, age, tel, address, regdate) "
					+ "values (seqaddress.nextval, '%s', %s, '%s', '%s', default)", name, age, tel, address);

			stat.executeUpdate(sql);
			
			System.out.println("실행 완료");

			stat.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}//m1

}//Ex06
