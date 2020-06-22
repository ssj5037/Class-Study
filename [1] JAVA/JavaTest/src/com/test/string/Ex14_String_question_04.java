package com.test.string;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Ex14_String_question_04 {

	public static void main(String[] args) throws Exception {
		
		// 요구사항 04
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		int gif = 0;
		int jpg = 0;
		int png = 0;
		int hwp = 0;
		int doc = 0;
		
		for (int i=0; i<10; i++) {
			System.out.print("파일명 : ");
			String filename = reader.readLine();
			
			String ext = filename.substring(filename.lastIndexOf("."));
			if(ext.equals(".gif")
					|| ext.equals(".jpg")
					|| ext.equals(".png")
					|| ext.equals(".hwp")
					|| ext.equals(".doc")) {
				if (ext.equals(".gif")) {
					gif++;
				} else if (ext.equals(".jpg")) {
					jpg++;
				} else if (ext.equals(".png")) {
					png++;
				} else if (ext.equals(".hwp")) {
					hwp++;
				} else if (ext.equals(".doc")) {
					doc++;
				}
			} else {
				System.out.println("올바른 확장자를 입력하세요. gif, jpg, png, hwp, doc 중 하나.");
				break;
			}
		}
		System.out.printf("gif : %d개\r\n"
				+ "jpg : %d개\r\n"
				+ "png : %d개\r\n"
				+ "hwp : %d개\r\n"
				+ "doc : %d개\r\n", gif, jpg, png, hwp, doc);
		
	}
	
}
