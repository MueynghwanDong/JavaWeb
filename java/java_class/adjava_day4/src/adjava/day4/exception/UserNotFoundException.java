package adjava.day4.exception;

public class UserNotFoundException extends Exception{
	public UserNotFoundException(String userId) {
		super(userId + "가 없습니다.");
	}
}
