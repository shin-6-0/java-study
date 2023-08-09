package chapter03;

public class Goods {
	public static int countOfGoods =0;
	String name;
	int price;
	int countStock;
	int countSold;
	
	public Goods() {
		//Goods.countOfGoods++;//생성자 한번 실행시마다 ++ 됨
		countOfGoods++; //내부에서 쓸 때는 생략가능
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		if(price<0) {
			this.price=0;
		}
		this.price = price;
	}
	public int getCountStock() {
		return countStock;
	}
	public void setCountStock(int countStock) {
		this.countStock = countStock;
	}
	public int getCountSold() {
		return countSold;
	}
	public void setCountSold(int countSold) {
		this.countSold = countSold;
	}
	
	
}
