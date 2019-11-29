package adjava.day4.util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DBUtil {
	// singleton으로 작성한다.
	private static DBUtil util = new DBUtil();

	private String name;
	private String url;
	private String pass;

	public static DBUtil getUtil() {
		return util;
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

	private void initProp() throws IOException {
		Properties props = new Properties();
		props.load(DBUtil.class.getResourceAsStream("dbconfig.properties"));
		this.name = props.getProperty("user");
		this.url = props.getProperty("url");
		this.pass = props.getProperty("pass");
	}

	// connection 획득
	public Connection getConnection() throws SQLException {
		return DriverManager.getConnection(url, name, pass);
	}

	// resultset, statement, connection을 각각 닫는 메서드 작성
	public void close(ResultSet rset) {
		if (rset != null) {
			try {
				rset.close();
			} catch (SQLException e) {
			}
		}
	}

	public void close(Statement stmt) {
		if (stmt != null) {
			try {
				stmt.close();
			} catch (SQLException e) {
			}
		}
	}

	public void close(Connection con) {
		if (con != null) {
			try {
				con.close();
			} catch (SQLException e) {
			}
		}
	}

	// connection을 rollback하는 메서드 작성
	public void rollback(Connection con) {
		if (con != null) {
			try {
				con.rollback();
			} catch (SQLException e) {
			}
		}
	}

}
