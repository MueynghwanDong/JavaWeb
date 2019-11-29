package com.ssafy.day12.chat.l3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

// 개별 클라이언트당 단 하나 ! ! ! ! ! ! 
public class ClientThread extends Thread {
	Socket socket;
	BufferedReader br;
	BufferedWriter bw;
	String name;
	
	public ClientThread(Socket socket) {
		// 스트림 구성
		this.socket = socket;
		
		try {
			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void run() {
		try {
			// 1. 먼저 클라이언트는 자신의 아이디를 전송한다.
			name = br.readLine();
			// 2. 모든 사용자에게 그 사람의 입장을 알린다,
			broadcast(String.format("[공지] %s 님이 입장했습니다.\n", name));
			// 3. 이후는 사용자들의 메세지를 전달한다.
			while(true) {
				String line = br.readLine();	// 소켓에서 읽은 자료를
				if(line == null || line.equals("X")) {
					break;
				} else {
					broadcast(String.format("[%s] %s", name, line));	// 모두에게 발송
				}
			}
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			// 퇴실 처리
			broadcast(String.format("[공지] %s님이 퇴장하셨습니다.", name));
			ChatServerBroadcast.clients.remove(this);
			
			try {
				socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	// 나랑 연결된 사용자에게 쓰기
	public void send(String msg) {
		try {
			bw.write(msg+"\n");
			bw.flush();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	// 채팅에 참여중인 모든 사용자에게 전달
	public void broadcast(String msg) {
		for(ClientThread ct : ChatServerBroadcast.clients) {
			ct.send(msg);
		}
	}
	
}


















