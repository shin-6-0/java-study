package com.poscodx.paint.shape;

import com.poscodx.paint.i.Drawable;

public abstract class Shape implements Drawable{
	private String lineColor;
	private String fillCollor;
	
	public abstract void draw();
	
	public String getLineColor() {
		return lineColor;
	}
	public void setLineColor(String lineColor) {
		this.lineColor = lineColor;
	}
	public String getFillCollor() {
		return fillCollor;
	}
	public void setFillCollor(String fillCollor) {
		this.fillCollor = fillCollor;
	}
	
	
}
