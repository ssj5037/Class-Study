package com.test.io;

import java.io.File;
import java.util.HashMap;
import java.util.Set;

public class Ex43_Directory_question_05 {
	
	public static void main(String[] args) {
		
		String path = "D:\\파일_디렉토리_문제\\확장자별 카운트";
		File dir = new File(path);
		
		HashMap<String, Integer> image = new HashMap<String, Integer>();
		
		if(dir.exists()) {
			File[] list = dir.listFiles();
			for (File sub : list) {
				String ext = sub.getName().substring(sub.getName().indexOf(".")+1);
				if(image.containsKey(ext)) {
					image.put(ext, image.get(ext)+1);
				} else {
					image.put(ext, 1);
				}
			}
			
			Set<String> set = image.keySet();
			for (String ext : set) {
				System.out.println("*." + ext + " : " + image.get(ext) + "개");
			}
			System.out.println("디렉토리 탐색을 마쳤습니다.");
		} else {
			System.out.println("디렉토리가 없습니다.");
		}
	}

}
