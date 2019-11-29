package day2.lab.book.maze;
import java.util.Scanner;

public class Maze_sol {
	static int N, Si, Sj, P, D;
	static int Ai, Aj;

	public static void main(String[] args) throws Exception{
		System.setIn(Maze.class.getResourceAsStream("Maze.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case++)
		{
			N = sc.nextInt();
			Si = sc.nextInt(); //출발점의 i좌표
			Sj = sc.nextInt(); //출발점의 j좌표
			P = sc.nextInt();

			int Pi[] = new int[P];  // 점퍼의 i좌표의 모음
			int Pj[] = new int[P];  // 점퍼의 j좌표의 모음

			for(int k=0; k<P; k++) {  // 점퍼를 입력
				Pi[k] = sc.nextInt();
				Pj[k] = sc.nextInt();
			}

			D = sc.nextInt();
			int Dd[] = new int[D];  // 방향 모음
			int Da[] = new int[D];  // 이동 칸수 모음

			for(int k=0; k<D; k++) {  //방향, 이동칸수 입력
				Dd[k] = sc.nextInt();
				Da[k] = sc.nextInt();
			}
			//////////////////////////////
			//( 이 부분에 알고리즘 구현을 한다. )//
			//////////////////////////////
			int[][] map=new int[N+1][N+1];

			for(int k=0; k<P; k++) {// 이차원 배열에 점퍼를 표시
				int i=Pi[k];
				int j=Pj[k];
				map[i][j]=-1;
			}

			boolean isout=false;
			for(int k=0; k<D; k++) { // 이동 지시 수 만큼 반복
				int dd=Dd[k];  //방향
				int da=Da[k];  //이동칸수

				//상  1
				if(dd==1){
					for(int d=1; d<=da; d++){
						if(Si-1>=1 && map[Si-1][Sj] !=-1){  // 경계밖이거나 점퍼인가??
							Si--;
						}else{								// 그렇지 않으면 이동
							isout=true;
							break;
						}
					}
				}
				//우  2
				else if(dd==2){
					for(int d=1; d<=da; d++){
						if(Sj+1<=N && map[Si][Sj+1]!=-1){
							Sj++;
						}else{
							isout=true;
							break;
						}
					}
				}
				//하  3
				else if(dd==3){
					for(int d=1; d<=da; d++){
						if(Si+1<=N && map[Si+1][Sj]!=-1){
							Si++;
						}else{
							isout=true;
							break;
						}
					}
				}
				//좌  4
				else if(dd==4){
					for(int d=1; d<=da; d++){
						if(Sj-1>=1 && map[Si][Sj-1]!=-1){
							Sj--;
						}else{
							isout=true;
							break;
						}
					}
				}
			}
			if(isout==true){
				Si=0;
				Sj=0;
			}
			Ai=Si;
			Aj=Sj;

			System.out.println("#"+test_case+" "+Ai+" "+Aj);
		}
	}
}
























