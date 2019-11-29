package day4.work;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BookDAO {
	private static BookDAO dao = new BookDAO();

	public static BookDAO getDao() {
		return dao;
	}

	private BookDAO() {
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

	public void insertBook(Book book) {
		String sql = "insert into book (isbn, title, author, publisher, price, description) values(?,?,?,?,?,?)";
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, book.getIsbn());
			pstmt.setString(2, book.getTitle());
			//pstmt.setString(3, book.getAuthor());
			pstmt.setString(4, book.getPublisher());
			pstmt.setInt(5, book.getPrice());
			pstmt.setString(6, book.getDescription());
			int result = pstmt.executeUpdate();
			System.out.println("insert 결과: " + result);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt, con);
		}
	}

	public void updateBook(Book book) {
		String sql = "update book set title=?, author=?, publisher=?, price=?, description=? where isbn=?";
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = getConnection();
			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, book.getTitle());
			//pstmt.setString(2, book.getAuthor());
			pstmt.setString(3, book.getPublisher());
			pstmt.setInt(4, book.getPrice());
			pstmt.setString(5, book.getDescription());
			pstmt.setString(6, book.getIsbn());
			int result = pstmt.executeUpdate();
			System.out.println("update 결과: " + result);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt, con);
		}
	}

	public void deleteBook(String isbn) {
		String sql = "delete from book where isbn=?";
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

	public Book findBook(String isbn) {
		Book selected = null;
		String sql = "select * from book where isbn=?";
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		try {
			con = getConnection();
			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, isbn);
			rset = pstmt.executeQuery();
			if (rset.next()) {
				selected = new Book();
				selected.setTitle(rset.getString("title"));
				//selected.setAuthor(rset.getString("author"));
				selected.setPublisher(rset.getString("publisher"));
				selected.setPrice(rset.getInt("price"));
				selected.setDescription(rset.getString("description"));
				selected.setIsbn(rset.getString("isbn"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset, pstmt, con);
		}
		return selected;
	}

	public List<Book> listBooks() {
		List<Book> selected = new ArrayList<>();
		String sql = "select * from book";
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		try {
			con = getConnection();
			pstmt = con.prepareStatement(sql);
			rset = pstmt.executeQuery();
			while (rset.next()) {
				Book book = new Book();
				book.setTitle(rset.getString("title"));
				//book.setAuthor(rset.getString("author"));
				book.setPublisher(rset.getString("publisher"));
				book.setPrice(rset.getInt("price"));
				book.setDescription(rset.getString("description"));
				book.setIsbn(rset.getString("isbn"));
				selected.add(book);
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
		String sql = "select count(*) from book";
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
