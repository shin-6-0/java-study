package prob5;

public class MyStack {
	private String[] arr=null;
	private int len;
	
	public MyStack(int i) {
		this.arr=new String[100000];
		this.len=i;
	}

	public void push(String string) {
		for(int i=0;i<100000;i++) {
			if(this.arr[i]==null) {
				this.arr[i]=string;
				if(i>=this.len) {
					this.len++;
				}
				break;
			}
		}
	}
	public String pop() {
		String print="";
			try {
				for(int i=0;i<100000;i++) {
					if(this.arr[i]==null&&i!=0) {
						print=arr[i-1];
						arr[i-1]=null;
						break;
					}else if(this.arr[i]==null&&i==0) {
						throw new MyStackException();
					}
				}
			}catch(MyStackException e) {
				e.printStackTrace();
			}
			/*
			 * if(this.arr[i]==null&&i!=0) { print=arr[i-1]; arr[i-1]=null; break; }else
			 * if(this.arr[i]==null&&i==0) {
			 * 
			 * }
			 */

		//print = this.arr[this.len-1];
		this.len=this.len-1;
		return print;		
	}
	
	public boolean isEmpty() {
		if(this.len!=0) {
			return false;
		}else {
			return true;
		}
	}
	
	public void print() {
		for(int i=0;i<100;i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}


	
}