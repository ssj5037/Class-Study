package com.test.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Ex44_File_IO_Question_05 {
	
	public static void main(String[] args) throws Exception {
		
		File file = new File("D:\\파일_입출력_문제\\단일검색.dat");

		if(file.exists()) {
			
			ArrayList<String[]> list = new ArrayList<String[]>();
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line = null;
			
			while ((line = reader.readLine()) != null) {
				list.add(line.split(","));
			}
			

			reader.close();
			
			Scanner scan = new Scanner(System.in);
			System.out.print("이름 : ");
			String input = scan.nextLine();
			
			for(int i=0; i<list.size(); i++) {
				if(list.get(i)[1].equals(input)) {
					System.out.printf("[%s]\r\n", input);
					System.out.printf("번호 : %s\r\n", list.get(i)[0]);
					System.out.printf("주소 : %s\r\n", list.get(i)[2]);
					System.out.printf("전화 :%s\r\n", list.get(i)[3]);
					break;
				}
			}
			
		} else {
			System.out.println("파일이 존재하지 않습니다.");
		}
	}

}
