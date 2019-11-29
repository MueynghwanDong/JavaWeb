package day2.lab.book.waterstrider;
import java.util.Scanner;

public class Waterstrider_sol_andy {
	static long Answer;
	static int N, S;
	public static void main(String[] args) throws Exception {
		System.setIn(Waterstrider.class.getResourceAsStream("Waterstrider.txt"));
		Scanner sc=new Scanner(System.in);
		int T=sc.nextInt();//테스트 케이스 수

		for(int test_case=1; test_case<=T; test_case++){
			N=sc.nextInt(); //배열의 크기 NxN
			int[][] lake=new int[N][N];

			S=sc.nextInt();//소금쟁이(Strider)수
			int[][] strider=new int[S][3];
			for(int k=0; k<S; k++){
				strider[k][0]=sc.nextInt();//행위치
				strider[k][1]=sc.nextInt();//열위치
				strider[k][2]=sc.nextInt();//방향(1:하,2:우)
			}
			//////////////////////////////
			//( 이 부분에 알고리즘 구현을 한다. )//
			//////////////////////////////
			Answer = 0;
			for (int i = 0; i < S; i++) {
				int row = strider[i][0];
				int col = strider[i][1];
				int dir = strider[i][2];

				if (lake[row][col] != 0) {	// 출발지점에 이미 누군가 있었다면 바로 종료
					Answer = i + 1;
					break;
				} else {
					lake[row][col] = 1;		// 출발지 방문 표시
					if (dir == 2) {		// 오른쪽 방향
						for(int h=3; h>=1; h--) {
							col+=h;
							if(col<N) {
								if(lake[row][col]==0) {
									lake[row][col]=1;
								}else {
									Answer=i+1;
									break;
								}
							}
						}
					} else {
						for(int v=3; v>=1; v--) {
							row+=v;
							if(row<N) {
								if(lake[row][col]==0) {
									lake[row][col]=1;
								}else {
									Answer=i+1;
									break;
								}
							}
						}
					}
				}
			}
			System.out.println("#"+test_case+" "+Answer);
		}
	}
}
