package com.ssafy.movie;

public class MovieTest {
	public static void main(String[] args) {
		Movie movie = new Movie();		// new 생성자()
		
		movie.movieInfo();
		movie.setTitle("어벤져스: 엔드 게임");
		movie.movieInfo();
		
		Movie movie2 = new Movie();
		movie2 = movie;	// 11라인의 객체는 Garbage Collector의 대상이 되어 메모리 상에서 사라진다. movie를 참조하게 됨.
		
		movie2.setTitle("알라딘");
		movie.movieInfo();
		
		Movie movie3 = new Movie("겨울왕국2", "감독은 몰라요", 12, "동화", "꿀잼예상중");
		movie3.movieInfo();
	}
}
