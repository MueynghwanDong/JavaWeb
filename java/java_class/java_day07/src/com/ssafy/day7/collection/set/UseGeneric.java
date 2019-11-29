package com.ssafy.day7.collection.set;

public class UseGeneric {
	public static void main(String[] args) {
		NormalPocket np = new NormalPocket();
		np.setObj("Hello");
		
		Object obj = np.getObj();
		if(obj instanceof String) {
			String str = (String) obj;
			System.out.println(str.length());
		}
		
		// 컴파일 타임에 타입 체킹
		GenericPocket<String> gp1 = new GenericPocket<String>();
		gp1.setSome("Hello");		// 언제나 문자열 ! !
		String str = gp1.getSome();
		System.out.println(str.length());
		
		GenericPocket<Integer> gp2 = new GenericPocket<>();
		gp2.setSome(100);
		Integer data = gp2.getSome();
		System.out.println(data.intValue());
		
		GenericPocket<Object> gp3 = new GenericPocket<>();
		gp2.setSome(100);
//		Integer data = gp2.getSome();
//		System.out.println(data.intValue());
	}
}
