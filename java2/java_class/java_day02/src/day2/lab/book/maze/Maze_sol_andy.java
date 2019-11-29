package day2.lab.book.maze;

import java.util.Scanner;

public class Maze_sol_andy {
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

			// 미로는 한 칸씩 걸어간다!!!!!!!!

			// 점퍼 위치 설정
			int[][] map = new int[N + 1][N + 1];
			for (int i = 0; i < P; i++) {
				map[Pi[i]][Pj[i]] = 1;
			}
			boolean isOut = false;
			for (int i = 0; i < D; i++) {
				int dir = Dd[i];			// 방향
				int cnt = Da[i];			// 칸수
				if (map[Si][Sj] == 1) {		// 점퍼 위치면 종료
					isOut = true;
					break;
				}

				if (dir == 1 && Si - cnt >= 1) {
					for (int y = 1; y <= cnt; y++) {
						Si -= 1;
						if (map[Si][Sj] == 1) {
							isOut = true;
							break;
						}
					}
				} else if (dir == 2 && Sj + cnt <= N) {
					for (int x = 1; x <= cnt; x++) {
						Sj += 1;
						if (map[Si][Sj] == 1) {
							isOut = true;
							break;
						}
					}
				} else if (dir == 3 && Si + cnt <= N) {
					for (int y = 1; y <= cnt; y++) {
						Si += 1;
						if (map[Si][Sj] == 1) {
							isOut = true;
							break;
						}
					}
				} else if (dir == 4 && Sj - cnt >= 1) {
					for (int x = 1; x <= cnt; x++) {
						Sj -= 1;
						if (map[Si][Sj] == 1) {
							isOut = true;
							break;
						}
					}
				} else {
					isOut = true;
					break;
				}
			}
			if (isOut) {
				Ai = 0;
				Aj = 0;
			} else {
				Ai = Si;
				Aj = Sj;
			}

			System.out.println("#" + test_case + " " + Ai + " " + Aj);
		}
	}
}
