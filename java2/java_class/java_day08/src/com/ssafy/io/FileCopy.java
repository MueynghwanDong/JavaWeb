package com.ssafy.io;

import java.io.*;

public class FileCopy {
	File src = new File("C:/windows/explorer.exe");
	File dest = new File("C:/Temp/myexplorer.exe");
	final int BUFFER_SIZE = 10;
	
	public static void main(String[] args) {
//		FileInputStream fi = null;
//		FileOutputStream fout = null;
		
		FileCopy fc = new FileCopy();
		FileCopy fc2 = new FileCopy();
		
		long start = 0;
		long end = 0;
		

		// Buffered : 내부 버퍼를 이용해 속도 향상
		try(BufferedInputStream fi = new BufferedInputStream(new FileInputStream(fc.src));
				BufferedOutputStream fout = new BufferedOutputStream(new FileOutputStream(fc.dest)); ) {
			// 자동으로 close 해준다. 
			
			byte[] buffer = new byte[fc.BUFFER_SIZE];
			
			int readed = 0;
			
			start = System.currentTimeMillis();
			while( (readed = fi.read(buffer)) > 0 ) {
				
				fout.write(buffer, 0, readed);
			}
			System.out.println("done");
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			
			end = System.currentTimeMillis();
		}
		
		System.out.println("걸린 시간 : " + (end-start) + "ms");
	}
}
