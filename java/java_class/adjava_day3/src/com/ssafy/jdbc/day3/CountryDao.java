package com.ssafy.jdbc.day3;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

// Dao : Data Access Object : 개별 쿼리를 실행하는 모듈
public class CountryDao {
	private static CountryDao dao = new CountryDao();
	
	private CountryDao() {
		
	}
	
	public static CountryDao getDao() {
		return dao;
	}
	
	DBUtil util = DBUtil.getUtil();
	
	public void update(Connection con, Country country) throws SQLException {
		String sql = "Update mycountry set country = ?, last_update=? where country_id = ?";
		PreparedStatement pstmt = null;
		
		try {
			pstmt = con.prepareStatement(sql);
			// prepared statement에 파라미터 세팅
			pstmt.setString(1, country.getCountry());
			pstmt.setDate(2, new Date(System.currentTimeMillis()));
			pstmt.setInt(3, country.getCountryId());
			// query 수행
			int updated = pstmt.executeUpdate();
			System.out.println(updated + " 행이 영향을 받음 !");
		} finally {
			util.close(pstmt);
		}
	}
	
	// connection, exception에 대한 처리는 service에게 위임.
	public void insert(Connection con, Country country) throws SQLException {
		String sql = "Insert into mycountry (country_id, country) values(?, ?)";
		PreparedStatement pstmt = null;
		
		try {
			pstmt = con.prepareStatement(sql);
			// prepared statement에 파라미터 세팅
			pstmt.setInt(1, country.getCountryId());
			pstmt.setString(2, country.getCountry());
			// query 수행
			int updated = pstmt.executeUpdate();
			System.out.println(updated + " 행이 영향을 받음.");
		}finally {
			util.close(pstmt);
		}
	}
	
	
	
	public Country select2(Connection con, Integer countryId) throws SQLException {
		Country country = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			String sql = "Select * from mycountry where country_id = ?";
//			Statement stmt = con.createStatement();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, countryId);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
//				String country = rs.getString("country");
//				Date lastUpdate = rs.getDate(3);
//				System.out.printf("id: %d, name: %s, date: %s\n", countryId, country, lastUpdate);
				country = new Country(countryId, rs.getString("country"), rs.getDate(3));
			}
			
		} finally {
			util.close(rs, pstmt);
		}
		
		return country;
	}
	
	
	// countryId에 해당하는 나라의 이름을 출력하시오.
	public void select(Connection con, Integer countryId, String country) throws SQLException {
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = con.createStatement();
			String sql = "Select * from mycountry where country_id = " + countryId + " and country = '" + country + "'";
			rs = stmt.executeQuery(sql);
			
			if(rs.next()) {
//				String country = rs.getString("country");
				Date lastUpdate = rs.getDate(3);
				System.out.printf("id: %d, name: %s, date: %s\n", countryId, country, lastUpdate);
			}
		} finally {
			util.close(rs, stmt);
		}
	}
	
	
	public List<Country> selectAll(Connection con) throws SQLException {
		ArrayList<Country> list = new ArrayList<>();
		Statement stmt = null;
		ResultSet rs = null;
		// 1. Connection
		try {
			// 2. 질의
			stmt = con.createStatement();
			String query = "Select * from mycountry";
			rs = stmt.executeQuery(query);	// 질의 후 결과확인을 위한 통로 개설
			
			// 3. 결과 확인
			while(rs.next()) {
//				int countryId = rs.getInt(1);
//				String country = rs.getString("country");
//				Date lastUpdate = rs.getDate(3);
//				System.out.printf("id: %d, name: %s, date: %s\n", countryId, country, lastUpdate);
				Country c = new Country(rs.getInt(1), rs.getString("country"), rs.getDate(3));
				list.add(c);
			}
		} finally {
			// 4. 자원 반납
			util.close(rs, stmt);
		}
		
		return list;
	}
}
