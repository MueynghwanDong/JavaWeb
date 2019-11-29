package com.ssafy.day10.network;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client1 {
	public static void main(String[] args) {
		try(Socket socket = new Socket("70.12.108.40", 9999);
				BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
				Scanner scanner = new Scanner(System.in);
				) {
			System.out.println("접속 완료 ! ");
			System.out.println(br.readLine());
			String name = scanner.nextLine();
			
			bw.write(name);
			bw.flush();
			
			
			
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
}
