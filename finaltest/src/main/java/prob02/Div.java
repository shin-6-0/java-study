package prob02;

public class Div implements Arithmetic {

	private int a;
	private int b;
	
	public Div() {}

	public Div(int a, int b) {
		super();
		this.a = a;
		this.b = b;
	}



	@Override
	public int calculate(int a, int b) {
		// TODO Auto-generated method stub
		if(a>=b) {
			return a/b;
		}else {
			return b/a;
		}
	}

}
