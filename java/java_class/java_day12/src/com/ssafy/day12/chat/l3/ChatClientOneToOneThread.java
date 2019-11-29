package com.ssafy.day12.chat.l3;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class ChatClientOneToOneThread {
	public static void main(String[] args) {
		try {
			Socket socket = new Socket(args[0], 9090);
			System.out.println("서버에 접속되었습니다. 그만 하려면 X 누르고 엔터하세요.");
			
			new SendThread(socket).start();
			new ReceiveThread(socket).start();

		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
