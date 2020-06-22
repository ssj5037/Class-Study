package com.test.io;

import java.io.File;
import java.util.Scanner;

public class Ex43_Directory_question_02 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		System.out.print("폴더 선택 : ");
		String inputDir = scan.nextLine();
		File dir = new File(inputDir.replace("\\", "\\\\"));
		
		System.out.print("파일 확장자 : ");
		String inputExt = scan.nextLine();
		
		if(dir.exists()) {
			
			File[] list = dir.listFiles();
			
			for (int i=0; i<list.length; i++) {
				if(list[i].getName().toLowerCase().contains("." + inputExt.toLowerCase())) {
					System.out.println(list[i].getName());
				}
			}
			System.out.println("디렉토리 탐색을 완료했습니다.");
		} else {
			System.out.println("디렉토리가 없습니다.");
		}
	}
	
}
