package com.ssafy.day5.other;

import com.ssafy.day5.modifier.Parent;

public class OhterPackageSomeClass {
	public void method() {
		Parent p = new Parent();
		
//		p.privateMember = 100;	
//		p.defaultMember = 1000;
//		p.protectedMember = 10000;
		p.publicMember = 100000;
	}
}
