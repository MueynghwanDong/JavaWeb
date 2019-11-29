package adjava_day4.service;

import adjava_day4.dto.User;
import adjava_day4.exception.DuplicateException;
import adjava_day4.exception.NegativeBalanceException;
import adjava_day4.exception.UserNotFoundException;

public interface EasyTransService {
	void regist(User user) throws DuplicateException;

	void deposit(String userId, int money) throws UserNotFoundException;

	void withdraw(String userId, int money) throws UserNotFoundException, NegativeBalanceException;

	void transfer(String from, String to, int money) throws NegativeBalanceException, UserNotFoundException;
	
	User showDetail(String userId) throws UserNotFoundException;
	
	User login(String userId, String pass) throws UserNotFoundException;

}
