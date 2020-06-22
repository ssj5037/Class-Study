package com.test.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

public class Ex44_File_IO_Question_02 {
	
	public static void main(String[] args) throws Exception {
		
		File file = new File("D:\\파일_입출력_문제\\숫자.dat");

		if(file.exists()) {
			
			ArrayList<String> list = new ArrayList<String>();
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line = null;
			
			while ((line = reader.readLine()) != null) {
				list.add(numReplace(line));
			}
			
			reader.close();
			
			BufferedWriter writer = new BufferedWriter(new FileWriter("D:\\파일_입출력_문제\\숫자_변환.dat"));
			
			for (String data : list) {
				writer.write(data + "\r\n");
			}
			
			writer.close();
			
			System.out.println("변환 후 다른 이름으로 저장하였습니다.");
			
		} else {
			System.out.println("파일이 존재하지 않습니다.");
		}
	}

	private static String numReplace(String line) {
		String result = line;
		if(line.contains("0")) {
			result = result.replace("0", "영");
		}
		if(line.contains("1")) {
			result = result.replace("1", "일");
		}
		if(line.contains("2")) {
			result = result.replace("2", "이");
		}
		if(line.contains("3")) {
			result = result.replace("3", "삼");
		}
		if(line.contains("4")) {
			result = result.replace("4", "사");
		}
		if(line.contains("5")) {
			result = result.replace("5", "오");
		}
		if(line.contains("6")) {
			result = result.replace("6", "육");
		}
		if(line.contains("7")) {
			result = result.replace("7", "칠");
		}
		if(line.contains("8")) {
			result = result.replace("8", "팔");
		}
		if(line.contains("9")) {
			result = result.replace("9", "구");
		}
		
		return result;
	}

}
