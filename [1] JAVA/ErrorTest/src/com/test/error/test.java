package com.test.error;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Calendar;


public class test {
	
	public static void main(String[] args) {
		showList();
		select();
	}

	private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	
//	// 뽑아낼 날짜 (현재)
//	Calendar now = Calendar.getInstance();
//	now.set(2020, 3, 19);
	
	static String filename= String.format("D:\\HotelFive\\data\\숙박\\하우스키핑 주문내역_%tF.txt", Calendar.getInstance());
	static File file = new File(filename);
	static String pathHk = "D:\\HotelFive\\data\\숙박\\하우스키핑 목록.txt";
	static File fileHk = new File(pathHk);
	static File fileLogi = new File("D:\\HotelFive\\data\\숙박\\숙박내역.txt");

	static ArrayList<String[]> hkList = new ArrayList<String[]>();			// 하우스키핑 목록 저장
	static ArrayList<String[]> logiList = new ArrayList<String[]>();		// 현재 날짜 숙박 내역만 저장
	static ArrayList<String[]> hkOrderList = new ArrayList<String[]>();		// 처리되지 않은 하우스키핑 목록
	static ArrayList<String[]> hkCompleteList = new ArrayList<String[]>();	// 처리된 하우스키핑 목록
	
	public static void showList() {
		
		if (file.exists() && fileHk.exists() && fileLogi.exists()) {
			try {
				
				Calendar now = Calendar.getInstance();
				
				BufferedReader fileReader = new BufferedReader(new FileReader(file));		// 하우스키필 주문내역 읽기
				BufferedReader fileHkReader = new BufferedReader(new FileReader(fileHk));	// 하우스키핑 목록 읽기
				BufferedReader fileLogiReader = new BufferedReader(new FileReader(fileLogi));	// 숙박내역 목록 읽기
				
				String line = null;
				
				// 하우스키핑 목록 저장
				while ((line = fileHkReader.readLine()) != null) {
					hkList.add(line.split("■"));
				}
				
				fileHkReader.close();
				
				// 숙박내역 저장
				while ((line = fileLogiReader.readLine()) != null) {
					String[] List = line.split("■");
					
					// 숙박 목록 날짜
					Calendar cstartbuff2 = Calendar.getInstance();
					Calendar cendbuff2 = Calendar.getInstance();
					
					String[] startbuff2 = List[2].split("-");
					String[] endbuff2 = List[3].split("-");
					
					cstartbuff2.set(Integer.parseInt(startbuff2[0])
							, Integer.parseInt(startbuff2[1])-1
							, Integer.parseInt(startbuff2[2]));
					cendbuff2.set(Integer.parseInt(endbuff2[0])
							, Integer.parseInt(endbuff2[1])-1
							, Integer.parseInt(endbuff2[2]));
					
					// 선택날짜 안에 해당하는 숙박목록들 뽑아내서 logiList에 저장
					if((cstartbuff2.getTimeInMillis() <= now.getTimeInMillis() 
							&& cendbuff2.getTimeInMillis() >= now.getTimeInMillis())) {
						logiList.add(List);
					}
				}
				fileLogiReader.close();
				
				// 하우스키핑 주문 내역 받아옴
				while ((line = fileReader.readLine()) != null) {
					String[] List = line.split("■");
					
					// 처리가 되지 않은(false) 리스트를 hkOrderList에 저장
					if (List[3].equals("false")) {
						hkOrderList.add(List);
					}
					// 처리된(true) 리스트를 hkCompleteList에 저장
					else {
						hkCompleteList.add(List);					
					}
				}
				fileReader.close();
				
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("ERROR: admin.HKOrderList.showList()");
			}
			
			System.out.println();
			System.out.println("\t\t\t============================================");
			System.out.println("\t\t\t[No.]\t[객실]\t[요청사항]\t[처리내역]");
			System.out.println("\t\t\t============================================");
			for (int i=0; i<hkOrderList.size(); i++) {
				String listNum = null;
				for(int j=0; j<hkList.size(); j++) {
					if(hkOrderList.get(i)[2].equals(hkList.get(j)[0])) {
						listNum = hkList.get(j)[1];
					}
				}
				if(listNum.length()>=4) {
					System.out.printf("\t\t\t%d\t%s\t%s\t%s\r\n"
							, i+1, hkOrderList.get(i)[0], listNum, hkOrderList.get(i)[3].equals("false") ? "미완료" : "완료");						
				} else {
					System.out.printf("\t\t\t%d\t%s\t%s\t\t%s\r\n"
							, i+1, hkOrderList.get(i)[0], listNum, hkOrderList.get(i)[3].equals("false") ? "미완료" : "완료");						
				}
			}
			System.out.println("\t\t\t============================================");
				
			} else {
				System.out.println("파일이 존재하지 않습니다.");
			}
		
	}
	
	public static void select() {
		
		System.out.println();
		System.out.println("\t\t\t============================================");
//		System.out.println("\t\t\t\t1.  정렬 기준 변경  	");		//????
		System.out.println("\t\t\t\t1.  객실 번호 검색   	");
		System.out.println("\t\t\t\t2.  객실 선택 및 처리 내역 수정   	");
		System.out.println("\t\t\t\t3.  이전 메뉴   	");
		System.out.println("\t\t\t============================================");
		System.out.print("\t\t\t번호 입력 : ");
		
		//여기서 입력을 받자!
		try {
			int input = Integer.parseInt(reader.readLine());
			
			switch(input) {
//			case 1:
//				break;
			case 1:
				search();
				break;
			case 2:
				complete();
				break;
			case 3:
				hkList.clear();
				logiList.clear();
				hkOrderList.clear();
				hkCompleteList.clear();
				break;
			default:
				showList();
				select();
			}
			
		} catch(Exception e) {
			System.out.println("ERROR: admin.HKOrderList.select()");
		}
	}
	
	public static void search() {
		
		System.out.println();
		System.out.println("\t\t\t============================================");
		System.out.print("\t\t\t객실 번호 입력 : ");
		
		try {
			
			boolean check = false;
			ArrayList<Integer> index = new ArrayList<Integer>();
			String input = reader.readLine();
			for (int i=0; i<hkOrderList.size(); i++) {
				if(input.equals(hkOrderList.get(i)[0])) {
					check = true;
					index.add(i);
				}
			}
			
			if (check) {
				System.out.println();
				System.out.println("\t\t\t============================================");
				System.out.println("\t\t\t[No.]\t[객실]\t[요청사항]\t[처리내역]");
				System.out.println("\t\t\t============================================");
				for (int i=0; i<index.size(); i++) {
					String listNum = null;
					int orderindex = index.get(i);
					for(int j=0; j<hkList.size(); j++) {
						if(hkOrderList.get(orderindex)[2].equals(hkList.get(j)[0])) {
							listNum = hkList.get(j)[1];
						}
					}
					if(listNum.length()>=4) {
						System.out.printf("\t\t\t%d\t%s\t%s\t%s\r\n"
								, i+1, hkOrderList.get(orderindex)[0], listNum
								, hkOrderList.get(orderindex)[3].equals("false") ? "미완료" : "완료");						
					} else {
						System.out.printf("\t\t\t%d\t%s\t%s\t\t%s\r\n"
								, i+1, hkOrderList.get(orderindex)[0], listNum
								, hkOrderList.get(orderindex)[3].equals("false") ? "미완료" : "완료");						
					}
				}
				System.out.println("\t\t\t============================================");
			} else {
				System.out.println();
				System.out.println("\t\t\t해당사항 없는 객실입니다.");
			}
			
			select();
			
		} catch (Exception e) {
			System.out.println("ERROR: admin.HKOrderList.search()");
		}
	}
	
	public static void complete() {
		
		System.out.println();
		System.out.println("\t\t\t============================================");
		System.out.println("\t\t\t[No.]\t[객실]\t[요청사항]\t[처리내역]");
		System.out.println("\t\t\t============================================");
		for (int i=0; i<hkOrderList.size(); i++) {
			String listNum = null;
			for(int j=0; j<hkList.size(); j++) {
				if(hkOrderList.get(i)[2].equals(hkList.get(j)[0])) {
					listNum = hkList.get(j)[1];
				}
			}
			if(listNum.length()>=4) {
				System.out.printf("\t\t\t%d\t%s\t%s\t%s\r\n"
						, i+1, hkOrderList.get(i)[0], listNum, hkOrderList.get(i)[3].equals("false") ? "미완료" : "완료");						
			} else {
				System.out.printf("\t\t\t%d\t%s\t%s\t\t%s\r\n"
						, i+1, hkOrderList.get(i)[0], listNum, hkOrderList.get(i)[3].equals("false") ? "미완료" : "완료");						
			}
		}
		
		try {
			
			boolean check = true;
			
			while (check) {
				
				System.out.println();
				System.out.println("\t\t\t============================================");
				System.out.println("\t\t\t수정을 마치시려면 0을 입력해주세요.");
				System.out.print("\t\t\t수정할 번호 입력 : ");
				
				String index = reader.readLine();
				
				int indexNum = Integer.parseInt(index) - 1;
				
				// 0 입력시 수정 완료
				if(index.equals("0")) {
					System.out.println("\t\t\t수정을 마치겠습니다.");
					check = false;
				}
				
				// 유효한 인덱스 범위 내 입력시
				else if(indexNum < hkOrderList.size()) {
					
					// 입력된 인덱스의 정보 출력
					System.out.println();
					System.out.println("\t\t\t============================================");
					System.out.println("\t\t\t[No.]\t[객실]\t[요청사항]\t[처리내역]");
					System.out.println("\t\t\t============================================");
				
					String listNum = null;
					for(int j=0; j<hkList.size(); j++) {
						if(hkOrderList.get(indexNum)[2].equals(hkList.get(j)[0])) {
							listNum = hkList.get(j)[1];
						}
					}
					
					if(listNum.length()>=4) {
						System.out.printf("\t\t\t%d\t%s\t%s\t%s\r\n"
								, indexNum+1, hkOrderList.get(indexNum)[0], listNum
								, hkOrderList.get(indexNum)[3].equals("false") ? "미완료" : "완료");						
					} else {
						System.out.printf("\t\t\t%d\t%s\t%s\t\t%s\r\n"
								, indexNum+1, hkOrderList.get(indexNum)[0], listNum
								, hkOrderList.get(indexNum)[3].equals("false") ? "미완료" : "완료");						
					}
					
					// 완료 처리 여부 받기
					System.out.println("\t\t\t============================================");
					System.out.print("\t\t\t완료 처리를 하시겠습니까?(y/n)");
					String input = reader.readLine();
					
					// 대문자로 받을 떄를 대비하여 소문자로 변환
					input.toLowerCase();
					
					// y 입력시
					if (input.equals("y")) {
						
						// 처리 완료 리스트에 추가
						String[] buff = {hkOrderList.get(indexNum)[0], hkOrderList.get(indexNum)[1], hkOrderList.get(indexNum)[2], "true"};
						hkCompleteList.add(buff);
						
						// 미완료 리스트에서는 삭제
						hkOrderList.remove(indexNum);		
						
						int lastCompleteIndex = hkCompleteList.size() - 1;
						
						// 완료 내역 한번 더 출력
						System.out.println();
						System.out.println("\t\t\t============================================");
						System.out.println("\t\t\t[No.]\t[객실]\t[요청사항]\t[처리내역]");
						System.out.println("\t\t\t============================================");
						
						if(listNum.length()>=4) {
							System.out.printf("\t\t\t%d\t%s\t%s\t%s\r\n"
									, indexNum+1, hkCompleteList.get(lastCompleteIndex)[0], listNum
									, hkCompleteList.get(lastCompleteIndex)[3].equals("false") ? "미완료" : "완료");						
						} else {
							System.out.printf("\t\t\t%d\t%s\t%s\t\t%s\r\n"
									, indexNum+1, hkCompleteList.get(lastCompleteIndex)[0], listNum
									, hkCompleteList.get(lastCompleteIndex)[3].equals("false") ? "미완료" : "완료");						
						}
						
						System.out.println("\t\t\t============================================");
						System.out.println("\t\t\t수정이 완료되었습니다.");
						
					}
					
					// n 입력 시
					else if (input.equals("n")) {
						System.out.println("\t\t\t수정을 취소하였습니다.");
					}
					
					// y, n이 아닌 다른 값 입력 시
					else {
						System.out.println("\t\t\t잘못된 값을 입력하였습니다.");
					}
				}
				
				// 유효하지 않은 범위의 인덱스 입력시
				else {
					System.out.println("\t\t\t잘못된 인덱스를 입력하였습니다.");
				}
			}
		} catch (Exception e) {
			System.out.println("ERROR: admin.HKOrderList.complete()2");
		}
		
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(file));
			
			for (int i=0; i<hkCompleteList.size(); i++) {
				String[] list = hkCompleteList.get(i);
				String buff = list[0] + "■" + list[1] + "■" + list[2] + "■" + list[3] + "\r\n";
				writer.append(buff);
			}
			
			for (int i=0; i<hkOrderList.size(); i++) {
				String[] list = hkOrderList.get(i);
				String buff = list[0] + "■" + list[1] + "■" + list[2] + "■" + list[3] + "\r\n";
				writer.append(buff);
			}
			
			writer.close();

			select();
		} catch (Exception e) {
			System.out.println("ERROR: admin.HKOrderList.complete()2");
		}
		
	}
	
}
