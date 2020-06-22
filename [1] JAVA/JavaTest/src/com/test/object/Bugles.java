package com.test.object;

import java.util.Calendar;

public class Bugles {

	private int price;
	private int weight;
	private Calendar creationTime;
	private int expiration;
	
	
	// 가격 읽기
	public int getPrice() {
//		if(weight == 300) {
//			this.price = 850;
//		} else if(weight == 500) {
//			this.price = 1200;
//		} else if(weight == 850) {
//			this.price = 1950;
//		}
		return price;
	}
	
	// 유통기한 읽기
	public int getExpiration() {
//		if(weight == 300) {
//			creationTime.add(Calendar.DATE, 7);
//		} else if(weight == 500) {
//			creationTime.add(Calendar.DATE, 10);
//		} else if(weight == 850) {
//			creationTime.add(Calendar.DATE, 15);
//		}

//		System.out.printf("%d\r\n",creationTime.DATE);
		Calendar now = Calendar.getInstance();
		long expTick = creationTime.getTimeInMillis();
		long nowTick = now.getTimeInMillis();
		this.expiration = (int)((expTick - nowTick) / 1000 / 60 / 60 / 24);
//		if(expiration >= 0) this.expiration += 1;
		return expiration;
	}
	
	// 용량 쓰기
	public void setWeight(int weight) {
		if (weight == 300 || weight == 500 || weight == 850) {
			this.weight = weight;

			if(weight == 300) {
				this.price = 850;
				this.expiration = 7;
			} else if(weight == 500) {
				this.price = 1200;
				this.expiration = 10;
			} else if(weight == 850) {
				this.price = 1950;
				this.expiration = 15;
			}
			
		}
	}
	
	// 생산일자
	public void setCreationTime(String time) {
		int year = Integer.parseInt(time.substring(0,4));
		int month = Integer.parseInt(time.substring(5,7));
		int date = Integer.parseInt(time.substring(8,10));
		creationTime = Calendar.getInstance();
		creationTime.set(year, month-1, date);
//		System.out.printf("%tF", creationTime);
	}
	
	public void eat() {
		if(expiration >= 0) {
			System.out.println("과자를 맛있게 먹습니다.");
		} else {
			System.out.println("유통기한이 지나 먹을 수 없습니다.");
		}
	}
	
}
