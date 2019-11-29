package com.ssafy.io;
import java.io.*;
import java.util.*;

public class LastWordGame {
	ArrayList<String> wordList;
	File file = new File("C:/Temp/problem.dat");
	Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		LastWordGame lwg = new LastWordGame();
		lwg.init();
		lwg.makeQuestion();
		lwg.close();
	}
	
	// store: wordList를 problem.dat에 저장한다. 이 때 scanner도 종료시켜주자.
	public void close() {
		try(ObjectOutputStream oout = new ObjectOutputStream(new FileOutputStream(file))) {
			oout.writeObject(wordList);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			sc.close();
		}
	}
	
	public void makeQuestion() {
		System.out.println("마지막 문자로 시작하는 단어는 ? ");
		System.out.println(wordList);
		
		String word = sc.nextLine();
		wordList.add(word);
		
		System.out.println(wordList);
	}
	
	// init: problem.dat에서 객체를 읽어와 wordList를 생성한다.
	// 단 이 과정에서 파일이 없다면 새로 생성한다.
	
	public void init() {
		
		try( ObjectInputStream oin = new ObjectInputStream(new FileInputStream(file)) ) {
			Object stored = oin.readObject();
			
			if(stored != null && stored instanceof ArrayList) {
				wordList = (ArrayList) stored;
				System.out.println("복구 성공");
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("아직 파일 없음");
			
			wordList = new ArrayList<>();
			wordList.add("싸피");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
