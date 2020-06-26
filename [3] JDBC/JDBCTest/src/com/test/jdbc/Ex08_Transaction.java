package com.test.jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Ex08_Transaction {
	
	public static void main(String[] args) {
		
		//Ex08_Transaction.java
		
		/*
		
		트랜잭션 처리
		1. 오라클(DBMS)
			1-1. 스크립트 작업 중 > 사용자 직접 > commit or rollback
			1-2. 프로시저 내에서.. > 업무제어(제어문 + exception) > commit or rollback
		2. 자바(JDBC > 응용)
			- Connection 클래스를 사용
		
		*/
		
		// Update(댓글 카운트 증가) -> insert(댓글 쓰기)
		
		Connection conn = null;
		Statement stat = null;
		DBUtil util = new DBUtil();
		
		try {
			
			conn = util.open(); //연결
			// 연결 직후에 autocommit 설정을 끄면 자바에서도 트랜잭션 제어가 가능하다.
			conn.setAutoCommit(false);
			
			stat = conn.createStatement(); //실행
			String sql = "";
			
			// 업무 A.
			sql =  "update tblboard set commentcount = commentcount + 1\r\n" + 
					"        where seq = 100";
			
			int result = stat.executeUpdate(sql); //AutoCommit
			
			
			
			// 업무.B
			sql = "insert into tblcomment (seq, subject, pseq)\r\n" + 
					"        values (13, '댓글', 1)";
			
			result += stat.executeUpdate(sql); //AutoCommit
			
			System.out.println("완료");
			
			if (result == 2) {
				conn.commit();
			} else {
				conn.rollback();
			}
			
			conn.commit();

			stat.close();
			conn.close();
			
		} catch (Exception e) {
			e.printStackTrace();
			
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
		
	}

}
