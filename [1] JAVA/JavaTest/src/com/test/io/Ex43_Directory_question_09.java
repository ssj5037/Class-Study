package com.test.io;

import java.io.File;
import java.util.ArrayList;

public class Ex43_Directory_question_09 {
	
	public static void main(String[] args) {
		
		String path = "D:\\파일_디렉토리_문제\\크기 정렬";
		File dir = new File(path);
		
		ArrayList<FileArray> fileList = new ArrayList<FileArray>();
		
		if(dir.exists()) {
			File[] list = dir.listFiles();
			for (File sub : list) {
				if (sub.isFile()) {
					for(int i=0; i<list.length; i++) {
						fileList.add(new FileArray());
						fileList.get(i).name = sub.getName();
						fileList.get(i).size = sub.length();
//						fileList.get(i).dir = ;
					}
				} else if (sub.isDirectory()) {
					
				}
			}
			
			
			System.out.println("[파일명]\t\t[크기]\t[파일이 들어있는 폴더]");

			
		} else {
			System.out.println("디렉토리가 존재하지 않습니다.");
		}
		
	}
}

class FileArray {
	public String name;
	public long size;
	public String dir;
}
