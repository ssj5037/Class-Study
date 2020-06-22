package com.test.object;

public class BallPointPen {

	private double thickness;
	private String color;
	
	public void setThickness(double thickness) {
		this.thickness = thickness;
	}
	public void setColor(String color) {
		this.color = color;
	}
	
	public String info() {
		return color + " 색상 " + thickness +"mm";
	}
}
