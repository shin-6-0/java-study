package prob02;

public class Add implements Arithmetic {

	private int a;
	private int b;
	
	public Add() {}

	public Add(int a, int b) {
		super();
		this.a = a;
		this.b = b;
	}



	@Override
	public int calculate(int a, int b) {
		// TODO Auto-generated method stub
		return a+b;
	}

}
