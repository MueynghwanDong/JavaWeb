package adjava_day4.exception;

public class NegativeBalanceException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NegativeBalanceException() {
		super("잔액이 부족합니다.");
	}
}
