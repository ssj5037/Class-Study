package com.test.string;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class Ex44_File_IO_Question_04 {
	
	public static void main(String[] args) throws Exception {
		
		File file = new File("D:\\파일_입출력_문제\\성적.dat");
		
		if(file.exists()) {
			
			ArrayList<String[]> list = new ArrayList<String[]>();
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line = null;
			
			while ((line = reader.readLine()) != null) {
				list.add(line.split(","));
			}
			
			reader.close();

			int kor = 0;
			int eng = 0;
			int math = 0;
			double avg = 0;
			ArrayList<String> pass = new ArrayList<String>();
			ArrayList<String> fail = new ArrayList<String>();
			
			for (int i=0; i<list.size(); i++) {
				kor = Integer.parseInt(list.get(i)[1]);
				eng = Integer.parseInt(list.get(i)[2]);
				math = Integer.parseInt(list.get(i)[3]);
				
				avg = (kor + eng + math) / 3.0;
				
				if(avg >= 60 && kor >= 40 && eng >= 40 && math >= 40) {
					pass.add(list.get(i)[0]);
				} else { 
					fail.add(list.get(i)[0]);
				}
			}
			
			System.out.println("[합격자]");
			for(String result : pass) {
				System.out.println(result);
			}
			System.out.println("[불합격자]");
			for(String result : fail) {
				System.out.println(result);
			}

		} else {
			System.out.println("파일이 존재하지 않습니다.");
		}
	}

}

