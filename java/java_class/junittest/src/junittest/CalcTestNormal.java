package junittest;

public class CalcTestNormal {

	public static void main(String[] args) {
		Calc c = Calc.getCalc();
		System.out.println(c);
		
		int a = 100; int b = 200;
		int result = c.add(a, b);
		System.out.println(result);
		
	}
}
