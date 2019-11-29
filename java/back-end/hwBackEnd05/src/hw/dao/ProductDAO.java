package hw.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import hw.dto.Product;

public class ProductDAO {
	private static ProductDAO dao = new ProductDAO();
	
	public static ProductDAO getInstance() {
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
		String url = "jdbc:mysql://localhost:3306/workshop?serverTimezone=UTC";
		String user = "root";
		String pass = "ssafy";
		return DriverManager.getConnection(url, user, pass);
	}
	
	public void AddProduct(Product product) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = getConnection();
			String sql = "insert into productlist values (?, ?, ?, ?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, product.getNumber());
			pstmt.setString(2, product.getName());
			pstmt.setInt(3, product.getPrice());
			pstmt.setString(4, product.getInfo());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public List<Product> SelectList() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = getConnection();
			String sql = "select * from productlist";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			List<Product> products = new ArrayList<Product>();
			
			while(rs.next()) {
				Product product = new Product(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getString(4));
				products.add(product);
			}
			
			return products;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pstmt.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return null;
	}
	
	public void DeleteProduct(String number) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = getConnection();
			String sql = "delete from productlist where number = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, number);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public Product sellist(String no) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = getConnection();
			String sql = "select * from productlist where name = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, no);
			rs = pstmt.executeQuery();
			Product pro = null;
			
			if(rs.next()) {
				pro= new Product(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getString(4));

			}
			
			return pro;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pstmt.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return null;
	}
	
	
	public void UpdateProduct(Product product, String number) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = getConnection();
			String sql = "update productlist set number = ?, name = ?, price = ?, info = ? where number = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, product.getNumber());
			pstmt.setString(2, product.getName());
			pstmt.setInt(3, product.getPrice());
			pstmt.setString(4, product.getInfo());
			pstmt.setString(5, number);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
