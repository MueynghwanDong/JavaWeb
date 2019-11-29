package com.ssafy.day10.network;

import java.net.*;
import java.io.*;

public class ServerObject {
	public static void main(String[] args) {
		try(ServerSocket ss = new ServerSocket(6304);) {
			System.out.println("Server is ready.");
			
			while(true) {
				try(Socket socketForC = ss.accept();
						// 클라이언트로부터 데이터를 받아들일 스트림 구성
						ObjectInputStream oin = new ObjectInputStream(socketForC.getInputStream());
						BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socketForC.getOutputStream()));
						) {
					
					Object obj = oin.readObject();
					Person p = (Person) obj;
					
					System.out.println((p + "객체 수신 완료. \n"));
					
				} catch(IOException | ClassNotFoundException e) {
					e.printStackTrace();
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
