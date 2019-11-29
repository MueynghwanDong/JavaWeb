package com.ssafy.jdbc.day3;

import java.sql.Connection;
import java.sql.SQLException;

public class CountryService {
	/// Singleton
	private static CountryService service = new CountryService();
	public static CountryService getService() {
		return service;
	}
	private CountryService() {}
	
	
	CountryDao dao = CountryDao.getDao();
	DBUtil util = DBUtil.getUtil();
	
	public void insertCountry(Country country) {
		Connection con = null;
		try {
			// connection 획득
			con = util.getConnection();
			con.setAutoCommit(false);
			// dao 사용
			dao.insert(con, country);
			// transaction 처리
			con.commit();
			// connection 반납
		} catch (SQLException e) {
			util.rollback(con);
			e.printStackTrace();
		} finally {
			util.close(con);
		}
	}
	
	public void updateCountry(Country country) {
		Connection con = null;
		
		try {
			con = util.getConnection();
			con.setAutoCommit(false);
			
			dao.update(con, country);
			con.commit();
		} catch (SQLException e) {
			util.rollback(con);
			e.printStackTrace();
		} finally {
			util.close(con);
		}
		
	}
	
	// select는 transaction과 상관없는 동작
	public void selectCountry(int countryId) {
		Connection con = null;
		
		try {
			con = util.getConnection();
			Country selected = dao.select2(con, countryId);
			System.out.println("조회 결과 : " + selected);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			util.close(con);
		}
	}
	
	
	
	
}















