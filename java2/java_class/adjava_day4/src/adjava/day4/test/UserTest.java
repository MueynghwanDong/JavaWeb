package adjava.day4.test;

import java.sql.SQLException;
import java.util.List;

import adjava.day4.dao.UserDaoImpl;
import adjava.day4.dto.User;
import adjava.day4.util.DBUtil;

public class UserTest {
	public static void main(String[] args) throws SQLException {
		UserTest ut = new UserTest();
//		ut.insertUserTest();
//		ut.updateUserTest();
//		ut.deleteUserTest();
//		ut.selectUserTest();
		ut.selectUserDetailTest();
//		ut.selectAllUsersTest();
	}
	
	DBUtil util = DBUtil.getUtil();
	UserDaoImpl userImpl = UserDaoImpl.getImpl(); 
	public void insertUserTest() throws SQLException {
		int result = 0;
		User user = new User("Moon", "문요한", "123", 500);
		result = userImpl.insertUser(util.getConnection(), user);
		System.out.println(result);
	}
	
	public void updateUserTest() throws SQLException {
		User user = new User("Moon", "문요한", "0125", 4000000);
		int result = userImpl.updateUser(util.getConnection(), user);
		System.out.println(result);
	}
	
	public void deleteUserTest() throws SQLException {
		String userId = "Moon";
		int result = userImpl.deleteUser(util.getConnection(), userId);
		System.out.println(result);
	}
	
	public void selectUserTest() throws SQLException {
		String userId = "hong";
		User user = userImpl.selectUser(util.getConnection(), userId);
		System.out.println(user);
	}
	
	public void selectUserDetailTest() throws SQLException {
		String userId = "hong";
		User user = userImpl.selectUserDetail(util.getConnection(), userId);
		System.out.println(user);
	}
	
	public void selectAllUsersTest() throws SQLException {
		List<User> list = userImpl.selectAllUsers(util.getConnection());
		
		for(User u : list) {
			System.out.println(u);
		}
	}
}