package chapter03;

import mypackage.Goods2;

public class Goods2App {

	public static void main(String[] args) {
		Goods2 goods = new Goods2();
		
		//public : 접근제한없음
		goods.name="camera";
		
		//protected : 같은 패키지에서 접근이 가능 - 다른패키지인경우 오류발생
		//			  더 중요한 접근 제어는 자식에서 접근이 가능하다
		//goods.price=10000;
		
		//default : 같은 패키지에서 가능 - 다른 패키지 인 경우 오류 발생
		//goods.countStock=10;
		
		//private는 같은 클래스 내에서만 접근이 가능하다.
		//goods.countSold=20;
	}
}
