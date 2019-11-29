package com.ssafy.day12.chat.l2;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ChatServerOneToOneThread {

	public static void main(String[] args) {
		try(ServerSocket ss = new ServerSocket(9090); ) {
			System.out.println("Server is ready . . .");
			// 클라이언트의 접속을 처리해준다
			while(true) {
				try {
					// 소켓은 여기서 닫지 않는다 --> Thread에서 정리
					Socket socket = ss.accept();
					System.out.println("Client 정보 : " + socket.getInetAddress());
					new SendThread(socket).start();
					new ReceiveThread(socket).start();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}	// end of main
}	// end of class
