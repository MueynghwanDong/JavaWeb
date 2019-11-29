package com.ssafy.day7.collection.set;
import java.util.*;

public class CollectionLotto {
	// 각각 6개의 랜덤 값으로 1 ~ 45까지의 숫자를 갖는 lotto 만들기
	Random rd = new Random();

	public void makeLottoBySet() {
		Set<Integer> set = new HashSet<Integer>();

		while(set.size() != 6) {
			set.add(rd.nextInt(45)+1);
		}
		// Collections.sort
		List<Integer> list = new ArrayList<>(set);
		Collections.sort(list);

		System.out.println("set : " + list);
	}

	public void makeLottoByList() {
		List<Integer> list = new LinkedList<Integer>();

		while(list.size() != 6) {
			int temp = rd.nextInt(45)+1;

			if( !list.contains(temp) ) {
				list.add(temp);
			}
		}

		Collections.sort(list);
		System.out.println("list : " + list);
	}

	public void makeLottoByMap() {
		// 공, 빈도수
		Map<Integer, Integer> map = new HashMap<>();

		for(int i = 0; i < 10000000; i++) {
			int num = rd.nextInt(45)+1;

			if(map.containsKey(num)) {
				map.put(num, map.get(num)+1);
			} else {
				map.put(num, 1);
			}
		}
		System.out.println(map);

		// 빈도수에 따라 balls를 정렬 후 출력하시오.
		List<Integer> balls = new ArrayList<>(map.keySet());

		Collections.sort(balls, new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				return map.get(o1).compareTo(map.get(o2));
			}
		});

		// 람다식의 활용 - 클래스 추정, 그 자리에 올 수 있는 클래스가 한정되어 있을 때 람다식으로 대체 가능
//							abstract method가 하나만 있어서 추정할 수 있는 경우 람다식을 사용할 수 있다.
//							Comparator 인터페이스는 compare 라는 추상메서드가 하나만 있어서 람다식 OK.
		Collections.sort(balls, (Integer o1, Integer o2) -> {
			return map.get(o1).compareTo(map.get(o2));
		});

		// 파라미터의 타입 생략 - 타입 추정
		Collections.sort(balls, (o1, o2) -> {
			return map.get(o1).compareTo(map.get(o2));
		});

		// 리턴 하나로 구성된 경우 return 생략
		Collections.sort(balls, (o1, o2) -> 
			map.get(o1).compareTo(map.get(o2))
		);
		
		Collections.sort(balls, (o1, o2) -> map.get(o1).compareTo(map.get(o2)));
		
		System.out.println(balls.subList(0, 6));
	}

	public static void main(String[] args) {
		CollectionLotto cl = new CollectionLotto();

		cl.makeLottoBySet();
		cl.makeLottoByList();
		cl.makeLottoByMap();
	}
}
