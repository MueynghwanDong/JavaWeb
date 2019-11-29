package com.ssafy.io;

import java.io.*;

public class ObjectStreamTest {
	public static void main(String[] args) {
		File file = new File("C:/Temp/object.dat");
		Person p = new Person("Hong");
		
		// file, byte, write, --> 객체 저장
		try( ObjectOutputStream oout = new ObjectOutputStream(new FileOutputStream(file));
			 ObjectInputStream oin = new ObjectInputStream(new FileInputStream(file)); 
			) {
			oout.writeObject(p);
			System.out.println("출력 종료");
			
			Object obj = oin.readObject();
			if(obj instanceof Person) {
				Person restore = (Person) obj;
				System.out.println("읽어들임 : " + restore);
			}
		} catch(IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}
}
