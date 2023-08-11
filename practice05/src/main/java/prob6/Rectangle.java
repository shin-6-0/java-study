package prob6;

public class Rectangle extends Shape {
	private double width;
	private double height;
	
	
	public Rectangle(double width, double height) {
		super();
		this.width = width;
		this.height = height;
	}

	@Override
	public double getArea() {
		return (width*height);
	}

	@Override
	public double getPerimeter() {
		return (width+height)*2;
	}

	@Override
	public void resize(double d) {
		this.width=width*d;
		this.height=height*d;
	}

}
