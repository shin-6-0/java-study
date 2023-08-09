package prob02;

public class Goods {
	private String name;
	private int price;
	private int stockCount;
	
	public Goods() {}
	public Goods(String name, int price, int stockCount) {
		super();
		this.name = name;
		this.price = price;
		this.stockCount = stockCount;
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
		this.price = price;
	}
	public int getStockCount() {
		return stockCount;
	}
	public void setStockCount(int stockCount) {
		this.stockCount = stockCount;
	}
	public void printGoods() {
		System.out.println(name+"(가격:"+price+"원)이 "+stockCount+"개 입고 되었습니다.");
	}
	
}
