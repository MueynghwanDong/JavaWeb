package adjava.day4.exception;

public class NegativeBalanceException extends Exception {
	public NegativeBalanceException() {
		super("잔액이 부족합니다.");
	}
}
