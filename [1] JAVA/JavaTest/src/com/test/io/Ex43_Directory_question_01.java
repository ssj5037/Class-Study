package com.test.io;

import java.io.File;
import java.util.Scanner;

public class Ex43_Directory_question_01 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		System.out.print("파일 경로 : ");
		String input = scan.nextLine();
		
		File file = new File(input.replace("\\", "\\\\"));
		System.out.println(input);
		if(file.exists()) {

			String fileName = file.getName();
			String ext = fileName.substring(fileName.indexOf(".")+1);
			
			long size = file.length();
			String fileSize = "";
			
			if (size < 1024) {
				fileSize = String.format("%,dB", size);
			} else if (size >= 1024 && size < 1024 * 1024) {
				fileSize = String.format("%,.1fKB", size / 1024.0);
			} else if (size >= 1024 * 1024 && size < 1024 * 1024 * 1024) {
				fileSize = String.format("%,.1fMB", size / 1024 / 1024.0);
			} else if (size >= 1024 * 1024 * 1024 && size < 1024 * 1024 * 1024 * 1024) {
				fileSize = String.format("%,.1fGB", size / 1024 / 1024 / 1024.0);
			} else {
				fileSize = String.format("%,.1fTB", size / 1024 / 1024 / 1024 / 1024.0);
			}
			
			System.out.printf("파일명 : %s\n", fileName);
			System.out.printf("종류 : %s 파일\n", ext);
			System.out.printf("파일 크기 : %s\n", fileSize);
			
		} else {
			System.out.println("파일을 찾을 수 없습니다.");
		}
		
	}
	
}
