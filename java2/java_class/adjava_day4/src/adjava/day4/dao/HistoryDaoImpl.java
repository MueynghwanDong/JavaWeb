package adjava.day4.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import adjava.day4.dto.History;
import adjava.day4.util.DBUtil;

public class HistoryDaoImpl implements HistoryDao {
	private static HistoryDaoImpl impl = new HistoryDaoImpl();
	private HistoryDaoImpl() {}
	public static HistoryDaoImpl getImpl() {
		return impl;
	}
	DBUtil util = DBUtil.getUtil();
	
	@Override
	public int insert(Connection con, History history) throws SQLException {
		String sql = "Insert into history(userid, type, balance) values(?, ?, ?)";
		PreparedStatement ps = null;
		int result = -1;
		
		try {
//			int i = 1/0;
			ps = con.prepareStatement(sql);
			
			ps.setString(1, history.getUserId());
			ps.setString(2, history.getType());
			ps.setInt(3, history.getBalacne());
			result = ps.executeUpdate();
		} finally {
			util.close(ps);
		}

		return result;
	}
	

	@Override
	public List<History> getHistoryByUser(Connection con, String userId) throws SQLException {
		ArrayList<History> list = new ArrayList<>();
		String sql = "Select * from history where userid=?";

		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, userId);

			rs = ps.executeQuery();

			while (rs.next()) {
				History h = new History(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getDate(5));
				list.add(h);
			}
		} finally {
			util.close(rs);
			util.close(ps);
		}
		
		return list;
	}
	
	
	
}