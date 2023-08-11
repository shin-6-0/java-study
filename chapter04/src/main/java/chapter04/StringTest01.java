package chapter04;

public class StringTest01 {
	public static void main(String[] args) {
		// c:\temp
		System.out.println("c:\\temp");
		
		//"Hello" 를 출력하고싶을때
		System.out.println("\"Hello\"");
		
		//제어문모음
		/* control character
		 * \t : tab
		 * \r : carriage return
		 * \n : new line
		 * \b : bell
		 */
		
		//' 를 char에서 출력하고 싶을 때
		char c='\'';
		System.out.println(c);
		//String path="\\poscodx2023\\수업자료\\01.개요\\01.FullStack.png"; //이렇게 할 필요 없이
		//D drive일 경우 윈도우에서는 표시를 해줘야하는데, java 디렉토리가 D이면 알아서 드라이브를 붙여서 실행시킨다. 
		//String path="/poscodx2023/수업자료/01.개요/01.FullStack.png";
	}
}
