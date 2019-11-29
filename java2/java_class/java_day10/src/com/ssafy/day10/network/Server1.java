package com.ssafy.day10.network;

import java.io.*;
import java.net.*;

public class Server1 {
	public static void main(String[] args) {
		//서버 소켓 생성
		try(
				ServerSocket ss = new ServerSocket(9999); 
				) {
			System.out.println("Server is ready !");
			while(true) {
				// 클라이언트 접속 대기
				try(Socket socketForClient = ss.accept();
						// 클라이언트로부터 데이터를 받아들일 스트림 구성
						BufferedReader br = new BufferedReader(new InputStreamReader(socketForClient.getInputStream()));
						BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socketForClient.getOutputStream()));
						){
					InetAddress client = socketForClient.getInetAddress();
					System.out.println("접속 클라이언트 : " + client);
					// BufferedWriter를 통해서 출력할 때 개행문자 꼭 추가하기 !!
					bw.write(client + "님 반갑습니다. 아이디가 어떻게 되시나요?\n");
					bw.flush();	// 강제 전송
					
				}catch(IOException e) {
					System.out.println("클라이언트 접속 오류");
				}
				
			}
			
		}catch(IOException e) {
			System.out.println("server socket 오류.");
		}
		
	}
}
