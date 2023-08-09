package chapter03;

public class SwapTest02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a=10;
		int b=20;
		
		System.out.println("a="+a+", b="+b);
		
		//swap함수생성
		swap(a,b); //call by value로는 변경되지않음.
		
		System.out.println("a="+a+", b="+b);
	}
	public static void swap(int a,int b) {
		int temp=b;
		b=a;
		a=temp;
	}

}
