package com.test.collection;

import java.util.Arrays;

public class MyHashMap {

	// Case 1.
//	private String[] keyList;
//	private String[] valueList;
	
	// Case 2.
	private MapItem[] list;
	private int index;

	public MyHashMap() {
		this.list = new MapItem[10];
		this.index = 0;
	}
	
	void put(String key, String value) {
		int putFlag = 0;
		// 꽉 찼을 경우 길이 2배로 늘리기
		if(this.index >= this.list.length) {
			MapItem[] temp = new MapItem[this.list.length * 2];
			for (int i=0; i<this.list.length; i++) {
				temp[i].setKey(this.list[i].getKey());
				temp[i].setValue(this.list[i].getValue());
			}
			this.list = temp;
		}
		
		// 중복된 key가 있는지 확인하고, 있다면 값을 수정
		for(int i=0; i<this.index; i++) {
			if(key.equals(this.list[i].getKey())) {
				this.list[i].setValue(value);
				putFlag = 1;
				break;
			}
		}
		if(putFlag == 0) {
			// 새로운 key라면 key, value를 넣기
			this.list[this.index] = new MapItem(key, value);
			// 인덱스 1 추가
			this.index++;
		}
		

//		if (!containKey(key)) {
//			//추가될 새 아이템
//			MapItem item = new MapItem();
//			item.key = key;
//			item.value = value;
//			
//			this.list[this.index] = item;
//			this.index++;
//		} else {
//			//수정하기
//			for (int i=0; i<this.index; i++) {
//				if (this.list[i].key.equals(key)) {
//					this.list[i].value = value;
//					break;
//				}
//			}
//		}
		
	}
	
	String get(String key) {
		for (int i=0; i<this.index; i++) {
			if(key.equals(this.list[i].getKey())) {
				return this.list[i].getValue();
			} 
		}
		return null;
	}

	int size() {
		return this.index;
	}
	
	void remove(String key) {
		//0부터 끝까지 인덱스 돌리기
		for (int i=0; i<this.index; i++) {
			//돌리다가 입력된 key 발견시
			if(key.equals(this.list[i].getKey())) {
				//해당위치부터 끝까지 뒷방값을 앞으로 복사
				for(int j=i; j<this.index-1; j++) {
					this.list[j].setKey(this.list[j+1].getKey());
					this.list[j].setValue(this.list[j+1].getValue());
				}
				// shift 해준 후에 for문 빠져나가야 한다.
				break;
			} 
//			else {
//				break;
//			}
		}
		System.out.println(this.list[this.index] == null);
		this.index--;
		// 인덱스 줄이기
	}
	
	boolean containKey(String key) {
		for (int i=0; i<this.index; i++) {
			if(key.equals(this.list[i].getKey())) {
				return true;
			}
		}
		return false;
	}
	
	boolean containsValue(String value) {
		for (int i=0; i<this.index; i++) {
			if(value.equals(this.list[i].getValue())) {
				return true;
			}
		}
		return false;
	}
	
	void clear() {
		this.index = 0;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return Arrays.toString(this.list);
	}
	
}

class MapItem {
	private String key;
	private String value;
	
	public MapItem() {
		this.key = "";
		this.value = "";
	}
	
	public MapItem(String key, String value) {
		this.key = key;
		this.value = value;
	}
	
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.format("(%s,%s)", this.key, this.value);
	}
}
