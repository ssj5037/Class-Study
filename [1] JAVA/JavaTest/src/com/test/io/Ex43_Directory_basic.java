package com.test.io;

import java.io.File;
import java.util.Calendar;
import java.util.Date;

public class Ex43_Directory_basic {
	
	private static int count = 0;
	
	public static void main(String[] args) {
		
		//m1();
		//m2();
		//m3();
		//m4();
		//m5();
		//m6();	//****
		//m7();	//****
		m8();
		
	}

	private static void m8() {
		
		// 정렬
		//D:\class\java\JavaTest\src\com\test\object
		String path = "D:\\class\\java\\JavaTest\\src\\com\\test\\object";
		File dir = new File(path);
		File[] list = dir.listFiles();
		
		// 정렬: 이름 -> 크기
		// 정렬 알고리즘
		// - 버블 정렬 vs 퀵 정렬
		
//		for (int i=0; i<list.length-1; i++) {
//			for (int j=i; j<list.length; j++) {
//				
//				if (list[i].length() > list[j].length()) {
//					File temp = list[j];
//					list[j] = list[i];
//					list[i] = temp;
//				}
//			}
//		}
		
		for (int i=0; i<list.length; i++) {
			for (int j=0; j<list.length-i-1; j++) {
				
				if (list[j].length() > list[j+1].length()) {
					File temp = list[j];
					list[j] = list[j+1];
					list[j+1] = temp;
				}
			}
		}
		
		for (File file : list) {
			if (file.isFile()) {
				System.out.printf("[%5dB] %-20s\n",file.length(), file.getName());
			}
		}
		
	}

	private static void m7() {
		
		// ****************** 중요 ******************
		//m6() -> 재귀 호출 구조로 변경
		String path = "C:\\eclipse";
		File dir = new File(path);
		
		if (dir.exists()) {
			
			countFile(dir);
			
		}
		System.out.println("총 파일 개수 : " + count);
		
	}

	private static void countFile(File dir) {
		
		// 1. 목록 가져오기
		File[] list = dir.listFiles();
		
		// 2. 파일 개수 세기
		for (File sub : list) {
			if (sub.isFile()) {
				count++;
			}
		}
		
		// 3. 자식 폴더를 대상으로 본인이 했던 행동을 다시하기
		for (File sub : list) {
			if (sub.isDirectory()) {
				//똑같은 행동을 반복
				countFile(sub);	// 재귀 호출
			}
		}
		
	}

	private static void m6() {
		
		// 특정 폴더 -> 파일 개수?
		String path = "C:\\eclipse";
		File dir = new File(path);
		
		if (dir.exists()) {
			
			int count = 0;	// 누적 변수
			
			File[] list = dir.listFiles();	//이클립스의 자식
			
			for (File sub : list) {
				if (sub.isFile()) {
					count++;
				}
			}// 파일 개수
			
			// 자식 폴더로 이동
			for (File sub : list) {
				if (sub.isDirectory()) {
					
					File[] sublist = sub.listFiles();	//이클립스의 손자들
					
					for (File subsub : sublist) {
						if (subsub.isFile()) {
							count++;
						}
					}
					
					for (File subsub : sublist) {
						if(subsub.isDirectory()) {
							
							File[] subsublist = subsub.listFiles();	//이클립스의 증손자들
							
							for (File subsubsub : sublist) {
								if(subsubsub.isFile()) {
									count++;
								}
							}
						}
					}
				}
			}
			
			
			System.out.println("총 파일 개수 : " + count);
			
		}
		
		
	}

	private static void m5() {
		
		// 디렉토리 내용 보기(*****)
		// - 자식 파일 + 자식 디렉토리
		String path = "C:\\eclipse";
		File dir = new File(path);
		
		if (dir.exists()) {
			
			//Returns an array of strings naming the files and directories in the directory denoted by this abstract pathname. 
//			String[] list = dir.list();
//			
//			for (String name : list) {
//				System.out.println(name);
//				File file = new File(path + "\\" + name);
//				System.out.println(file.length());
//			}
			
			File[] list = dir.listFiles();
//			for (File file : list) {
//				System.out.println(file.getName());
//				System.out.println(file.isFile());
//				if(file.isFile()) {
//					System.out.println(file.length());
//				}
//				System.out.println();
//				
//			}
			
			for (File sub : list) {
				if(sub.isDirectory()) {
					System.out.printf("%-20s\t",sub.getName());
					System.out.print("\t");
					System.out.print("파일폴더\t");
					Date date = new Date(sub.lastModified());
					System.out.printf("%tF%tT\n", date, date);
				}
			}
			
			for (File sub : list) {
				if(sub.isFile()) {
					System.out.printf("%-20s\t", sub.getName());
					System.out.printf("%,dKB\t", sub.length() / 1024);
					System.out.print("파일\t\t");
					Date date = new Date(sub.lastModified());
					System.out.printf("%tF%tT\n", date, date);
				}
			}
		
		}
		
		
	}

	private static void m4() {
		
		// 디렉토리 삭제하기
		// - 빈폴더만 삭제 가능하다.
		// - 내용물을 직접 지우면 폴더를 삭제할 수 있다. 
		//   -> 해당 폴더 내의 모든 파일 삭제 후 폴더를 빈폴더로 만들고 폴더를 삭제 x 반복
		String path = "D:\\class\\java\\io\\GGG";
		File dir = new File(path);
		
		if(dir.exists()) {
			
			System.out.println(dir.delete());
			
		} else {
			System.out.println("없음.");
		}
		
		
	}

	private static void m3() {
		
		// 디렉토리명 바꾸기 & 이동하기
		String path = "D:\\class\\java\\io\\BBB";
		File dir = new File(path);
		
		if(dir.exists()) {
			String path2 =  "D:\\class\\java\\io\\GGG\\BBB";
			File dir2 = new File(path2);
			
			dir.renameTo(dir2);
			System.out.println("디렉토리 이동하기");
		} else {
			System.out.println("디렉토리명 이동 실패");
		}
		
	}

	private static void m2() {
		
		// 디렉토리 조작
		// - 생성, 이름 바꾸기, 이동하기, 삭제하기, 복사하기(X)
		
		// 새 폴더 만들기
//		String path = "D:\\class\\java\\io\\CCC";	// 희망 경로
		String path = "D:\\class\\java\\io\\DDD\\EEE\\FFF";	// 희망 경로
		// dir.mkdir()을 사용하면 할아버지폴더DDD, 아버지폴더EEE가 존재하지 않기 때문에 실패한다.
		File dir = new File(path);
		
//		boolean result = dir.mkdir();	//마지막 목적 폴더만 만들어줌.
		boolean result = dir.mkdirs();	//경로에 있는 모든 폴더를 다 만들어줌.
		
		if (result) {
			System.out.println("폴더 생성 성공");
		} else {
			System.out.println("폴더 생성 실패");
			// 같은 폴더가 있으면 만들어지지 않는다.
		}
		
		
		
		// 요구사항] 회원 -> 회원별 개인 폴더 작성하기
		String[] member = {"홍길동", "아무개", "하하하", "호호호", "후후후"};
		
		for (String name : member) {
			
			//폴더 생성
			path = String.format("D:\\class\\java\\io\\AAA\\[개인폴더]%s님", name);
			dir = new File(path);
			dir.mkdir();
			
			System.out.printf("%s님의 개인폴더를 생성했습니다.\n", name);
			
		}
		
		
		
		// 요구사항] 날짜별 폴더 생성하기
		// - 2020-01-01 ~ 2020-12-31 : 366개
		// - Calendar 사용
		
		Calendar c = Calendar.getInstance();
		c.set(2020, 0, 1);
		
		
		System.out.println(c.get(Calendar.DAY_OF_YEAR));			// 오늘이 한해동안 며칠 지났는지
		System.out.println(c.get(Calendar.DAY_OF_MONTH));			// 오늘이 한달동안 며칠 지났는지
		System.out.println(c.getMaximum(Calendar.DAY_OF_YEAR));		//366, 올해 마지막 날?
		System.out.println(c.getMaximum(Calendar.DAY_OF_MONTH));	//이번달 마지막 날짜?
		
		for(int i=0; i<c.getMaximum(Calendar.DAY_OF_YEAR); i++) {
			
			path = String.format("D:\\class\\java\\io\\BBB\\%tF", c);
			dir = new File(path);
			dir.mkdir();
			
			System.out.printf("%tF\n", c);
			c.add(Calendar.DATE, 1);
		}
		
		
	}

	private static void m1() {
		
		// 디렉토리 정보 확인
		// - 디렉토리 참조객체 -> 정보 or 조작
		
		// 디렉토리 참조 객체
		String path = "D:\\class\\java\\io\\AAA";
		
		File dir = new File(path);
		// 파일을 참조하는 형태로 쓰이고 있음. 따라서 폴더와 파일은 동일하게 쓰임.
		
		if (dir.exists()) {
			
			// 디렉토리 정보
			System.out.println(dir.getName());			//AAA, 폴더명
			System.out.println(dir.isFile());			//false, 파일?
			System.out.println(dir.isDirectory());		//true, 폴더?
			System.out.println(dir.length());			//0, 폴더 자신의 크기를 물어보는거지 안에 있는 것들을 합하여 보여주진 않는다.
			
			System.out.println(dir.getAbsolutePath());	//절대경로, root부터 시작 
			System.out.println(dir.getPath());			//참조경로, path에 적은 경로 그대로 리턴
			
			System.out.println(dir.getParent());		//부모폴더 경로(만) 반환 (확인)
			System.out.println(dir.getParentFile());	//부모폴더 참조 객체 반환 (조작)
			
		} else {
			System.out.println("디렉토리 없음.");
		}
		
		
		
		
	}

}
