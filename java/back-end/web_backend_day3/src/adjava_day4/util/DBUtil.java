package adjava_day4.util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DBUtil {

	// singleton design pattern 적용
	private static DBUtil dbutil = new DBUtil();
	String url;
	String user;
	String pass;

	private void initProp() throws IOException {
		Properties props = new Properties();
		props.load(DBUtil.class.getResourceAsStream("dbconfig.properties"));
		this.url = props.getProperty("url");
		this.user = props.getProperty("user");
		this.pass = props.getProperty("pass");
	}

	private DBUtil() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			initProp();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static DBUtil getDButil() {
		return dbutil;
	}

	// connection 획득

	public Connection getConnection() throws SQLException {

		return DriverManager.getConnection(url, user, pass);
	}

	// close 메서드
	public void close(ResultSet rset) {
		if (rset != null) {
			try {
				rset.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public void close(Statement stmt) {
		if (stmt != null) {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public void close(Connection con) {
		if (con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	// rollback 메서드
	public void rollback(Connection con) {
		if (con != null) {
			try {
				con.rollback();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
