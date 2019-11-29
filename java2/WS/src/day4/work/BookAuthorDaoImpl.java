package day4.work;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BookAuthorDaoImpl implements BookAuthorDao {
	private static BookAuthorDaoImpl impl = new BookAuthorDaoImpl();
	public static BookAuthorDaoImpl getImpl() {
		return impl;
	}
	private BookAuthorDaoImpl() {}
	
	BookDAO bDao = BookDAO.getDao();

	@Override
	public List<Map<String, Object>> getTitlePriceAuthorUsingBookAuthor() {
		String sql = "select title, price, name from book "
				   + "left join author using(authorno)";
		List<Map<String, Object>> list = new ArrayList<Map<String,Object>>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		try {
			con = bDao.getConnection();
			pstmt = con.prepareStatement(sql);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("title", rset.getString(1));
				map.put("price", rset.getInt(2));
				map.put("name", rset.getString(3));
				list.add(map);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			bDao.close(pstmt, con);
		}
		return list;
	}

	@Override
	public List<Map<String, String>> getTitleIsbnPublisherByAuthorName() {
		String sql = "select title, isbn, publisher from book "
				   + " where authorno=("
				   + "select authorno from author where name='김태희')";
		List<Map<String, String>> list = new ArrayList<>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		try {
			con = bDao.getConnection();
			pstmt = con.prepareStatement(sql);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				Map<String, String> map = new HashMap<>();
				map.put("title", rset.getString(1));
				map.put("isbn", rset.getString(2));
				map.put("publisher", rset.getString(3));
				list.add(map);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			bDao.close(pstmt, con);
		}
		return list;
	}

	@Override
	public List<Map<String, Object>> getTitlePublisherPriceAuthroNamePerAuthor() {
		String sql = "select name, title, publisher, price "
				   + "from author a "
				   + "left join book b using(authorno)";
		List<Map<String, Object>> list = new ArrayList<>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		try {
			con = bDao.getConnection();
			pstmt = con.prepareStatement(sql);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				Map<String, Object> map = new HashMap<>();
				map.put("name", rset.getString(1));
				map.put("title", rset.getString(2));
				map.put("publisher", rset.getString(3));
				map.put("price", rset.getInt(4));
				list.add(map);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			bDao.close(pstmt, con);
		}
		return list;
	}

	@Override
	public void printInfo() {
		String sql = "select concat(title,'은 ',  publisher,'에서 출판했다.') from book";
		List<Map<String, Object>> list = new ArrayList<>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		try {
			con = bDao.getConnection();
			pstmt = con.prepareStatement(sql);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				System.out.println(rset.getString(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			bDao.close(pstmt, con);
		}
	}

}
