package prob3;

import java.util.Scanner;

public class Prob3 {
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		/* 코드 작성 */
		System.out.print("숫자를 입력하세요 : ");
		int input=sc.nextInt();
		int output=0;
		if(input%2==0) {
			for(int i=0;i<=input;i+=2) {
				output+=i;
			}
			System.out.println("결과 값 : "+output);
		}else {
			for(int j=1;j<=input;j+=2) {
				output+=j;
			}
			System.out.println("결과 값 : "+output);
		}
		
		sc.close();
	}
}
