package com.poscodx.paint.main;

import com.poscodx.paint.i.Drawable;
import com.poscodx.paint.point.ColorPoint;
import com.poscodx.paint.point.Point;
import com.poscodx.paint.shape.Circle;
import com.poscodx.paint.shape.Rect;
import com.poscodx.paint.shape.Shape;
import com.poscodx.paint.shape.Triangle;
import com.poscodx.paint.text.GraphicText;

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
		
		//instanceof 연산자 Test
		System.out.println(circle instanceof Object);
		System.out.println(circle instanceof Shape);
		System.out.println(circle instanceof Circle);
		
		//오류:연산자 우측항이 클래스 인 경우, 레퍼런스 하고 있는 class 타입의 hierachy(계층) 상의 하위와 상위만
		//		instanceof 연산자를 사용할 수 있다. 
		//System.out.println(circle instanceof Rect);
		
		/*	연산자 우측항이 인터페이스인 경우,
		 * 	Hierachy 상관 없이 instancof 연산자를 사용할 수 있다. 
		*/
		System.out.println(circle instanceof Runnable);
		System.out.println(circle instanceof Drawable);
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
