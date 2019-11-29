package adjava_day4.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import adjava_day4.dto.History;
import adjava_day4.util.DBUtil;

public class HistoryDaoImpl implements HistoryDao {

	private static HistoryDaoImpl dao = new HistoryDaoImpl();

	public static HistoryDaoImpl getHistoryDaoImpl() {
		return dao;
	};

	DBUtil util = DBUtil.getDButil();

	@Override
	public int insert(Connection con, History history) throws SQLException {
		PreparedStatement pst = null;
		String sql = "insert into history(userid,type,balance) values(?,?,?)";
		int result = -1;
		try {
			// int i = 1/0;
			pst = con.prepareStatement(sql);
			pst.setString(1, history.getUserid());
			pst.setString(2, history.getType());
			pst.setInt(3, history.getBalance());
			result = pst.executeUpdate();

		} finally {
			util.close(pst);
			// util.close(con);
		}
		return result;
	}

	@Override
	public List<History> getHistoryByUser(Connection con, String userId) throws SQLException {

		List<History> history = new ArrayList<History>();
		PreparedStatement stmt = null;
		ResultSet rset = null;
		String sql = "select * from history where userid = ?";
		try {
			stmt = con.prepareStatement(sql);
			stmt.setString(1, userId);
			rset = stmt.executeQuery();
			while (rset.next()) {

				History h = new History(rset.getInt("history_no"), rset.getString("userid"), rset.getString("type"),
						rset.getInt("balance"), rset.getDate("event_time"));
				history.add(h);

			}
		} finally {
			util.close(rset);
			util.close(stmt);
			// util.close(con);
		}

		return history;
	}

}
