package com.ssafy.day3.array;

public class Explorer4D {
	static int[][] arr2D = {
			{ 1,  2,  3,  4,  5},
			{ 6,  7,  8,  9, 10},
			{11, 12, 13, 14, 15},
			{16, 17, 18, 19, 20},
			{21, 22, 23, 24, 25}
	};

	public static void main(String[] args) {
		
		System.out.println("4방향의 합이 최대인 요소 : " + getMax4DirSUm());
	}
	
	public static int getMax4DirSUm() {
		int max = -1;
		int num = 0;
		
		for(int r=0; r<arr2D.length; r++) {
			for(int c=0; c<arr2D[r].length; c++) {
				int dirsum = get4DirSum2(r, c);
				System.out.println("[" + r + ", " + c +  "]" + "총합 : "  + dirsum);
				
				if(max < dirsum) {
					max = dirsum;
					num = arr2D[r][c];
				}
			}
		}
		return num;
	}
	
	// 주어진 위치를 기준으로 4방향 요소의 합을 리턴하시오.
	public static int get4DirSum(int r, int c) {
		int num1 = arr2D[r+1][c];	// 상
		int num2 = arr2D[r-1][c];	// 하
		int num3 = arr2D[r][c-1];	// 좌
		int num4 = arr2D[r][c+1];	// 우
		
		return num1 + num2 + num3 + num4;
	}
	
	public static int[][] dirs = {{-1, -1}, {1, 0}, {-1, 1}, {0, -1}, {1, -1}, {1, 0}, {1,1}, {0, 1}};
	
	public static boolean isIn(int r, int c) {
		if( (0 <= r && r < arr2D.length) && (0 <= c && c < arr2D[0].length) ) {
			return true;
		} else {
			return false;
		}
	}
	
	public static int get4DirSum2(int r, int c) {
		int sum = 0;
		
		for(int d=0; d < dirs.length; d++) {
			int newR = dirs[d][0] + r;
			int newC = dirs[d][1] + c;
			
			if(isIn(newR, newC)) {
				sum += arr2D[newR][newC];
			}
		}
		return sum;
	}
}
