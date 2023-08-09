package chapter03;

import mypackage.Value;

public class SwapTest03 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Value a = new Value(10);
		Value b = new Value(20);
		
		System.out.println("a="+a.val+", b="+b.val);
		
		//swap함수생성
		swap(a,b); //call by Reference를 쓰기 위해 Value라는 객체 생성했음
		
		System.out.println("a="+a.val+", b="+b.val);
	}
	public static void swap(Value a,Value b) {
		int temp=b.val;
		b.val=a.val;
		a.val=temp;
	}
}

