package adjava.day4.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import adjava.day4.dto.User;

public interface UserDao {
	int insertUser(Connection con, User user) throws SQLException;
	int updateUser(Connection con, User user) throws SQLException;
	int deleteUser(Connection con, String userId) throws SQLException;
	/**
	 * 단순히 user 테이블 자료만 조회
	 * @param userId
	 * @return
	 * @throws SQLException
	 */
	User selectUser(Connection con, String userId) throws SQLException;
	/**
	 * history와 join해서 활동 이력까지 조회
	 * @param userId
	 * @return
	 * @throws SQLException
	 */
	User selectUserDetail(Connection con, String userId) throws SQLException;
	/**
	 * 모든 유저 조회 후 반환
	 * @return
	 * @throws SQLException
	 */
	List<User> selectAllUsers(Connection con) throws SQLException;
}