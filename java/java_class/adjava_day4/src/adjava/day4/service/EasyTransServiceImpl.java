package adjava.day4.service;

import java.sql.Connection;
import java.sql.SQLException;

import adjava.day4.dao.HistoryDao;
import adjava.day4.dao.HistoryDaoImpl;
import adjava.day4.dao.UserDao;
import adjava.day4.dao.UserDaoImpl;
import adjava.day4.dto.History;
import adjava.day4.dto.User;
import adjava.day4.exception.DuplicateException;
import adjava.day4.exception.NegativeBalanceException;
import adjava.day4.exception.UserNotFoundException;
import adjava.day4.util.DBUtil;

public class EasyTransServiceImpl implements EasyTransService {
	// Singleton design pattern
	private static EasyTransServiceImpl impl = new EasyTransServiceImpl();

	public static EasyTransServiceImpl getImpl() {
		return impl;
	}

	private EasyTransServiceImpl() {
	}

	DBUtil util = DBUtil.getUtil();
	UserDao uDao = UserDaoImpl.getImpl();
	HistoryDao hDao = HistoryDaoImpl.getImpl();

	@Override // insert: dml --> transaction 처리 필요
	public void register(User user) throws DuplicateException {
		Connection con = null;

		try {
			con = util.getConnection();
			con.setAutoCommit(false); // TX 시작지점 (TX: 트랜잭션, Transaction)
			int insertResult = uDao.insertUser(con, user);
			con.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			util.rollback(con); // 실패 --> DB 원복
			throw new DuplicateException();
		} finally {
			util.close(con); // 자원반납
		}
	}

	@Override
	public void deposit(String userId, int money) throws UserNotFoundException {
		Connection con = null;

		try {
			con = util.getConnection();
			User user = uDao.selectUser(con, userId);

			if (user == null) {
				throw new UserNotFoundException(userId);
			}
			
			con.setAutoCommit(false);
			
			user.setBalance(user.getBalance() + money);
			uDao.updateUser(con, user);
			hDao.insert(con, new History(userId, "입금", user.getBalance()));
			
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
			User user = uDao.selectUser(con, userId);

			if (user == null) {
				throw new UserNotFoundException(userId);
			}
			if(user.getBalance() < money) {
				throw new NegativeBalanceException();
			}
			con.setAutoCommit(false);
			
			user.setBalance(user.getBalance()-money);
			uDao.updateUser(con, user);
			hDao.insert(con, new History(userId, "출금", user.getBalance()));
			
			con.commit();

		} catch (SQLException e) {
			e.printStackTrace();
			util.rollback(con);
		} finally {
			util.close(con);
		}
	}

	@Override
	public void transfer(String from, String to, int money) throws UserNotFoundException, NegativeBalanceException {
		Connection con = null;

		try {
			con = util.getConnection();
			// 각각 아이디에 해당하는 사용자 가져오기.
			User fromUser = uDao.selectUser(con, from);
			User toUser = uDao.selectUser(con, to);

			if (fromUser == null) {
				throw new UserNotFoundException(from);
			} else if (toUser == null) {
				throw new UserNotFoundException(to);
			}

			if (fromUser.getBalance() < money) {
				throw new NegativeBalanceException();
			}
			// 여기까지 오면 충분히 이체가능한 상황
			con.setAutoCommit(false);

			fromUser.setBalance(fromUser.getBalance() - money);
			uDao.updateUser(con, fromUser);
			toUser.setBalance(toUser.getBalance() + money);
			uDao.updateUser(con, toUser);
			hDao.insert(con, new History(from, "출금", fromUser.getBalance()));
			hDao.insert(con, new History(to, "입금", toUser.getBalance()));

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
		// connection 획득
		Connection con = null;

		User selected = null;
		try {
			con = util.getConnection();
			selected = uDao.selectUserDetail(con, userId);

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

}
