package com.ssafy.day10.network;

import java.net.*;
import java.io.*;

public class ClientFile {
	public static void main(String[] args) {
		File file = new File("C:/windows/explorer.exe");
		try(Socket socket = new Socket("localhost", 6304);
				BufferedInputStream fi = new BufferedInputStream(new FileInputStream(file));
				BufferedOutputStream fout = new BufferedOutputStream(socket.getOutputStream());
				BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
 				) {
			System.out.println("접속 성공.");
			byte[] buffer = new byte[100];
			int readed = -1;
			
			while((readed = fi.read(buffer)) > 0) {
				fout.write(buffer, 0, readed);
			}
			
			fout.flush();
			System.out.println("전송 완료.");
			
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
