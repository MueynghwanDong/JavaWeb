package adjava_day4.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import adjava_day4.dto.History;
import adjava_day4.dto.User;
import adjava_day4.util.DBUtil;

public class UserDaoImpl implements UserDao {

	private static UserDaoImpl dao = new UserDaoImpl();

	public static UserDaoImpl getUserDaoImpl() {
		return dao;
	};

	DBUtil util = DBUtil.getDButil();

	@Override
	public int insertUser(Connection con, User user) throws SQLException {
		PreparedStatement pst = null;
		String sql = "insert into user(userid,name,pass) values(?,?,?)";
		int result = -1;
		try {
			pst = con.prepareStatement(sql);
			pst.setString(1, user.getUserid());
			pst.setString(2, user.getName());
			pst.setString(3, user.getPass());
			result = pst.executeUpdate();
		} finally {
			util.close(pst);
		}
		return result;
	}

	@Override
	public int updateUser(Connection con, User user) throws SQLException {
		PreparedStatement pst = null;
		String sql = "update user set name = ?, pass = ?, balance = ? where userid = ?";
		int result = -1;
		try {
			pst = con.prepareStatement(sql);
			pst.setString(1, user.getName());
			pst.setString(2, user.getPass());
			pst.setInt(3, user.getBalance());
			pst.setString(4, user.getUserid());
			result = pst.executeUpdate();
		} finally {
			util.close(pst);
		}
		return result;
	}

	@Override
	public int deleteUser(Connection con, String userId) throws SQLException {
		PreparedStatement pst = null;
		String sql = "delete from user where userid= ?";
		int result = -1;
		try {
			pst = con.prepareStatement(sql);
			pst.setString(1, userId);
		} finally {
			util.close(pst);
		}
		return result;
	}

	@Override
	public User selectUser(Connection con, String userId) throws SQLException {
		PreparedStatement pst = null;
		ResultSet rset = null;
		String sql = "select * from user where userid = ?";
		User user = null;
		try {
			pst = con.prepareStatement(sql);
			pst.setString(1, userId);
			rset = pst.executeQuery();
			if (rset.next()) {
				user = new User(rset.getString("userid"), rset.getString("name"), rset.getString("pass"),
						rset.getInt("balance"));

			}
		} finally {
			util.close(rset);
			util.close(pst);
		}
		return user;
	}

	@Override
	public User selectUserDetail(Connection con, String userId) throws SQLException {
		PreparedStatement pst = null;
		ResultSet rset = null;
		String sql = "select u.*, h.* from user u left join history h using(userid) where userid = ?";
		User user = null;
		try {
			pst = con.prepareStatement(sql);
			pst.setString(1, userId);
			rset = pst.executeQuery();
			if (rset.next()) {
				// user 생성
				// History history = new
				// History(rset.getInt("history_no"),rset.getString("userid"),rset.getString("type"),rset.getInt("balance"),rset.getDate("event_time"));
				user = new User();
				user.setUserid(rset.getString("userid"));
				user.setName(rset.getString("name"));
				user.setPass(rset.getString("pass"));
				user.setBalance(rset.getInt("balance"));
				do {
					History history = new History();
					history.setHistory_num(rset.getInt("history_no"));
					history.setUserid(rset.getString("userid"));
					history.settype(rset.getString("type"));
					history.setBalance(rset.getInt("balance"));
					history.setEvent_time(rset.getDate("event_time"));
					user.getHistory().add(history);
				} while (rset.next());

			}
		} finally {
			util.close(rset);
			util.close(pst);
		}
		return user;
	}

	@Override
	public List<User> selectAllUsers(Connection con) throws SQLException {
		List<User> list = new ArrayList<User>();
		PreparedStatement pst = null;
		ResultSet rset = null;
		String sql = "select * from user";
		try {
			pst = con.prepareStatement(sql);
			rset = pst.executeQuery();
			while (rset.next()) {
				User user = new User(rset.getString("userid"), rset.getString("name"), rset.getString("pass"),
						rset.getInt("balance"));
				list.add(user);
			}
		} finally {
			util.close(rset);
			util.close(pst);
		}
		return list;
	}

}
