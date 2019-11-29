package day2.lab.book.robot;

import java.util.Arrays;
import java.util.Scanner;

public class Robot {
	static int T, N;			// T: 테스트 케이스의 수, N: 배열의 크기
	static int Answer;			// 답

	public static void main(String[] args) throws Exception {
		System.setIn(Robot.class.getResourceAsStream("Robot.txt"));
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		
		for (int test_case = 1; test_case <= T; test_case++) {
			N = sc.nextInt();
			Answer = 0;
			
			char[][] map = new char[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j] = sc.next().charAt(0);
				}
			}
			//////////////////////////////
			//( 이 부분에 알고리즘 구현을 한다. )//
			
			// 입력 확인
			for(char[] row : map) {
				System.out.println(Arrays.toString(row));
			}
			
			for(int i=0; i < N; i++) {
				for(int j=0; j < N; j++) {
					if(map[i][j] == 'A') {
						int k = j;

						while(true) {
							
							if(++k < map[i].length && map[i][k] == 'S') {
								Answer++;
							} else {
								break;
							}
						}
						
					} else if(map[i][j] == 'B') {
						int k = j;

						while(true) {
							
							if(++k < map[i].length && map[i][k] == 'S') {
								Answer++;
							} else {
								break;
							}
						}
						
						k = j;

						while(true) {
							
							if(--k >= 0 && map[i][k] == 'S') {
								Answer++;
							} else {
								break;
							}
						}
						
					} else if(map[i][j] == 'C') {
						int k = j;

						while(true) {
							
							if(++k < map[i].length && map[i][k] == 'S') {
								Answer++;
							} else {
								break;
							}
						}
						
						k = j;

						while(true) {
							
							if(--k >= 0 && map[i][k] == 'S') {
								Answer++;
							} else {
								break;
							}
						}
						
						k = i;

						while(true) {
							
							if(++k < N && map[k][j] == 'S') {
								Answer++;
							} else {
								break;
							}
						}
						
						k = i;

						while(true) {
							
							if(--k >= 0 && map[k][j] == 'S') {
								Answer++;
							} else {
								break;
							}
						}
						
					}
				}
			}
			
			
			//////////////////////////////
			System.out.println("#" + test_case + " " + Answer);
		}
	}
}
















