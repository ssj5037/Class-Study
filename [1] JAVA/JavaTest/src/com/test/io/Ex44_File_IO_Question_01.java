package com.test.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

public class Ex44_File_IO_Question_01 {
	
	public static void main(String[] args) throws Exception {
		
		//원본 파일
		File file = new File("D:\\파일_입출력_문제\\이름수정.dat");
		
		//파일이 존재하는지 확인, 존재하면 작업 실행
		if(file.exists()) {
			
			// 문자열을 저장하기 위해 ArrayList 인스턴스 생성
			ArrayList<String> list = new ArrayList<String>();
			// 원본 파일 읽기전용 인스턴스 생성
			BufferedReader reader = new BufferedReader(new FileReader(file));
			// 문자열을 임시로 저장할 변수 생성
			String line = null;
			
			// 버퍼리더로 한 라인씩 읽어온다, 모든 문자열을 읽으면(null이 반환) 루프끝
			while ((line = reader.readLine()) != null) {
				// ArrayList에 유재석을 메뚜기로 변환한 문자열 저장
				list.add(line.replace("유재석",	"메뚜기"));
			}
			
			// 버퍼리더 종료
			reader.close();
			
			// 수정된 새 파일을 쓰기 위한 버퍼라이터 인스턴스 생성
			BufferedWriter writer = new BufferedWriter(new FileWriter("D:\\파일_입출력_문제\\이름수정_변환.dat"));
			
			// ArrayList 인스턴스에 저장된 문자열을 루프를 돌려 하나씩 탐색
			// 탐색이 종료되면 루프 빠져나옴
			for (String data : list) {
				// 새 파일에 쓰기
				writer.write(data + "\r\n");
			}
			
			// 버퍼라이터 종료
			writer.close();
			
			System.out.println("변환 후 다른 이름으로 저장하였습니다.");
			
		} else { //파일이 존재하지 않으면 작업 비실행
			System.out.println("파일이 존재하지 않습니다.");
		}
		
	}

}
