package com.ssafy.io;

import java.io.*;

public class ByteInputOutput {
	public static void main(String[] args) {

		fileTest();
		readFile();
	}

	// file 처리
	public static void fileTest() {
		File file = new File("./hello.txt");	// 현재 경로 밑에 hello.txt를 나타내는 객체 생성
		System.out.println(file.getAbsolutePath());

		try {
			file.createNewFile();
			System.out.println("file 생성 완료");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}					// 실제 물리적 파일 생성
	}

	// 데이터 읽어보기
	public static void readFile() {
		FileReader fis = null;
		FileWriter fout = null;
		
		try {
			fis = new FileReader("./hello.txt");	// 읽을 때는 있는 파일에서만 읽을 수 있다.
			fout = new FileWriter("./output.txt");	// 쓸 때는 해당 파일이 없으면 새로 만들어서 씀
			
			// 기본 파일 전송 버퍼
			char[] buffer = new char[5];
			int readed = 0;

			while ( (readed = fis.read(buffer)) > 0  ) {	// 데이터를 다 읽어들이면 read는 -1 반환
				System.out.println(new String(buffer, 0, readed));
				fout.write(buffer, 0, readed);
			}
		} catch (FileNotFoundException e) {
			System.out.println("파일이 없습니다.");
		} catch (IOException e) {
			System.out.println("읽는 과정에 오류가 발생했습니다.");
		} finally {
			if(fis != null) {
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
			if(fout != null) {
				try {
					fout.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
