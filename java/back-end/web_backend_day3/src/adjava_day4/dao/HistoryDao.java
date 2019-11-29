package adjava_day4.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import adjava_day4.dto.History;

public interface HistoryDao {
	/**
	 * 전달 받은 history 객체를 저장한다.
	 * 
	 * @param con
	 * @param history
	 * @return 영향 받은 행의 개수를 리턴
	 * @throws SQLException
	 */

	int insert(Connection con, History history) throws SQLException;

	/**
	 * userid 사용자의 활동 내역을 리턴
	 * 
	 * @param con
	 * @param userId
	 * @return
	 * @throws SQLException
	 */
	List<History> getHistoryByUser(Connection con, String userId) throws SQLException;
}
