package com.ssafy2;

import java.util.Scanner;

public class MovieTest {
	public static void main(String[] args) {
		MovieMgr mm = MovieMgr.getMovieMgr();
		Scanner sc = new Scanner(System.in);
		
		Loop: while(true) {
			System.out.println("<<< 영화 관리 프로그램 >>>");
			System.out.println("1. 영화 정보 입력");
			System.out.println("2. 영화 정보 전체 검색");
			System.out.println("3. 영화명 검색");
			System.out.println("4. 영화 감독별 검색");
			System.out.println("5. 영화 장르별 검색");
			System.out.println("6. 영화 정보 삭제");
			System.out.println("0. 종료");
			System.out.println("=======================================");
			System.out.print(" * 원하는 메뉴를 선택하세요 >> ");
			
			int sel = Integer.parseInt(sc.nextLine());
			
			switch(sel) {
			case 1:		// 영화 정보 입력
				System.out.print(" * 영화의 제목을 입력하세요 >> ");
				String title = sc.nextLine();
				
				System.out.print(" * 영화의 감독을 입력하세요 >> ");
				String director = sc.nextLine();
				
				System.out.print(" * 영화의 등급을 입력하세요 >> ");
				int grade = Integer.parseInt(sc.nextLine());
				
				System.out.print(" * 영화의 장르를 입력하세요 >> ");
				String genre = sc.nextLine();
				
				System.out.print(" * 영화의 줄거리를 입력하세요 >> ");
				String summary = sc.nextLine();
				
				mm.add(new Movie(title, director, grade, genre, summary));
				System.out.println(" @@@ 영화가 추가되었습니다. @@@");
				
				break;
				
			case 2:		// 영화 정보 전체 검색
				Movie[] arr = mm.search();
				
				System.out.println("**********************************************");
				System.out.println();
				for(Movie m : arr) 
					System.out.println(m);
				System.out.println();
				System.out.println("**********************************************");
				
				break;
				
			case 3:		// 영화명 검색
				System.out.print(" * 검색하고 싶은 영화의 제목을 입력하세요 >>");
				title = sc.nextLine();
				arr = mm.search(title);
				
				System.out.println("**********************************************");
				System.out.println();
				for(Movie m : arr) 
					System.out.println(m);
				System.out.println();
				System.out.println("**********************************************");
				
				break;
				
			case 4:		// 영화 감독별 검색
				System.out.print(" * 검색하고 싶은 영화의 감독을 입력하세요 >>");
				director = sc.nextLine();
				arr = mm.searchDirector(director);
				
				System.out.println("**********************************************");
				System.out.println();
				for(Movie m : arr) 
					System.out.println(m);
				System.out.println();
				System.out.println("**********************************************");
				
				break;
				
			case 5:		// 영화 장르별 검색
				System.out.print(" * 검색하고 싶은 영화의 장르를 입력하세요 >>");
				genre = sc.nextLine();
				arr = mm.searchGenre(genre);
				
				System.out.println("**********************************************");
				System.out.println();
				for(Movie m : arr) 
					System.out.println(m);
				System.out.println();
				System.out.println("**********************************************");
				
				
				break;
				
			case 6:		//영화 정보 삭제
				System.out.print(" * 삭제하고 싶은 영화의 제목을 정확하게 입력하세요 >> ");
				title = sc.nextLine();
				
				mm.delete(title);
				System.out.println(" @@@ 영화가 삭제되었습니다. @@@");
				
				break;
				
			case 0:		// 프로그램 종료
				System.out.println(" $ 프로그램을 종료합니다.");
				sc.close();
				
				break Loop;
				
			default:	// 이상한 값
				System.out.println(" $ 범위 내의 값을 입력해주세요.");
				break;
			}
		}
		
		
	}
}
