package com.test.object;

public class Packer {

	private static int pencilCount;
	private static int eraserCount;
	private static int ballPointPenCount;
	private static int rulerCount;
	
	void packing(Pencil pencil) {
		System.out.printf("포장 전 검수 : %s 진하기 연필입니다.\r\n", pencil.info());
		System.out.println("포장을 완료했습니다.\r\n");
		pencilCount++;
	}
	
	void packing(Eraser eraser) {
		System.out.printf("포장 전 검수 : %s 사이즈 지우개입니다.\r\n", eraser.info());
		System.out.println("포장을 완료했습니다.\r\n");
		eraserCount++;
	}
	
	void packing(BallPointPen ballPointPen) {
		System.out.printf("포장 전 검수 : %s 볼펜입니다.\r\n", ballPointPen.info());
		System.out.println("포장을 완료했습니다.\r\n");
		ballPointPenCount++;
	}
	
	void packing(Ruler ruler) {
		System.out.printf("포장 전 검수 : %s 입니다.\r\n", ruler.info());
		System.out.println("포장을 완료했습니다.\r\n");
		rulerCount++;
	}
	
	void countPacking(int type) {
		System.out.println("==============");
		System.out.println("  포장 결과");
		System.out.println("==============");
		if(type == 0) {
			System.out.printf("연필 %d회\r\n", pencilCount);
			System.out.printf("지우개 %d회\r\n", eraserCount);
			System.out.printf("볼펜 %d회\r\n", ballPointPenCount);
			System.out.printf("자 %d회\r\n", rulerCount);
		} else if (type == 1) {
			System.out.printf("연필 %d회\r\n", pencilCount);
		} else if (type == 2) {
			System.out.printf("지우개 %d회\r\n", eraserCount);
		} else if (type == 3) {
			System.out.printf("볼펜 %d회\r\n", ballPointPenCount);
		} else if (type == 4) {
			System.out.printf("자 %d회\r\n", rulerCount);
		}
		System.out.println();
	}
}
