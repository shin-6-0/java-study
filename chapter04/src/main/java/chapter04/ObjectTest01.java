package chapter04;

public class ObjectTest01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Point point = new Point();
		
		Class klass = point.getClass();//reflection이라는 기술. 
		
		System.out.println(point.getClass());
		System.out.println(point.hashCode());//address X address 기반의 해싱값임
	
		System.out.println(point.toString());//getClass() +"@" +hashCode()
		System.out.println(point);
	}

}
