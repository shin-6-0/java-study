package prob02;

import java.util.Scanner;

public class Prob02 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int[] intArray = new int[ 5 ];
		double sum = 0;
		System.out.println("5개의 숫자를 입력하세요.");
		/* 키보드에서 배열 크기만큼 입력 받아 배열에 저장하는 코드 */
		for(int i=0;i<intArray.length;i++) {
			intArray[i]=sc.nextInt();
			/* 배열에 저장된 정수 값 더하기 */
			sum+=intArray[i];
		}
		
		/* 출력 */
		double avg=sum/5;
		System.out.print("평균은 "+avg+"입니다.");
		/* 자원정리 */
		sc.close();
	}
}
