package com.ssafy.movie;
/** + ctrl + enter */
/** 
 * 이 클래스는 영화에 대한 정보를 담는다.
 * @author student
 */
public class Movie {
	// 멤버 변수
	/**
	 * 영화 제목을 의미한다.
	 */
	private String title;
	private String director;
	private int grade;
	private String genre;
	private String summary;

	// 생성자를 만들 때는 기본 생성자도 같이 만들어 주는게 좋다.
	public Movie() {}

	public Movie(String title, String director, int grade) {
		this.title = title;
		this.director = director;
		this.grade = grade;
	}

	public Movie(String title, String director, int grade, String genre) {
		// this. : 자신의 멤버를 지정할 때 사용
		this(title, director, grade);
		this.genre = genre;
	}
	
	public Movie(String title, String director, int grade, String genre, String summary) {
		// this. : 자신의 멤버를 지정할 때 사용
//		this.title = title;
//		this.director = director;
//		this.grade = grade;
//		this.genre = genre;
//		this.summary = summary;
		
		// this() --> 자신의 다른 생성자를 호출
		this(title, director, grade, genre);	// Constructor call must be the first statement in a constructor
		this.summary = summary;
	}
	
	
	
	public String getTitle() {return title;}
	public void setTitle(String title) {this.title = title;}
	public String getDirector() {return director;}
	public void setDirector(String director) {this.director = director;}
	public int getGrade() {return grade;}
	public void setGrade(int grade) {this.grade = grade;}
	public String getGenre() {return genre;}
	public void setGenre(String genre) {this.genre = genre;}
	public String getSummary() {return summary;}
	public void setSummary(String summary) {this.summary = summary;}

	/**
	 *  영화의 내용을 콘솔에 출력한다.
	 */
	public void movieInfo() {
		System.out.println(toString()); 
	}

	public String toString() {
		return "Movie [title=" + title + ", director=" + director + ", grade=" + grade + ", genre=" + genre
				+ ", summary=" + summary + "]";
	}
}
