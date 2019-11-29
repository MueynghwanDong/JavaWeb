package com.ssafy.day10.network;

import java.net.*;
import java.io.*;

public class ClientObject {
	public static void main(String[] args) {
		try(Socket socket = new Socket("localhost", 6304);
				ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
 				) {
			System.out.println("접속 성공.");
			Person p = new Person("Moon", 27);
			oos.writeObject(p);
			System.out.println("전송 완료.");
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
