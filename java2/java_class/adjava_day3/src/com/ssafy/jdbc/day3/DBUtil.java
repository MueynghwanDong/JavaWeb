package com.ssafy.jdbc.day3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * DB 접속과 관련된 기능적인 역할을 수행
 * 
 * @author student
 */
public class DBUtil {
	// Singleton Design Pattern을 적용
	private static DBUtil util = new DBUtil();

	private DBUtil() {
		// 드라이버 로딩
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static DBUtil getUtil() {
		return util;
	}

	// Database Connection을 반환하는 메서드
	public Connection getConnection() throws SQLException {
		// DB 접속하기
		String url = "jdbc:mysql://localhost:3306/jdbc?serverTimezone=UTC";
		String user = "root";
		String pass = "ssafy";
		return DriverManager.getConnection(url, user, pass);
	}

	// Database Connection을 종료시키는 메서드
	public void close(Connection con) {
		if (con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	// Connection과 Statement를 종료시키는 메서드 : 얻을 때의 역순으로 close
	public void close(Statement stmt, Connection con) { // method overloading
		if (stmt != null) {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		close(con);
	}

	public void close(ResultSet rset, Statement stmt, Connection con) { // method overloading
		if (rset != null) {
			try {
				rset.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		close(stmt, con);
	}

	public void close(Statement stmt) { // method overloading
		if (stmt != null) {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public void close(ResultSet rset, Statement stmt) { // method overloading
		if (rset != null) {
			try {
				rset.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		close(stmt);
	}

	public void rollback(Connection con) {
		if (con != null) {
			try {
				con.rollback();
			} catch (SQLException e) {
				e.printStackTrace();
				util.rollback(con);
			} finally {
				util.close(con);
			}
		}
	}

} // end of class
