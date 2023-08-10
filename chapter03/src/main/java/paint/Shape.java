package paint;

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
