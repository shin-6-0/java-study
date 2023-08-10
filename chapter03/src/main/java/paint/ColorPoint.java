package paint;

public class ColorPoint extends Point {
	
	private String color;

	public ColorPoint(int x, int y, String color) {
		super(x, y);
		this.color = color;
	}

	public ColorPoint() {
		// TODO Auto-generated constructor stub
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
	
	@Override
	public void show() {
		System.out.println("점[x="+getX()+", y="+getY()+", color = "+color+"]을 그렸습니다.");
	}
	
	
}
