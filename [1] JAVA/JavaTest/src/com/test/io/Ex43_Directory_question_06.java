package com.test.io;

import java.io.File;

public class Ex43_Directory_question_06 {
	
	public static void main(String[] args) {
		
		String path = "D:\\파일_디렉토리_문제\\파일 제거";
		File dir = new File(path);
		int count = 0;
		
		if (dir.exists()) {
		
			File[] list = dir.listFiles();
			
			for (File file : list) {
				if(file.isFile() && file.length() == 0) {
					file.delete();
					count++;
				}
			}
			
			System.out.println("총 " + count +"개의 파일을 삭제했습니다.");
		} else {
			System.out.println("디렉토리가 존재하지 않습니다.");
		}
		
	}

}
