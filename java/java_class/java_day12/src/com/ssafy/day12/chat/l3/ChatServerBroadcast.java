package com.ssafy.day12.chat.l3;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ChatServerBroadcast {
	// 전체 사용자 관리
	public static List<ClientThread> clients = new ArrayList<>();
	
	
	public static void main(String[] args) {
		try(ServerSocket ss = new ServerSocket(9090); ) {
			System.out.println("Server is ready . . .");
			// 클라이언트의 접속을 처리해준다
			while(true) {
				try {
					// 소켓은 여기서 닫지 않는다 --> Thread에서 정리
					Socket socket = ss.accept();
					ClientThread ct = new ClientThread(socket);
					clients.add(ct);
					System.out.println("현재 사용자 수 : " + clients.size());
					ct.start();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}	// end of main
}	// end of class
