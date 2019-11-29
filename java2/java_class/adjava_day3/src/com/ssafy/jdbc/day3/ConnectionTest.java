package com.ssafy.jdbc.day3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionTest {
	static DBUtil util = DBUtil.getUtil();
	public static void main(String[] args) {
		Connection con = null;
		try {
			con = util.getConnection();
			// DB 사용
			System.out.println(con);
		} catch (SQLException e) {
			System.out.println("접속 오류: 서버 경로, 아이디, 비밀번호 확인 요망.");
			e.printStackTrace();
		} finally {
			util.close(con);
			System.out.println("반납 완료");
		}
		
		
		
	}
}
