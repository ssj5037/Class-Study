package com.test.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;

public class Ex44_File_IO_Question_10 {
	
	public static void main(String[] args) throws Exception {
		
		File fileWord = new File("D:\\파일_입출력_문제\\자바예약어.dat");
		File fileSource = new File("D:\\파일_입출력_문제\\자바소스.java");
		
		if (fileSource.exists() && fileWord.exists()) {
			
			ArrayList<String> wordList = new ArrayList<String>();
			HashMap<String, Integer> wordListCount = new HashMap<String, Integer>();
			BufferedReader readerWord = new BufferedReader(new FileReader(fileWord));
			String line = null;
			
			while ((line = readerWord.readLine()) != null) {
				wordList.add(line);
				wordListCount.put(line, 0);
			}
			
			readerWord.close();
			
			BufferedReader readerSource = new BufferedReader(new FileReader(fileSource));
			
			while ((line = readerSource.readLine()) != null) {
				
			}
			
			
			
			
		} else {
			System.out.println("파일이 존재하지 않습니다.");
		}
		
		
	}

}
