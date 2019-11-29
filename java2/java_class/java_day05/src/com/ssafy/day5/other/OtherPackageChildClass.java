package com.ssafy.day5.other;
import com.ssafy.day5.modifier.Parent;

public class OtherPackageChildClass extends Parent{
	
	
	public void method() {
//		this.privateMember = 100;	// 상속을 받더라도 private 멤버변수를 쓸 수 없다.
//		this.defaultMember = 1000;	// 같은 패키지가 아니므로 불가
		this.protectedMember = 10000;	// 자식이면 사용가능
		this.publicMember = 100000;
	}
}
