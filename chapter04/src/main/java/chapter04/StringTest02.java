package chapter04;

public class StringTest02 {
	public static void main(String[] args) {
		//불변성(immutability)
		String s1= "abc";
		String s2= "def";
		String s3=s2;
		
		s2= s1.toUpperCase();
		String s4= s2.concat("??");
		
		String s5="!".concat(s2).concat("@");
		
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s3);
		System.out.println(s4);
		System.out.println(s5);
		
		System.out.println(equalsHello("Hello"));
		System.out.println(equalsHello(null));//null을 넣으면 null.equals가 되기 때문에 안전하지 못함

	}
	
	private static boolean equalsHello(String s) {
		return "Hello".equals(s);
	}
}
