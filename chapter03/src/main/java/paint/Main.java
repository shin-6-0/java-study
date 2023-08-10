package paint;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Point point1=new Point(10,20);
		/*
		 * point1.setX(10); point1.setY(20);
		 */
		
		draw(point1);
		//point1.disappear();
		point1.show(false);
		
		Point point2=new ColorPoint();
		//ColorPoint point2=new ColorPoint();
		
		point2.setX(20);
		point2.setY(20);
		
		//downCasting 
		//ColorPoint p = (ColorPoint)point2;
		((ColorPoint)point2).setColor("red");
		
		//point2.setColor("red");
		//drawColorPoint(point2);
		Rect rect = new Rect();
		draw(rect);
		
		Triangle triangle = new Triangle();
		draw(triangle);
		
		Circle circle = new Circle();
		draw(circle);
		
		draw(new GraphicText("Hello World"));
		
	}
	public static void draw(Drawable drawable) {
		drawable.draw();
	}
	/*
	 * public static void drawPoint(Point point) { point.show(); }
	 * 
	 * public static void drawShape(Shape shape) { shape.draw(); }
	 * 
	 * public static void drawRect(Rect rect) { rect.draw(); }
	 * 
	 * public static void drawTriangle(Triangle triangle) { triangle.draw(); }
	 */
	
	
	/*
	 * public static void drawColorPoint(ColorPoint colorPoint) { colorPoint.show();
	 * }
	 */
}
