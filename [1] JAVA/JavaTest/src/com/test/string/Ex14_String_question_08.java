package com.test.string;

public class Ex14_String_question_08 {
	
	public static void main(String[] args) {
		
		// 요구사항 08
		
		String content = "안녕~ 길동아~ 잘가~ 길동아~";
		String word = "길동";
		int count = 0;
		int index = -word.length();
		while (true) {
			index = content.indexOf(word, index + word.length());
			if(index > -1) {
				count++;
			} else {
				break;
			}
			
		}
		System.out.printf("\'%s\'을 총 %d회 발견했습니다.\r\n", word, count);

	}

}
