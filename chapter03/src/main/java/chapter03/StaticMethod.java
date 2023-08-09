package chapter03;

public class StaticMethod {
	int n;
	static int m;
	
	void f1() {
		n=10;	
	}
	
	void f2() {
		//같은 클래스의 클래스(static) 변수 접근에서는 클래스 이름 생략 가능
		m=20;
	}
	
	void f3() {
		f2();
	}
	void f4() {
		//StaticMethod.s1(); 이렇게 해야 원래 규칙
		s1(); //같은 클래스의 클래스(static) 변수 접근에서는 클래스 이름 생략 가능
	}
	static void s1() {
		//n=10;
		//에러 : static method 에서는 instance 변수 접근 불가 
	}
	static void s2() {
		//f1();
		//에러 : static method 에서는 instance 변수 접근 불가 
	}
	static void s3() {
		StaticMethod.m=10;
		m=20;//StaticMethod. 생략가능 - 같은 클래스의 클래스(static) 변수 접근에서는 클래스 이름 생략 가능
	}
	static void s4() {
		//StaticMethod. 생략가능 - 같은 클래스의 클래스(static) 변수 접근에서는 클래스 이름 생략 가능

		StaticMethod.s1();
		s1();
	}

}
