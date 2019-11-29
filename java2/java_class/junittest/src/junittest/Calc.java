package junittest;

public class Calc {

	private static Calc calc = new Calc();

	public static Calc getCalc() {
		return calc;
	}

	private Calc() {
	}

	public int add(int a, int b) {
		return a + b;
	}
	public int divide (int a, int b) {
		return a/b;
	}

}
