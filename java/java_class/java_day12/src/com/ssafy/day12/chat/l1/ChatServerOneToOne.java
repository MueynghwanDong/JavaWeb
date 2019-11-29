package com.ssafy.day12.chat.l1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ChatServerOneToOne {

	public static void main(String[] args) {
		try(ServerSocket ss = new ServerSocket(9090); ) {
			System.out.println("Server is ready . . .");
			// 클라이언트의 접속을 처리해준다
			while(true) {
				try(Socket forClient = ss.accept();
						Scanner sc = new Scanner(System.in);
						BufferedReader br = new BufferedReader(new InputStreamReader(forClient.getInputStream()));
						BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(forClient.getOutputStream()));
					) {
					System.out.println("Client info : " + forClient.getInetAddress());
					while(true) {
						System.out.println(br.readLine());
						System.out.print("당신 > ");
						String msg = sc.nextLine();
						bw.write("서버 > " + msg + "\n");
						bw.flush();
					}
				} catch(IOException e) {
					e.printStackTrace();
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}	// end of main
}	// end of class
