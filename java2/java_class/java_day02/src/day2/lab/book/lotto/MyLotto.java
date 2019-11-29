package day2.lab.book.lotto;

import java.util.Arrays;
import java.util.Random;

public class MyLotto {
	int lo[] = new int[6];

	public void selectLotto() {
		for (int i = 0; i < lo.length; i++) {
			lo[i] = uniqueNumber(i);
		}
	}

	public int uniqueNumber(int idx) {
		int imsi;
		boolean eq;
		Random ran = new Random();
		do {
			imsi = ran.nextInt(45) + 1;
			eq = false;
			for (int j = 0; j < idx; j++) {
				if (imsi == lo[j]) {	// 중복값 발생
					eq = true;
					break;
				}
			}
		} while (eq);
		return imsi;
	}

	void print() {
		Arrays.sort(lo);
		System.out.println("로또 당첨 번호는: " + Arrays.toString(lo));
	}

	public static void main(String[] args) {
		MyLotto lotto = new MyLotto();
		lotto.selectLotto();
		lotto.print();

	}

}
