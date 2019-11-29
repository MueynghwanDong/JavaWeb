package com.ssafy.day10.network;

import java.net.*;
import java.io.*;

public class ServerFile {
	public static void main(String[] args) {
		try(ServerSocket ss = new ServerSocket(6304);) {
			System.out.println("Server is ready.");
			File file = new File("C:/Temp/myexp.exe");
			
			while(true) {
				try(Socket socketForC = ss.accept();
						BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(file));
						// 클라이언트로부터 데이터를 받아들일 스트림 구성
						BufferedInputStream bin = new BufferedInputStream(socketForC.getInputStream());
						BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socketForC.getOutputStream()));
						) {
					
					byte[] buffer = new byte[100];
					int readed = -1;
					
					while( (readed=bin.read(buffer)) > 0 ) {
						bos.write(buffer, 0, readed);
					}
					bos.flush();
					// 전송 완료 표시
					bw.write("파일 전송 완료. \n");
					bw.flush();
					
				} catch(Exception e) {
					e.printStackTrace();
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
