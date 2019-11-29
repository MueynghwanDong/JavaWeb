package day2.lab.book.waterstrider;

import java.util.Scanner;

public class Waterstrider {
	static long Answer;
	static int N, S;

	public static void main(String[] args) throws Exception {
		System.setIn(Waterstrider.class.getResourceAsStream("Waterstrider.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();//테스트 케이스 수

		for (int test_case = 1; test_case <= T; test_case++) {
			N = sc.nextInt(); //배열의 크기 NxN
			int[][] lake = new int[N][N];

			S = sc.nextInt();//소금쟁이(Strider)수
			int[][] strider = new int[S][3];
			
			for (int k = 0; k < S; k++) {
				strider[k][0] = sc.nextInt();//행위치
				strider[k][1] = sc.nextInt();//열위치
				strider[k][2] = sc.nextInt();//방향(1:하,2:우)
			}
			
			//////////////////////////////
			//( 이 부분에 알고리즘 구현을 한다. )//
			//////////////////////////////

			System.out.println("#" + test_case + " " + Answer);
		}
	}
}