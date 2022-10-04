package com.company.Spring_MVC_Board.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class JDBCUtil {
	//H2 DB 연동에 관한 소스 ==> DB에 따라 변경
	static final String driver = "org.h2.Driver";
	static final String url = "jdbc:h2:tcp://localhost/~/test;DB_CLOSE_DELAY=-1";
	
	public static Connection getConnection() throws Exception{
		try {
			Class.forName(driver);
			Connection con = DriverManager.getConnection(url, "sa", "");
			return con;
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	/*
	 * CRUD 작업이 끝나면 자원(메모리에 올라온 객체)을 해제해야 한다.
	 */
	//자바의 다형성 ==> 즉 메소드 오버로딩
	//select 작업종료 시 자원 해제 메소드
	public static void close(ResultSet rs, PreparedStatement stmt, Connection conn) {
		if(rs != null) {
			try {
				if(!rs.isClosed())
					rs.close();
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				rs = null;
			}
		}
		if(stmt != null) {
			try {
				if(!stmt.isClosed())
					stmt.close();
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				stmt = null;
			}
		}
		if(conn != null) {
			try {
				if(!conn.isClosed())
					conn.close();
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				conn = null;
			}
		}
	}
	//DML(data manipulation language-insert,update,delete) 작업종료 시 자원 해제 메소드
	public static void close(PreparedStatement stmt, Connection conn) {
		if(stmt != null) {
			try {
				if(!stmt.isClosed())
					stmt.close();
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				stmt = null;
			}
		}
		if(conn != null) {
			try {
				if(!conn.isClosed())
					conn.close();
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				conn = null;
			}
		}
	}
	
}
