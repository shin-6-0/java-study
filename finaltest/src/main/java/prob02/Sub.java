package prob02;

public class Sub implements Arithmetic {

	private int a;
	private int b;
	
	public Sub() {}

	public Sub(int a, int b) {
		super();
		this.a = a;
		this.b = b;
	}



	@Override
	public int calculate(int a, int b) {
		// TODO Auto-generated method stub
		if(a>=b) {
			return a-b;
		}else {
			return b-a;
		}
	}

}
