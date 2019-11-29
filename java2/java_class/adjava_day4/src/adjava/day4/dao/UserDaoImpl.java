package adjava.day4.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import adjava.day4.dto.History;
import adjava.day4.dto.User;
import adjava.day4.util.DBUtil;

public class UserDaoImpl implements UserDao {
	private static UserDaoImpl impl = new UserDaoImpl();

	private UserDaoImpl() {
	}

	public static UserDaoImpl getImpl() {
		return impl;
	}

	DBUtil util = DBUtil.getUtil();

	@Override
	public int insertUser(Connection con, User user) throws SQLException {
		String sql = "Insert into user values(?, ?, ?, ?)";
		PreparedStatement ps = null;
		int result = -1;

		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, user.getUserid());
			ps.setString(2, user.getName());
			ps.setString(3, user.getPass());
			ps.setInt(4, user.getBalance());

			result = ps.executeUpdate();
		} finally {
			util.close(ps);
		}

		return result;
	}

	@Override
	public int updateUser(Connection con, User user) throws SQLException {
		String sql = "Update user set name=?, pass=?, balance=? where userid=?";
		PreparedStatement ps = null;

		int result = -1;

		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, user.getName());
			ps.setString(2, user.getPass());
			ps.setInt(3, user.getBalance());
			ps.setString(4, user.getUserid());

			result = ps.executeUpdate();
		} finally {
			util.close(ps);
		}

		return result;
	}

	@Override
	public int deleteUser(Connection con, String userId) throws SQLException {
		String sql = "Delete from user where userid=?";
		PreparedStatement ps = null;

		int result = -1;

		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, userId);

			result = ps.executeUpdate();
		} finally {
			util.close(ps);
		}

		return result;
	}

	@Override
	public User selectUser(Connection con, String userId) throws SQLException {
		String sql = "Select * from user where userid=?";
		PreparedStatement ps = null;
		ResultSet rs = null;
		User user = new User();
		
		try {
			ps = con.prepareStatement(sql);
			
			ps.setString(1, userId);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				user.setUserid(rs.getString("userid"));
				user.setName(rs.getString("name"));
				user.setPass(rs.getString("pass"));
				user.setBalance(rs.getInt("balance"));
			}
		} finally {
			util.close(rs);
			util.close(ps);
		}
		
		return user;
	}

	@Override
	public User selectUserDetail(Connection con, String userId) throws SQLException {
		String sql = "Select * from user join history using(userid) where userid=?";
		PreparedStatement ps = null;
		ResultSet rs = null;
		User user = null;
		
		try {
			ps = con.prepareStatement(sql);
			
			ps.setString(1, userId);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				user = new User();
				user.setUserid(rs.getString("userid"));
				user.setName(rs.getString("name"));
				user.setPass(rs.getString("pass"));
				user.setBalance(rs.getInt("balance"));
				
				do {
					History h = new History();
					h.setHistoryNo(rs.getInt("history_no"));
					h.setUserId(rs.getString("userid"));
					h.setType(rs.getString("type"));
					h.setBalacne(rs.getInt("balance"));
					h.setEventTime(rs.getDate("event_time"));
					user.getHistory().add(h);
				} while(rs.next());
			}
		} finally {
			util.close(rs);
			util.close(ps);
		}
		
		return user;
	}

	@Override
	public List<User> selectAllUsers(Connection con) throws SQLException {
		String sql = "Select * from user";
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<User> list = new ArrayList<>();
		
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				User user = new User();
				user.setUserid(rs.getString("userid"));
				user.setName(rs.getString("name"));
				user.setPass(rs.getString("pass"));
				user.setBalance(rs.getInt("balance"));
				
				list.add(user);
			}
		} finally {
			util.close(rs);;
			util.close(ps);
		}
		
		return list;
	}

}
