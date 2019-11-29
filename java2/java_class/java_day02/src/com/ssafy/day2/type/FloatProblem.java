package com.ssafy.day2.type;

import java.math.BigDecimal;

public class FloatProblem {
	public static void main(String[] args) {
		// 실수의 계산은 부정확하다 !!!
				double d1 = 2.0;
				double d2 = 1.1;
				System.out.println( d1 - d2 );		  // 정확한 값을 얻으려면 실수로 계산하지 말고 정수로 계산해야한다.
				
				BigDecimal bd = new BigDecimal(""+d1);			// 문자열로 넣어줘야 된다는데 이유를 잘 모르겠다.
				BigDecimal bd2 = new BigDecimal(""+d2);
				
				System.out.println(bd.subtract(bd2));
	}
}
