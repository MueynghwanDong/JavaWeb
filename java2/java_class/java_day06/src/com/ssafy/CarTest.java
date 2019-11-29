package com.ssafy;

public class CarTest {
	public static void main(String[] args) {
		CarMgr cm = CarMgr.getMgr();

		// TODO 1 : CarTest에서, 0~29까지는 Car, 30~59까지는 Bus, 나머지는 Truck을 저장하시오.
		for (int i = 0; i < 100; i++) {
			String number = String.format("%07d", i);
			if(i < 30) {
				cm.add(new Car(number, "PALISADE", 50000000+i));
			} else if (i < 60) {
				cm.add(new Bus(number, "CITY BUS", 80000000+i, i));
			} else {
				cm.add(new Truck(number, "GALAXY TRUCK", 60000000+i, i));
			}
		}

		Car[] all = cm.search();

		for(Car c : all) {
			System.out.println(c);
		}

		// TODO 2 : CarMgr에서, Car는 4인승, Truck은 1인승, Bus는 seat에 따라 다르다. 모두 몇 명 운송이 가능한지 찾으시오.
		int seats = cm.getAllSeats();
		System.out.println(" * 운송 가능한 인원 수 : " + seats);

		// TODO 3 : CarMgr에서, Bus도 아니고 Truck도 아닌 것은 몇 대인가? 
		int count = cm.countOnlyCar();
		System.out.println(" * 순수 Car의 수 : " + count);


	}	// end of main
}	// end of class
