package com.test.string;

public class Ex14_String_question_06 {

	public static void main(String[] args) {
		
		// 요구사항 06
		
		int frontBlank = -1;
		int backBlank = -1;
		
		String txt = "     하나     둘     셋     ";
		System.out.println("원본 문자열 : \"" + txt + "\"");
		
		for (int i=0; i<txt.length(); i++) {
			if(txt.charAt(i) != ' ') {
				frontBlank = i;
				break;
			}
		}
		
		for (int i=txt.length()-1; i>=0; i--) {
			if(txt.charAt(i) != ' ') {
				backBlank = i;
				break;
			}
		}
		
		txt = txt.substring(0, frontBlank) + txt.replace(" ", "") + txt.substring(backBlank+1);
		System.out.printf("결과 문자열 : \"%s\"", txt);
	}
}
