package adjava.day4.test;

import java.sql.SQLException;

import adjava.day4.util.DBUtil;

public class UtilTest {
	public static void main(String[] args) throws SQLException {
		DBUtil util = DBUtil.getUtil();
		System.out.println(util.getConnection());
	}
}
