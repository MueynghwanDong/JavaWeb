package com.ssafy.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class BufferText {
	public static void main(String[] args) throws IOException {
		// 소스? 타입? 방향? 기능?
		// 키보드, byte, input, 속도 향상
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // char를 읽는 데에 특화
		br = new BufferedReader(new StringReader(src));
		
		// 줄 단위로 데이터 읽기
		// 공백 기준으로 token 생성
		StringTokenizer tokens = new StringTokenizer(br.readLine());
//		System.out.println(tokens.countTokens());
		
		while(tokens.hasMoreTokens()) {
			String str = tokens.nextToken();
			System.out.print(str + " ");
		}
		System.out.println();
		
		String[] splited = br.readLine().split(" ");
		for(String s : splited) {
			System.out.print(s + " ");
		}
		System.out.println();
	}
	
	static String src = "Make way for Prince Ali\r\n" + 
			"Say hey! It's Prince Ali\r\n" + 
			"Hey! Clear the way in the old bazaar\r\n" + 
			"Hey you! Let us through! It's a brand new star!\r\n" + 
			"Oh come, be the first on your block to meet his eye!\r\n" + 
			"Make way! Here he comes!\r\n" + 
			"Ring bells! Bang the drums!\r\n" + 
			"You're gonna love this guy!\r\n" + 
			"Prince Ali! Fabulous he! Ali Ababwa\r\n" + 
			"Show some respect, Genuflect, down on one knee\r\n" + 
			"Now, try your best to stay calm\r\n" + 
			"Brush up your Friday salaam\r\n" + 
			"Then come and meet his spectacular coterie\r\n" + 
			"Prince Ali, mighty is he, Ali Ababwa\r\n" + 
			"Strong as ten regular men, definitely!\r\n" + 
			"He faced the galloping hordes\r\n" + 
			"A hundred bad guys with swords\r\n" + 
			"Who sent those goons to their lords? Why, Prince Ali\r\n" + 
			"Fellas he's got (seventy-five golden camels) woo! Uh-huh\r\n" + 
			"Now the ladies, what he got? (Purple peacocks, he's got fifty-three)\r\n" + 
			"Uh-huh, uh-huh, uh-huh\r\n" + 
			"When it comes to exotic-type mammals\r\n" + 
			"Everybody help me out!\r\n" + 
			"(He's got a zoo, I'm telling you)\r\n" + 
			"(It's a world-class menagerie)\r\n" + 
			"Prince Ali! Handsome is he, Ali Ababwa\r\n" + 
			"That physique! How can I speak, weak in my knees, yummy boy!\r\n" + 
			"So get on out in that square\r\n" + 
			"Adjust your veil and prepare\r\n" + 
			"To gawk and grovel and stare at Prince Ali\r\n" + 
			"He got some monkeys, a bunch of monkeys\r\n" + 
			"(And to view them he charges no fee)\r\n" + 
			"(He's generous, so generous)\r\n" + 
			"(He's got ten-thousand servants and flunkies)\r\n" + 
			"(Proud to work for him!)\r\n" + 
			"(They bow to his whim love serving him)\r\n" + 
			"(They're just lousy with loyalty to Ali! Prince Ali!)\r\n" + 
			"Prince A- we're waiting for you!\r\n" + 
			"We're not going 'til you go\r\n" + 
			"You can do it!\r\n" + 
			"There it is!\r\n" + 
			"Prince Ali, amorous he! Ali Ababwa\r\n" + 
			"Heard your princess was hot! Where is she?\r\n" + 
			"And that, good people, is why\r\n" + 
			"he got all cute and dropped by\r\n" + 
			"With (sixty elephants, llamas galore) for real?\r\n" + 
			"(With his bears and lions, a brass band and more) what?\r\n" + 
			"(With his forty fakirs, his cooks, his bakers)\r\n" + 
			"(His birds that warble on key)\r\n" + 
			"Make way for Prince Ali!";
}
