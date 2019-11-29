package junittest;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class CalcTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("모든 테케 시작 전 -- 전처리 작업, 무거운리소스 생성");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("모든 테케 종료 후 - 후처리 작업, 리소스 반납 등....");
	}
	Calc c;
	@Before
	public void setUp() throws Exception {
		//System.out.println("각각의 테스트 케이스 마다 시작 전 - 테케 리소스 초기화");
		c = Calc.getCalc(); 
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("각각의 테스트 케이스 마다 종료 후 - 테케 리소스 정리");
	}

	@Test
	public void test() {
		// System.out.println("테스트1");
		Calc c = Calc.getCalc();
		assertThat(c, is(notNullValue()));
	}

	@Test
	public void test2() {
		Calc c = null;
		
		assertThat(c, is(nullValue()));
	}
	@Test
	public void test3() {
		int a = 10;
		int b = 20;
		int result = c.add(a, b);
		assertThat(result, is(a+b));
		
		result = c.add(100, -299);
		assertThat(result, is(100-299));
		
	}
	@Test
	public void test4() {
		int a = 10;
		int b= 5;
		int result = c.divide(a, b);
		assertThat(result, is(10/5));
		
	}
	@Test(expected = ArithmeticException.class)
	public void test5() {
		int a = 10;
		int b= 0;
		int result = c.divide(a, b);
		assertThat(result, is(10/0));
		
	}
}
