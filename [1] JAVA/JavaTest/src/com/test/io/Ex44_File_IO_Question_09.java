package com.test.io;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class Ex44_File_IO_Question_09 {

	public static void main(String[] args) throws IOException {
		
		ArrayList<Integer> num = new ArrayList<Integer>();
		
		num.add(5);
		num.add(3);
		num.add(99);
		num.add(70);
		num.add(10);
		num.add(100);
		num.add(58);
		num.add(19);
		num.add(20);
		num.add(74);
		
		System.out.println(num);
		File file1 = new File("D:\\파일_입출력_문제\\09숫자_순서대로.dat");
		BufferedWriter writer = new BufferedWriter(new FileWriter(file1));
		for (Integer data : num) {
			writer.write(data + "\r\n");			
		}
		writer.close();
		
		Collections.reverse(num);
		System.out.println(num);
		File file2 = new File("D:\\파일_입출력_문제\\09숫자_반대로.dat");
		writer = new BufferedWriter(new FileWriter(file2));
		for (Integer data : num) {
			writer.write(data + "\r\n");			
		}
		writer.close();
		
		Collections.sort(num);
		Collections.reverse(num);
		System.out.println(num);
		File file3 = new File("D:\\파일_입출력_문제\\09숫자_내림차순.dat");
		writer = new BufferedWriter(new FileWriter(file3));
		for (Integer data : num) {
			writer.write(data + "\r\n");			
		}
		writer.close();
		
	}
}
