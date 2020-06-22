package com.test.io;

import java.io.File;

public class Ex43_Directory_question_04 {

	public static void main(String[] args) {
		
		String path = "D:\\파일_디렉토리_문제\\음악 파일\\Music";
		File dir = new File(path);
		
		if (dir.exists()) {
			File[] list = dir.listFiles();
			for (int i=0; i<list.length; i++) {
				File newFile;
				if(i>=0 && i<9) {
					String newPath = path + "\\" 
							+ String.format("[00%d]%s", i+1, list[i].getName()); 
					newFile = new File(newPath);
					list[i].renameTo(newFile);
				} else if(i>=9 && i<99) {
					String newPath = path + "\\" 
							+ String.format("[0%d]%s", i+1, list[i].getName()); 
					newFile = new File(newPath);
					list[i].renameTo(newFile);
				} else {
					String newPath = path + "\\" 
							+ String.format("[%d]%s", i+1, list[i].getName()); 
					newFile = new File(newPath);
					list[i].renameTo(newFile);
				}
				System.out.println(newFile.getName());
			}
			
			
		}
	}
	
}
