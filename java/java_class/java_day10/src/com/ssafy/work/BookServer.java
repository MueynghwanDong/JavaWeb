package com.ssafy.work;

import java.io.*;
import java.net.*;
import java.util.*;

public class BookServer {
	public static void main(String[] args) {
		try(ServerSocket ss = new ServerSocket(63042);) {
			System.out.println("Server is ready.");
			
			while(true) {
				try(Socket socketClient = ss.accept();
						ObjectInputStream oin = new ObjectInputStream(socketClient.getInputStream());
						BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socketClient.getOutputStream()));) {
					
					Object obj = oin.readObject();
					
					if(obj != null) {
						System.out.println("객체 수신 : " + obj);
						
						if(obj instanceof List) {
							List<Book> list = (List) obj;
							bw.write(list.size() + "\n");						
							
						} else if(obj instanceof Map) {
							Map<String, Book> map = (Map) obj;
							bw.write(map.size() +"\n");
						}
					}
				}catch(IOException | ClassNotFoundException e) {
					e.printStackTrace();
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
