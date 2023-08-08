package prob05;

import java.util.Random;
import java.util.Scanner;

public class Prob05 {

	public static void main(String[] args) {
		Scanner sc = new Scanner( System.in );
		// 정답 랜덤하게 만들기
		Random random = new Random();
		int correctNumber = random.nextInt( 100 ) + 1;
		//System.out.println(correctNumber);
		System.out.println("수를 결정하였습니다. 맞추어보세요.");
		System.out.println("1-100");
		int round=1;
		while( true ) {
			
			/* 게임 작성 */


			System.out.print(round+">>");
			int input=sc.nextInt();
			if(correctNumber>input) {
				System.out.println("더 높게");
				round++;
			}else if(correctNumber<input) {
				System.out.println("더 낮게");
				round++;
			}else {
				//새 게임 여부 확인하기
				System.out.print( "다시 하겠습니까(y/n)>>" );
				String answer = sc.next();
				if( "y".equals( answer ) == false ) {
					break;
				}
			}

		}
		
		sc.close();
	}

}