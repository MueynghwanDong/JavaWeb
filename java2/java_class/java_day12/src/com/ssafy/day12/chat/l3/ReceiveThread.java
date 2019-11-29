package com.ssafy.day12.chat.l3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ReceiveThread extends Thread {
	Socket socket;
	BufferedReader br;
	
	public ReceiveThread(Socket socket) {
		this.socket = socket;
		try {
			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void run() {
		while(true) {
			try {
				String line = br.readLine();
				if(line == null) {
					break;
				} else {
					System.out.println(line);
				}
			} catch (IOException e) {
				e.printStackTrace();
				break;
			}
		}
		if(socket.isConnected()) {
			try {
				socket.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
}
