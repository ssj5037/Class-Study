package com.test.object;

public class Macaron {
	
    private int size;
    private String color;
    private int thickness;
    
//    public void setSize() {
//    	this.size = (int)(Math.random() * 11 + 5);
//    }
    
    
    public void setSize(int size) {
    	this.size = size;
    }
    
    public int getSize() {
    	return size;
    }
    
//    public void setColor() {
//    	String[] colorName = {"red", "blue", "yellow", "white", "pink", "purple", "green", "black"};
//    	int index = (int)(Math.random() * colorName.length);
//    	this.color = colorName[index];
//    }
    
    
    public void setColor(String color) {
    	this.color = color;
    }
    
    public String getColor() {
    	return color;
    }
    
//    public void setThickness() {
//    	this.thickness = (int)(Math.random() * 20 + 1);
//    }
    
    
    public void setThickness(int thickness) {
    	this.thickness = thickness;
    }
    
    public int getThickness() {
    	return thickness;
    }
    
    
}
