package com.test.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class Ex44_File_IO_Question_07 {
	
	public static void main(String[] args) throws Exception {
		
		File file = new File("‪D:\\파일_입출력_문제\\출결.dat");
		
		if (file.exists()) {
			
			ArrayList<String[]> list = new ArrayList<String[]>();
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line = null;
			
			while((line = reader.readLine()) != null) {
				list.add(line.split(","));
			}
			
			reader.close();
			
			
//			ㅆㅂ
			
		} else {
			System.out.println("파일이 존재하지 않습니다.");
		}
		
	}

}
