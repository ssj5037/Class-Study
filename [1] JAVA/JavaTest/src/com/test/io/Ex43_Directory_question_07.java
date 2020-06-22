package com.test.io;

import java.io.File;

public class Ex43_Directory_question_07 {
	
	public static void main(String[] args) {
		
		String pathA = "D:\\파일_디렉토리_문제\\동일 파일\\MusicA";
		String pathB = "D:\\파일_디렉토리_문제\\동일 파일\\MusicB";
		
		File A = new File(pathA);
		File B = new File(pathB);
		
		if(A.exists() && B.exists()) {
			
			File[] listA = A.listFiles();
			File[] listB = B.listFiles();
			
			for (File subA : listA) {
				for (File subB : listB) {
					if (subA.getName().equals(subB.getName())) {
						System.out.println(subA.getName());
					}
				}
			}
		} else {
			System.out.println("디렉토리가 존재하지 않습니다.");
		}
		
	}

}
