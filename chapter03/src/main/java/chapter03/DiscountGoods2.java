package chapter03;

import mypackage.Goods2;

public class DiscountGoods2 extends Goods2 {
	private float discountRate = 0.5f;
	
	int i = (int)10000000000L;
	
	public int getDiscountPrice() {
		//protected는 자식에서 접근 가능
		int discountPrice = (int)(discountRate*price);
		return discountPrice;
	}
}
