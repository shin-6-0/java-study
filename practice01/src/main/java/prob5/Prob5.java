package prob5;
import java.util.*;
public class Prob5 {

	public static void main(String[] args) {
		Scanner sc= new Scanner (System.in);
		for(int i=1;i<100;i++) {
			int num2=i%10;
			int num1=i/10;
			if(num2%3==0&&num2!=0) {
				System.out.print(i+" ");
				if(num1!=0&&num1%3==0) {
					System.out.print("짝");
				}
				if(num2%3==0) {
					System.out.print("짝");
				}
				System.out.println();
			}

		}
	}
}
