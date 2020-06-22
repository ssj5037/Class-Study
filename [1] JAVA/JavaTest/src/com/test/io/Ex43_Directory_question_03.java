package com.test.io;

import java.io.File;
import java.util.Scanner;

public class Ex43_Directory_question_03 {
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		System.out.println("파일 이동을 실행합니다.");
		
		String path = "D:\\class\\java\\io\\GGG\\hhh.txt";
		File file = new File(path);
		
		if(file.exists()) {
			String path2 = "D:\\class\\java\\io\\DDD\\hhh.txt";
			File file2 = new File(path2);
			if(file2.exists()) {
				System.out.print("같은 이름을 가지는 파일이 이미 존재합니다."
						+ "덮어쓸까요? (y/n)");
				String input = scan.nextLine();
				
				if(input.equals("y")) {
					file2.delete();
					File file3 = new File(path2);
					file.renameTo(file3);
					System.out.println("y. 파일을 덮어썼습니다.");
				} else if (input.equals("n")) {
					System.out.println("n. 작업을 취소합니다.");
				} else {
					System.out.println("잘못된 값을 입력하였습니다.");
				}	
			} else {
				file.renameTo(file2);
				System.out.println("파일이 이동되었습니다.");
			}
		} else {
			System.out.println("파일이 존재하지 않습니다.");
		}
		
	}

}
