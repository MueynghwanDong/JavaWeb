package com.ssafy.day11.stream;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class UseStream {
	static List<String> list;
	
	public static void main(String[] args) throws IOException {
		list = new ArrayList<>();
		// 강남스타일.txt 를 읽어서 단어별로 리스트에 추가하세요.
		File file = new File("./bin/share/data/강남스타일.txt");
		BufferedReader br = new BufferedReader(new FileReader(file));
		String line = null;
		
		while( (line = br.readLine())!= null ) {
//			StringTokenizer st = new StringTokenizer(line, " ");
//			
//			while(st.hasMoreTokens()) {
//				list.add(st.nextToken());
//			}
			
			list.addAll(Arrays.stream(line.split(" ")).collect(Collectors.toList()));
		}
		
		System.out.println(list.size());
//		method1();
//		method2();
		method3();
		method4();
	}
	
	// list에 있는 요소들의 중복을 제거하고 길이가 5 이상인 요소들을 출력하시오.
	// 스트림 처리는 원본에는 영향을 주지 않아요 :D
	private static void method1() {
		// 1. stream 생성
		// 2. 중간 처리
		// 3. 최종 처리
		list.stream()										// stream 생성
			.distinct().filter(str -> str.length() >= 5)	// 중간 처리
			.forEach(str -> System.out.println(str));		// 최종 처리
	}
	
	// 리스트 정렬 후 상위의 2개만 출력해보자 :D
	private static void method2() {
		// 1. stream 생성
		// 2. 중간 처리
		// 3. 최종 처리
		list.stream()
			.sorted().limit(2)
			.forEach(str -> System.out.println(str));
	}
	
	// 리스트의 데이터 중 5글자 이상인 것들로 구성된 새로운 리스트를 만들자
	private static void method3() {
		List<String> lg5 = list.stream()
			.filter(str -> str.length() >= 5)
			.collect(Collectors.toList());
		
		System.out.println(lg5 + ", " + lg5.size());
	}
	
	private static void method4() {
		long length = list.stream()
			.filter(str -> str.length() >= 5)
			.count();
		System.out.println(length);
	}
	
}




















