package adjava.day4.service;

import adjava.day4.dto.User;
import adjava.day4.exception.DuplicateException;
import adjava.day4.exception.NegativeBalanceException;
import adjava.day4.exception.UserNotFoundException;

public interface EasyTransService {
	void register(User user) throws DuplicateException;
	void deposit(String userId, int money) throws UserNotFoundException;
	void withdraw(String userId, int money) throws UserNotFoundException, NegativeBalanceException;
	void transfer(String from, String to, int money) throws UserNotFoundException, NegativeBalanceException;
	User showDetail(String userId) throws UserNotFoundException;
}
