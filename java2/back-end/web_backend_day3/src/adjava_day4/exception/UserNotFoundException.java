package adjava_day4.exception;

public class UserNotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UserNotFoundException(String userid) {
		super(userid + "가 없습니다.");
	}
}
