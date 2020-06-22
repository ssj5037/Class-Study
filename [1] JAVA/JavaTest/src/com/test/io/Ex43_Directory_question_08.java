package com.test.io;

import java.io.File;

public class Ex43_Directory_question_08 {
	
	public static int dirCount = 0;
	public static int fileCount = 0;
	
	public static void main(String[] args) {
		
		String path = "D:\\파일_디렉토리_문제\\폴더 삭제";
		File dir = new File(path);
		
		if(dir.exists()) {
			deleteFiles(dir);
			System.out.println("폴더를 삭제했습니다.");
			System.out.println("삭제된 폴더는 " + dirCount + "개이고,"
					+ " 파일은 " + fileCount + "개입니다.");
		}
		
	}

	private static void deleteFiles(File dir) {
		File[] list = dir.listFiles();
		
		for(File sub : list) {
			if(sub.isFile()) {
				sub.delete();
				fileCount++;
			} else if(sub.isDirectory()) {
				deleteFiles(sub);
				sub.delete();
				dirCount++;
			}
		}
	}

}
