package com.ssafy;

public class CarMgr {
	private static CarMgr mgr = new CarMgr();
	private Car[] cars = new Car[100];
	private int index;
	
	private CarMgr() {}
	
	
	public static CarMgr getMgr() {
		return mgr;
	}
	
	/**
	 * cars 배열에 c를 저장하고 index를 관리하자.
	 * @param c
	 * @return 저장 성공 여부
	 */
	public boolean add(Car c) {
		if(index >= cars.length) {
			System.out.println("배열이 가득 찼습니다.");
			return false;
		} else {
			cars[index++] = c;
			return true;
		}
	}
	
	/**
	 * 모든 차량의 정보를 리턴한다.
	 * @return
	 */
	public Car[] search() {
		Car[] temp = new Car[index];
		
		for (int i = 0; i < index; i++) {
			Car car = cars[i];
			temp[i] = car;
		}
		
		return temp;
	}
	
	/**
	 * 특정 번호(num) 에 해당하는 차량을 리턴한다.
	 * @param num
	 * @return 해당 차가 있다면 그 차, 없다면 null
	 */
	public Car search(String num) {
		for (int i = 0; i < index; i++) {
			Car c = cars[i];
			
			if(c != null && c.getNum().equals(num))
				return c;
		}
		
		return null;
	}
	
	/**
	 * price 보다 저렴한 차량들을 반환
	 * @param price
	 * @return
	 */
	public Car[] search(int price) {
		Car[] temp = new Car[index];
		int size = 0;
		
		for(int i = 0; i < index; i++) {
			Car car = cars[i];
			
			if(car != null && car.getPrice() < price) {
				temp[size++] = car;
			}
		}
		Car[] real = new Car[size];
		System.arraycopy(temp, 0, real, 0, size);
		
		return real;
	}
	
	/**
	 * num에 해당하는 차량의 가격을 price로 변경하시오.
	 * @param num
	 * @param price
	 * @return 성공 여부
	 */
	public boolean update(String num, int price) {
		Car c = search(num);
		
		if(c != null) {
			c.setPrice(price);
			return true;
		}
		
		return false;
	}
	
	public boolean delete(String num) {
		for(int i=0; i < index; i++) {
			Car c = cars[i];
			if(c != null && c.getNum().equals(num)) {
				cars[i] = cars[index-1];	// 맨 뒤쪽 차량을 앞으로 이동
				cars[index-1] = null;		// 이동한 지점을 null 처리
				index--;					// index 관리
				
				return true;
			}
		}
		
		return false;
	}
	
	/**
	 * 보유 대수
	 * @return
	 */
	public int size() {
		return index;
	}
	
	/**
	 * 전체 가격
	 * @return
	 */
	public int totalPrice() {
		int sum = 0;
		
		for (int i = 0; i < index; i++) {
			sum += cars[i].getPrice();
		}
		
		return sum;
	}
	
	public int getAllSeats() {
		int seats = 0;
		
		for (int i = 0; i < index; i++) {
			Car c = cars[i];
			
			if(c != null) {
				if(c instanceof Truck) {
					seats += 1;
				} else if(c instanceof Bus) {
					Bus b = (Bus)c;
					seats += b.getSeat();
				} else {
					seats += 4;
				}
			}
		}
		
		return seats;
	}
	
	public int countOnlyCar() {
		int count = 0;
		
		for (int i = 0; i < index; i++) {
			if( !(cars[i] instanceof Bus) && !(cars[i] instanceof Truck) ) {
				count++;
			}
		}
		
		return count;
	}
}
