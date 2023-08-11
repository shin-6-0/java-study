package prob6;

public class RectTriangle extends Shape {
	private double width;
	private double height;
	public RectTriangle(double width, double height) {
		super();
		this.width = width;
		this.height = height;
	}
	@Override
	public double getArea() {
		return (width*height*0.5);
	}

	@Override
	public double getPerimeter() {
		return (width+height+Math.sqrt(height*height+width*width));
	}
	@Override
	public void resize(double d) {
		this.width=width*d;
		this.height=height*d;
	}

}
