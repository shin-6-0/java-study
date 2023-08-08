package prob01;

import java.util.Scanner;

public class Prob01 {
	public static void main(String[] args) {
		Scanner sc = new Scanner( System.in  );

		final int[] MONEYS = { 50000, 10000, 5000, 1000, 500, 100, 50, 10, 5, 1 };

		/* 코드 작성 */
		System.out.print("금액: ");
		int money=sc.nextInt();
		for(int i=0;i<MONEYS.length;i++) {
			if(money/MONEYS[i]!=0) {
				System.out.println(MONEYS[i]+"원: "+money/MONEYS[i]+"개");
				money-=(money/MONEYS[i])*MONEYS[i];
			}
		}
		
		sc.close();
 	}
}