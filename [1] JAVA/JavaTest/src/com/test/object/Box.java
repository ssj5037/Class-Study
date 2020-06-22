package com.test.object;

public class Box {

	int index = 10;
    private Macaron[] list = new Macaron[index];
    private boolean[] result = new boolean[index]; 
    private int ok=0, no=0;


	String[] colorName = {"red", "blue", "yellow", "white", "pink", "purple", "green", "black"};
	int colorIndex = (int)(Math.random() * colorName.length);
    
    public void cook() {
        for(int i=0; i<list.length; i++) {
        	list[i] = new Macaron();
        	list[i].setColor(colorName[colorIndex]);
        	list[i].setSize((int)(Math.random() * 11 + 5));
        	list[i].setThickness((int)(Math.random() * 20 + 1));
        }
        System.out.printf("마카롱을 %d개 만들었습니다.\r\n", list.length);
        System.out.println();
    }
    
    public void check() {
    	for(int i=0; i<list.length; i++) {
    		if ((list[i].getColor() == "black")
    				|| (list[i].getSize() < 8 || list[i].getSize() > 14)
    				|| (list[i].getThickness() < 3 || list[i].getThickness() > 18)) {
    			result[i] = false;
    			no++;
    		} else {
        		result[i] = true;
        		ok++;
    		}
    	}
    	System.out.println("[박스 체크 결과]");
    	System.out.printf("QC 합격 개수 : %d개\r\n", ok);
    	System.out.printf("QC 불합격 개수 : %d개\r\n", no);
    	System.out.println();
    }
    
    public void list() {
    	System.out.println("[마카롱 목록]");
    	for(int i=0; i<list.length; i++) {
    		System.out.printf("%d번 마카롱 : %dcm(%s, %dmm) : %s\r\n"
    				, i+1
    				, list[i].getSize()
    				, list[i].getColor()
    				, list[i].getThickness()
    				, result[i] == true ? "합격" : "불합격");
    	}
    }

}
