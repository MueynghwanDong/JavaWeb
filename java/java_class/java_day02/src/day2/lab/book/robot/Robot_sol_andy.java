package day2.lab.book.robot;

import java.io.InputStream;
import java.util.Scanner;

public class Robot_sol_andy {
	static int T, N;
	static int Answer;

	public static void main(String[] args) throws Exception {
		InputStream input = Robot.class.getResourceAsStream("Robot.txt");
		System.setIn(input);
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			N = sc.nextInt();
			char[][] map = new char[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j] = sc.next().charAt(0);
				}
			}
			//////////////////////////////
			//( 이 부분에 알고리즘 구현을 한다. )//
			//////////////////////////////
			Answer = 0;						// 초기화 조심!!
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] == 'A') {	// 오른쪽으로만 이동 가능
						for (int k = j + 1; k < N; k++) {
							if (map[i][k] == 'S') {
								Answer++;
							} else {
								break;
							}
						}
					} else if (map[i][j] == 'B') {// 좌, 우로 이동 가능
						for (int k = j + 1; k < N; k++) {// 우
							if (map[i][k] == 'S') {
								Answer++;
							} else {
								break;
							}
						}
						for (int k = j - 1; k >= 0; k--) {// 좌
							if (map[i][k] == 'S') {
								Answer++;
							} else {
								break;
							}
						}
					} else if (map[i][j] == 'C') {// 상하좌우 이동 가능
						for (int k = j + 1; k < N; k++) {// 우
							if (map[i][k] == 'S') {
								Answer++;
							} else {
								break;
							}
						}
						for (int k = j - 1; k >= 0; k--) {// 좌
							if (map[i][k] == 'S') {
								Answer++;
							} else {
								break;
							}
						}
						for (int k = i + 1; k < N; k++) {// 하
							if (map[k][j] == 'S') {
								Answer++;
							} else {
								break;
							}
						}
						for (int k = i - 1; k >= 0; k--) {// 상
							if (map[k][j] == 'S') {
								Answer++;
							} else {
								break;
							}
						}
					}
				}
			}
			System.out.println("#" + test_case + " " + Answer);
		}
	}
}