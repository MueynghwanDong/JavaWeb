package adjava_day4.service;

import java.sql.Connection;
import java.sql.SQLException;

import adjava_day4.dao.HistoryDao;
import adjava_day4.dao.HistoryDaoImpl;
import adjava_day4.dao.UserDao;
import adjava_day4.dao.UserDaoImpl;
import adjava_day4.dto.History;
import adjava_day4.dto.User;
import adjava_day4.exception.DuplicateException;
import adjava_day4.exception.NegativeBalanceException;
import adjava_day4.exception.UserNotFoundException;
import adjava_day4.util.DBUtil;

public class EasyTransServiceImpl implements EasyTransService {

	private static EasyTransServiceImpl impl = new EasyTransServiceImpl();

	public static EasyTransServiceImpl getService() {
		return impl;
	}

	DBUtil util = DBUtil.getDButil();
	UserDao udao = UserDaoImpl.getUserDaoImpl();
	HistoryDao hdao = HistoryDaoImpl.getHistoryDaoImpl();

	private EasyTransServiceImpl() {
	}

	@Override
	public void regist(User user) throws DuplicateException {
		Connection con = null;
		try {
			con = util.getConnection();
			con.setAutoCommit(false); // 트랜잭션 시작점
			int insertResult = udao.insertUser(con, user);
			System.out.println(insertResult + "개가 저장됨...");
			con.commit();
		} catch (SQLException e) {
			util.rollback(con);
			e.printStackTrace();
			throw new DuplicateException();
		} finally {
			util.close(con);
		}
	}

	@Override
	public void deposit(String userId, int money) throws UserNotFoundException {
		Connection con = null;
		try {
			con = util.getConnection();
			User user = udao.selectUser(con, userId);
			if (user == null) {
				throw new UserNotFoundException(userId);
			}
			con.setAutoCommit(false);
			user.setBalance(user.getBalance() + money);
			udao.updateUser(con, user);
			hdao.insert(con, new History(userId, "입금", user.getBalance()));
			con.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			util.rollback(con);
		} finally {
			util.close(con);
		}

	}

	@Override
	public void withdraw(String userId, int money) throws UserNotFoundException, NegativeBalanceException {
		Connection con = null;
		try {
			con = util.getConnection();
			User user = udao.selectUser(con, userId);
			if (user == null) {
				throw new UserNotFoundException(userId);
			}
			if (user.getBalance() < money) {
				throw new NegativeBalanceException();
			}
			con.setAutoCommit(false);
			user.setBalance(user.getBalance() - money);
			udao.updateUser(con, user);
			hdao.insert(con, new History(userId, "출금", user.getBalance()));
			con.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			util.rollback(con);
		} finally {
			util.close(con);
		}

	}

	@Override
	public void transfer(String from, String to, int money) throws NegativeBalanceException, UserNotFoundException {

		Connection con = null;
		try {
			con = util.getConnection();
			User fromUser = udao.selectUser(con, from);
			User toUser = udao.selectUser(con, to);
			if (fromUser == null) {
				throw new UserNotFoundException(from);
			} else if (toUser == null) {
				throw new UserNotFoundException(from);
			}
			if (fromUser.getBalance() < money) {
				throw new NegativeBalanceException();
			}
			con.setAutoCommit(false);
			fromUser.setBalance(fromUser.getBalance() - money);
			udao.updateUser(con, fromUser);
			toUser.setBalance(toUser.getBalance() + money);
			udao.updateUser(con, toUser);

			hdao.insert(con, new History(from, "출금", fromUser.getBalance()));
			hdao.insert(con, new History(to, "입금", toUser.getBalance()));
			con.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			util.rollback(con);
		} finally {
			util.close(con);
		}
	}

	@Override
	public User showDetail(String userId) throws UserNotFoundException {
		User selected = null;
		Connection con = null;
		try {
			con = util.getConnection();
			selected = udao.selectUserDetail(con, userId);
			if (selected == null) {
				throw new UserNotFoundException(userId);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			util.close(con);
		}
		return selected;
	}

	@Override
	public User login(String userId, String pass) throws UserNotFoundException {
		User selected = null;
		Connection con = null;
		try {
			con = util.getConnection();
			selected = udao.selectUser(con, userId);
			if (selected == null) {
				throw new UserNotFoundException(userId);
			} else {
				if (!selected.getPass().equals(pass)) {
					throw new UserNotFoundException(userId);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			util.close(con);
		}
		return selected;
	}

}
