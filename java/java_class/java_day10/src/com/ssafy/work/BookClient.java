package com.ssafy.work;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

public class BookClient extends Thread {
	Object books;
	int size;

	public BookClient(Object books, int size) {
		this.books = books;
		this.size = size;
	}

	@Override
	public void run() {
		try(Socket socket = new Socket("localhost", 63042);
				ObjectOutputStream oout = new ObjectOutputStream(socket.getOutputStream());
				BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));) {

			System.out.println("도서 사이트 접속 성공.");
			oout.writeObject(books);
			System.out.println("도서 리스트 전송 완료.");
			String readed = br.readLine();
			if(size == Integer.parseInt(readed)) {
				System.out.println("도서 목록 개수 같음. 이상 없음.");
			} else {
				System.out.println("도서 목록 개수 달라짐. 이상 있음.");
			}
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
