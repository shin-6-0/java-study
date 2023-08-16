package prob03;

import java.util.Objects;

public class Money {


	private int amount;
	
	
	public Money() {}

	/* 코드 작성 */
	public Money(int i) {
		this.amount=i;
	}
	
	
	
	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public Object add(Money three) {
		Money m = new Money(three.getAmount()+this.amount);
		return m;
	}

	public Object minus(Money two) {
		if(two.getAmount()>=this.amount) {
			Money m = new Money(two.getAmount()-this.amount);
			return m;
		}else {
			Money m = new Money(this.amount-two.getAmount());
			return m;
		}
	}
	public Object multiply(Money two) {
		Money m = new Money(two.getAmount()*this.amount);
		return m;

	}	
	public Object devide(Money five) {
		if(five.getAmount()>=this.amount) {
			Money m = new Money(five.getAmount()/this.amount);
			return m;
		}else {
			Money m = new Money(this.amount/five.getAmount());
			return m;
		}
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(amount);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Money) {
			Money other = (Money) obj;
			if(this.amount==other.amount) {
				return true;
			}else {
				return false;
			}
		}else {
			return false;
		}
	}


	
}
