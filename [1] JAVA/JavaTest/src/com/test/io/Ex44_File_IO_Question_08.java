package com.test.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Ex44_File_IO_Question_08 {
	
	public static void main(String[] args) throws Exception {
		
		File file = new File("D:\\파일_입출력_문제\\자바소스.java");
//		System.out.println(file.getAbsolutePath());
		
		if(file.exists()) {
			
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line = null;
			int open = 0;
			int close = 0;
			
			while((line = reader.readLine()) != null) {
				if((line.indexOf("(")) != -1) {
					open++;
				}
				if((line.indexOf("{")) != -1) {
					open++;
				}
				if((line.indexOf(")")) != -1) {
					close++;
				}
				if((line.indexOf("}")) != -1) {
					close++;
				}
			}
			
			System.out.println("open : " + open);
			System.out.println("close : " + close);
			if(open == close) {
				System.out.println("올바른 소스입니다.");
			} else {
				System.out.println("올바리지 않은 소스입니다.");
			}
			
			reader.close();
			
		} else {
			System.out.println("파일이 존재하지 않습니다.");
		}
	}
}
