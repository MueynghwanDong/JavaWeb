package com.ssafy2;

public class MovieMgr {
	private static MovieMgr mm = new MovieMgr();
	private Movie[] movies = new Movie[100];
	private int index;
	
//	Private Constructor for Singleton
	private MovieMgr() {
		super();
	}
	
	
//	Getter for MovieMgr
	public static MovieMgr getMovieMgr() {
		return mm;
	}
	
	
//	Other Methods
	public void add(Movie m) {
		if(m != null) {
			movies[index++] = m;
		}
	}
	
	public Movie[] search() {
		Movie[] temp = new Movie[index];
		for (int i = 0; i < index; i++) {
			temp[i] = movies[i];
		}
		
		return temp;
	}
	
	public Movie[] search(String title) {
		int size = 0;
		
		for (int i = 0; i < index; i++) {
			if(movies[i].getTitle().contains(title))
				size++; 
		}
		
		Movie[] result = new Movie[size];
		int idx = 0;
		
		for (int i = 0; i < index; i++) {
			if(movies[i].getTitle().contains(title))
				result[idx++] = movies[i]; 
		}
		
		return result;
	}
	
	public Movie[] searchDirector(String name) {
		int size = 0;
		
		for (int i = 0; i < index; i++) {
			if(movies[i].getDirector().contains(name))
				size++; 
		}
		
		Movie[] result = new Movie[size];
		int idx = 0;
		
		for (int i = 0; i < index; i++) {
			if(movies[i].getDirector().contains(name))
				result[idx++] = movies[i]; 
		}
		
		return result;
	}
	
	public Movie[] searchGenre(String genre) {
		int size = 0;
		
		for (int i = 0; i < index; i++) {
			if(movies[i].getGenre().contains(genre))
				size++; 
		}
		
		Movie[] result = new Movie[size];
		int idx = 0;
		
		for (int i = 0; i < index; i++) {
			if(movies[i].getGenre().contains(genre))
				result[idx++] = movies[i]; 
		}
		
		return result;
	}
	
	public void delete(String title) {
		for (int i = 0; i < index; i++) {
			if(movies[i].getTitle().equals(title)) {
				movies[i] = null;
				movies[i] = movies[index-1];
				movies[index-1] = null;
				index--;
				
				break;
			}
		}
	}
	
	public int getSize() {
		return 0;
	}
}
