package adjava.day4.exception;

public class DuplicateException extends Exception {
	public DuplicateException() {
		super("이미 사용중인 아이디입니다.");
	}
}