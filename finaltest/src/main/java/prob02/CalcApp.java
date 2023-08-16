package prob02;

import java.util.Scanner;

public class CalcApp {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		while( true ) {
			System.out.print( "두 정수와 연산자를 입력하시오 >> " );
			String expression = scanner.nextLine();
			
			if( "quit".equals( expression ) ) {
				break;
			}
			
			String[] tokens = expression.split( " " );
			
			if( tokens.length != 3 ) {
				System.out.println( ">> 알 수 없는 식입니다.");
				continue;
			}
			int lValue=0,rValue=0;
			String operator="";
			try {
				lValue = Integer.parseInt( tokens[ 0 ] );
				rValue = Integer.parseInt( tokens[ 1 ] );
				operator = tokens[2];
			}catch(NumberFormatException e) {
				System.out.println(" 첫번째와 두번째는 숫자를 입력해야 합니다 : "+e);
			}
			
			Arithmetic arithmetic=null;
			if(operator.equals("+")) {
				arithmetic = new Add(lValue,rValue);
			}else if(operator.equals("-")) {
				arithmetic = new Sub(lValue,rValue);				
			}else if(operator.equals("*")) {
				arithmetic = new Mul(lValue,rValue);								
			}else if(operator.equals("/")) {
				arithmetic = new Div(lValue,rValue);									
			}
			
			
			/* 코드 작성 */
			
			int result = arithmetic.calculate(lValue, rValue);
			System.out.println( ">> " + result );
		}
		
		scanner.close();
	}
}