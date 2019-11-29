package com.ssafy.work;

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

	private BookDAO() {

	}

	public static BookDAO getDao() {
		return dao;
	}

	public Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");

		// DB 접속하기
		String url = "jdbc:mysql://localhost:3306/jdbc?serverTimezone=UTC";
		String user = "root";
		String pass = "ssafy";

		return DriverManager.getConnection(url, user, pass);
	}

	public void close(Connection connection) {
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public void close(Statement statement) {
		if (statement != null) {
			try {
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public void close(ResultSet resultSet) {
		if (resultSet != null) {
			try {
				resultSet.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public void insertBook(Book book) {
		String sql = "Insert into book(isbn, title, author, publisher, price, description) "
				+ "values(?, ?, ?, ?, ?, ?) ";

		Connection con = null;
		PreparedStatement ps = null;

		try {
			con = getConnection();
			ps = con.prepareStatement(sql);

			ps.setString(1, book.getIsbn());
			ps.setString(2, book.getTitle());
			ps.setString(3, book.getAuthor());
			ps.setString(4, book.getPublisher());
			ps.setInt(5, book.getPrice());
			ps.setString(6, book.getDesc());

			int updated = ps.executeUpdate();
			System.out.println(updated + "행이 영향을 받았습니다.");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(ps);
			close(con);
		}
	}

	public void updateBook(Book book) {
		String sql = "Update book set price = ? where isbn = ?";

		Connection con = null;
		PreparedStatement ps = null;

		try {
			con = getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, book.getPrice());
			ps.setString(2, book.getIsbn());

			int updated = ps.executeUpdate();
			System.out.println(updated + "행이 영향을 받았습니다.");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(ps);
			close(con);
		}
	}

	public void deleteBook(Book book) {
		String sql = "Delete from book where isbn = ?";

		Connection con = null;
		PreparedStatement ps = null;

		try {
			con = getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, book.getIsbn());

			int updated = ps.executeUpdate();
			System.out.println(updated + "행이 영향을 받았습니다.");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(ps);
			close(con);
		}
	}

	public Book findBook(String isbn) {
		Book book = new Book();
		String sql = "Select * from book where isbn = ?";

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			con = getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, isbn);
			rs = ps.executeQuery();

			if (rs.next()) {
				book.setIsbn(rs.getString(1));
				book.setTitle(rs.getString(2));
				book.setAuthor(rs.getString(3));
				book.setPublisher(rs.getString(4));
				book.setPrice(rs.getInt(5));
				book.setDesc(rs.getString(6));
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(ps);
			close(con);
		}

		return book;
	}

	public List<Book> listBooks() {
		ArrayList<Book> list = new ArrayList<>();
		String sql = "Select * from book";

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			con = getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {
				Book book = new Book();
				book.setIsbn(rs.getString(1));
				book.setTitle(rs.getString(2));
				book.setAuthor(rs.getString(3));
				book.setPublisher(rs.getString(4));
				book.setPrice(rs.getInt(5));
				book.setDesc(rs.getString(6));

				list.add(book);
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(ps);
			close(con);
		}

		return list;
	}
	
	public int count() {
		String sql = "Select count(*) from book";
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		int num = 0;
		
		try {
			con = getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next())
				num = rs.getInt(1);
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(ps);
			close(con);
		}
		return num;
	}

}
