package hw.dao;

import java.awt.print.Book;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import hw.dto.Product;

public class ProductDAO {
	private static ProductDAO dao = new ProductDAO();

	public static ProductDAO getDao() {
		return dao;
	}

	private ProductDAO() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public Connection getConnection() throws SQLException {
		// DB 접속하기
		String url = "jdbc:mysql://localhost:3306/workshop?serverTimezone=UTC";
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

	// Connection 과 Statement를 종료시키는 메서드 : 얻을 때의 역순으로 close
	public void close(Statement stmt, Connection con) { // method overloading
		if (stmt != null) {
			try {
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
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
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		close(stmt, con);
	}

	public void insertBook(Product pro) {
		String sql = "insert into product (id, name, price, description) values(?,?,?,?)";
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, pro.getid());
			pstmt.setString(2, pro.getName());
			pstmt.setInt(3, pro.getPrice());
			pstmt.setString(4, pro.getdescription());
			int result = pstmt.executeUpdate();
			System.out.println("insert 결과: " + result);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt, con);
		}
	}

	public void updateProduct(Product pro) {
		String sql = "update product set id=?, name=?, price=?, description=? where id=?";
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = getConnection();
			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, pro.getid());
			pstmt.setString(2, pro.getName());
			pstmt.setInt(3, pro.getPrice());
			pstmt.setString(4, pro.getdescription());
			pstmt.setString(5, pro.getid());
			int result = pstmt.executeUpdate();
			System.out.println("update 결과: " + result);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt, con);
		}
	}

	public void deleteProduct(String isbn) {
		String sql = "delete from product where id=?";
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = getConnection();
			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, isbn);
			int result = pstmt.executeUpdate();
			System.out.println("삭제 결과: " + result);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt, con);
		}
	}

//	public List<Book> findBook(String by, String keyword) {
//		Book selected = null;
//		String sql = null;
//		if (by.equals("title")) {
//			sql = "select * from book where title=?";
//		} else if (by.equals("publisher")) {
//			sql = "select * from book where publisher=?";
//		} else if (by.equals("price")) {
//			sql = "select * from book where price < ?";
//		}
//		Connection con = null;
//		PreparedStatement pstmt = null;
//		ResultSet rset = null;
//		List<Book> books  = new ArrayList<>();
//		try {
//			con = getConnection();
//			pstmt = con.prepareStatement(sql);
//			if (by.equals("price")) { // price는 숫자기준
//				pstmt.setInt(1, Integer.parseInt(keyword));
//			} else { // 나머지는 문자열
//				pstmt.setString(1, keyword);
//			}
//			rset = pstmt.executeQuery();
//			while (rset.next()) {
//				selected = new Book();
//				selected.setTitle(rset.getString("title"));
//				// selected.setAuthor(rset.getString("author"));
//				selected.setPublisher(rset.getString("publisher"));
//				selected.setPrice(rset.getInt("price"));
//				selected.setDescription(rset.getString("description"));
//				selected.setIsbn(rset.getString("isbn"));
//				books.add(selected);
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			close(rset, pstmt, con);
//		}
//		return books;
//	}

	public List<Product> listProducts() {
		List<Product> selected = new ArrayList<>();
		String sql = "select * from product";
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		try {
			con = getConnection();
			pstmt = con.prepareStatement(sql);
			rset = pstmt.executeQuery();
			while (rset.next()) {
				Product pro = new Product();
				pro.setName(rset.getString("name"));
				pro.setPrice(rset.getInt("price"));
				pro.setdescription(rset.getString("description"));
				pro.setid(rset.getString("id"));
				selected.add(pro);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt, con);
		}
		return selected;
	}

	public int count() {
		int count = 0;
		String sql = "select count(*) from product";
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		try {
			con = getConnection();
			pstmt = con.prepareStatement(sql);
			rset = pstmt.executeQuery();
			if (rset.next()) {
				count = rset.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset, pstmt, con);
		}
		return count;
	}
}
