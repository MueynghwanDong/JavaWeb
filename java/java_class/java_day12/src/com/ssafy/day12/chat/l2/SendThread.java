package com.ssafy.day12.chat.l2;	// Level 2 라는 뜻

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

public class SendThread extends Thread {
	Socket socket;
	BufferedWriter bw;
	
	public SendThread(Socket socket) {
		this.socket = socket;
		
		try {
			bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void run() {
		Scanner sc = new Scanner(System.in);
		System.out.println("SYSTEM : 채팅을 그만하려면 'X'를 입력하세요.");
		while(true) {
			String line = sc.nextLine();
			
			if(line.equals("X")) {	// 채팅 종료
				System.out.println("SYSTEM : 채팅이 종료됩니다.");
				break;
			}
			
			try {
				bw.write(line+"\n");
				bw.flush();
			} catch (IOException e) {
				e.printStackTrace();
				break;
			}
		}
		
		try {
			socket.close();		// 문제가 생겼거나 그만하려면 종료.
			sc.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	
}
