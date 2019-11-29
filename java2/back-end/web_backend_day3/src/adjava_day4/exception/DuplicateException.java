package adjava_day4.exception;

public class DuplicateException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DuplicateException() {
		super("이미사용중인 아이디입니다..");
	}

}
