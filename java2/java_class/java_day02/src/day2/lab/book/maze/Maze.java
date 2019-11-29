package day2.lab.book.maze;

import java.util.Scanner;

public class Maze {
	static int N, Si, Sj, P, D;
	static int Ai, Aj;

	public static void main(String[] args) throws Exception {
		System.setIn(Maze.class.getResourceAsStream("Maze.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			N = sc.nextInt();
			Si = sc.nextInt(); 		//출발점의 i좌표
			Sj = sc.nextInt(); 		//출발점의 j좌표
			P = sc.nextInt();		// 점퍼의 개수

			int Pi[] = new int[P];  // 점퍼의 i좌표의 모음
			int Pj[] = new int[P];  // 점퍼의 j좌표의 모음

			for (int k = 0; k < P; k++) {
				Pi[k] = sc.nextInt();
				Pj[k] = sc.nextInt();
			}

			D = sc.nextInt();		// 이동 지시 개수
			int Dd[] = new int[D];  // 방향 모음
			int Da[] = new int[D];  // 이동 칸수 모음

			for (int k = 0; k < D; k++) {
				Dd[k] = sc.nextInt();
				Da[k] = sc.nextInt();
			}
			//////////////////////////////
			//( 이 부분에 알고리즘 구현을 한다. )//
			//////////////////////////////

			System.out.println("#" + test_case + " " + Ai + " " + Aj);
		}
	}
}
