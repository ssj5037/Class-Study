package com.test.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Ex44_File_IO_Question_06 {
	
	public static void main(String[] args) throws Exception {
		
		File fileMember = new File("D:\\파일_입출력_문제\\검색_회원.dat");
		File fileList = new File("D:\\파일_입출력_문제\\검색_주문.dat");

		if(fileMember.exists() && fileList.exists()) {
			
			ArrayList<String[]> searchMember = new ArrayList<String[]>();
			ArrayList<String[]> searchList = new ArrayList<String[]>();
			BufferedReader readerMember = new BufferedReader(new FileReader(fileMember));
			BufferedReader readerList = new BufferedReader(new FileReader(fileList));
			String line = null;
			
			while ((line = readerMember.readLine()) != null) {
				searchMember.add(line.split(","));
			}
			String lline = null;
			while ((lline = readerList.readLine()) != null) {
				searchList.add(lline.split(","));
			}

			readerMember.close();
			readerList.close();
			
			Scanner scan = new Scanner(System.in);
			System.out.print("이름 : ");
			String input = scan.nextLine();
			
			System.out.println("==== 구매내역 ====");
			System.out.println("[번호]\t[이름]\t[상품명]   [개수]\t[배송지]");
			
			String memNum ="";
			
			for(int i=0; i<searchMember.size(); i++) {
				if(searchMember.get(i)[1].equals(input)) {
					memNum = searchMember.get(i)[0];
					break;
				}
			}
			
			int iMemNum = Integer.parseInt(memNum);
			for(int i=0; i<searchList.size(); i++) {
				if(searchList.get(i)[3].equals(memNum)) {
					System.out.printf("%6s\t%s\t%s\t   %6s\t%s\r\n"
							, searchMember.get(iMemNum-1)[0]
							, searchMember.get(iMemNum-1)[1]
							, searchList.get(i)[1]
							, searchList.get(i)[2]
							, searchMember.get(iMemNum-1)[2]);
				}
			}
			
			scan.close();
			
		} else {
			System.out.println("파일이 존재하지 않습니다.");
		}
	}

}
