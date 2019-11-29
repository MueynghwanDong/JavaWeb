package com.ssafy.jdbc.day3;

import java.sql.SQLException;
import java.util.List;

public class CountryDaoTest {
	CountryDao dao = CountryDao.getDao();
	public static void main(String[] args) {
		CountryDaoTest cdt = new CountryDaoTest();
		try {
			cdt.selectAllTest();
//			cdt.selectTest2(86);
//			cdt.insertTest();
//			cdt.updateTest();
			cdt.selectTest2(110); 
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void updateTest() throws SQLException {
		dao.update(DBUtil.getUtil().getConnection(), new Country(110, "잠나라", null));
	}
	
	public void insertTest() throws SQLException {
		dao.insert(DBUtil.getUtil().getConnection(), new Country(111, "달나라", null));
	}
	
	public void selectAllTest() throws SQLException {
		List<Country> list = dao.selectAll(DBUtil.getUtil().getConnection());
		
		for(Country c : list) {
			System.out.println(c);
		}
	}
	
	public void selectTest(Integer countryId) throws SQLException {
		dao.select(DBUtil.getUtil().getConnection(), countryId, "South Korea");
	}
	
	public void selectTest2(Integer countryId) throws SQLException {
//		dao.select2(countryId);
		// sql injection 공격 (sql 삽입 공격의 대상이 된다. 그래서 Statement는 사용하면 안된다.)
//		dao.select(countryId, 1=1);
		Country c = dao.select2(DBUtil.getUtil().getConnection(), 110);
		System.out.println("조회 결과 : " + c);
	}
	
}
