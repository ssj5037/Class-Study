package com.test.jdbc;

import java.sql.Connection;

public class Ex02 {
	
	public static void main(String[] args) {
		
		DBUtil util = new DBUtil();
		Connection conn = null;
		
		try {

//			conn = util.open();	// 접속
			conn = util.open("211.63.89.53", "project", "java1234");
			
			System.out.println(conn.isClosed());
			
			util.close(); //접속해제
			
		} catch (Exception e) {
			System.out.println("Ex02.main()");
			e.printStackTrace();
		}
	}

}
