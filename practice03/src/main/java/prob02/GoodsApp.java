package prob02;

import java.util.Scanner;

public class GoodsApp {
	private static final int COUNT_GOODS = 3;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		Goods[] goods = new Goods[COUNT_GOODS];

		// 상품 입력

		for(int i=0;i<COUNT_GOODS;i++) {
			String line = scanner.nextLine();
			String[] infos = line.split(" ");
			String name = infos[0];
			int price = Integer.parseInt(infos[1]);
			int count = Integer.parseInt(infos[2]);
			goods[i]=new Goods();
			goods[i].setName(name);
			goods[i].setPrice(price);
			goods[i].setStockCount(count);
		}
		
		
		
		// 상품 출
		for(int i=0;i<COUNT_GOODS;i++) {
			goods[i].printGoods();
		}
		
		// 자원정리
		scanner.close();
	}
}
