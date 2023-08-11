package exception;

import java.io.IOException;

public class MyClass {
	public void danger() throws IOException, MyException {
		System.out.println("Some code1...");
		System.out.println("Some code2...");
		
		if(3-3==0) {
			throw new MyException();
		}
		
		if(1-1==0) {
			throw new IOException(); //예외를 던질 수 있음을 메소드 뒤에 적어줘야한다.
		}
		
		System.out.println("Some code3..."); //오류를 던지고 나면 실행할 수 없다. 
		System.out.println("Some code4...");

	}
}
