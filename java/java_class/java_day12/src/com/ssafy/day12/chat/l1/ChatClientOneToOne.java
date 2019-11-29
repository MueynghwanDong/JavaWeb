package com.ssafy.day12.chat.l1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class ChatClientOneToOne {
	public static void main(String[] args) {
		try (Socket s = new Socket("127.0.0.1", 9090);
				Scanner sc = new Scanner(System.in);
				BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
				BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));) {
			System.out.println("서버에 접속되었습니다. 그만 하려면 X 누르고 엔터하세요.");
			boolean connect = true;
			
			while(connect) {
				System.out.print("당신 > ");
				String msg = sc.nextLine();
				
				if(msg.equals("X")) {
					System.out.println("채팅이 종료됩니다.");
					break;
				}
				
				bw.write("Client Message : " + msg + "\n");
				bw.flush();
				
				System.out.println(br.readLine());
			}


		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
