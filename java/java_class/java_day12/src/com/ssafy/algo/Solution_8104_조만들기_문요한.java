package com.ssafy.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_8104_조만들기_문요한 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int testCase = 1; testCase <= T; testCase++) {
			StringBuilder sb = new StringBuilder();
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			
			int[][] students = new int[K][N];		// 각 N명의 인원으로 구성된 K개의 조
			int count = 1;
			
			for (int i = 0; i < N; i++) {		
				if(i%2 == 0) {
					for (int j = 0; j < K; j++) {
						students[j][i] = count++;
					}
				} else {
					for (int j = K-1; j >= 0; j--) {
						students[j][i] = count++;
					}
				}
			}
			sb.append('#').append(testCase).append(' ');
			
			for (int i = 0; i < students.length; i++) {
				int sum = 0;
				for (int j = 0; j < students[i].length; j++) {
					sum += students[i][j];
				}
				sb.append(sum+" ");
			}
			System.out.println(sb);
		}	// end of for - testCase
	}	// end of main
}	// end of class