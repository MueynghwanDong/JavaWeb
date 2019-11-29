package adjava.day4.test;

import adjava.day4.dto.User;
import adjava.day4.exception.DuplicateException;
import adjava.day4.exception.NegativeBalanceException;
import adjava.day4.exception.UserNotFoundException;
import adjava.day4.service.EasyTransService;
import adjava.day4.service.EasyTransServiceImpl;
import adjava.day4.util.DBUtil;

public class ServiceTest {
	public static void main(String[] args) {
		ServiceTest st = new ServiceTest();
		
//		st.selectTest();
//		st.registerTest();
//		st.transTest();
//		st.depositTest();
		st.withdrawTest();
	}
	
	DBUtil util = DBUtil.getUtil();
	EasyTransService service = EasyTransServiceImpl.getImpl();
	
	public void depositTest() {
		try {
			service.deposit("Son", 30000000);
		} catch (UserNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public void withdrawTest() {
		try {
			service.withdraw("Son", 356700);
		} catch (UserNotFoundException e) {
			e.printStackTrace();
		} catch (NegativeBalanceException e) {
			e.printStackTrace();
		}
	}
	
	public void transTest() {
		try {
			service.transfer("Salah", "Moon", 100);
		} catch (UserNotFoundException e) {
			e.printStackTrace();
		} catch (NegativeBalanceException e) {
			e.printStackTrace();
		}
	}
	
	public void selectTest () {
		try {
			User user = service.showDetail("hong");
			System.out.println(user);
		} catch (UserNotFoundException e) {
			e.printStackTrace();
		}
		try {
			User user = service.showDetail("kim");
			System.out.println(user);
		} catch (UserNotFoundException e) {
			System.out.println(e);
		}
	}
	
	public void registerTest() {
		User user = new User("Salah", "모하메드 살라", "1234", 1000);
		try {
			service.register(user);
			System.out.println(user);
		} catch (DuplicateException e) {
			e.printStackTrace();
		}
	}
}
