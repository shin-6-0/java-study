package prob05;

public class Account {
	private String accountNo;
	private int balance;

	public Account(String string) {
		this.accountNo=string;
		System.out.println(accountNo+" 개좌가 개설되었습니다.");
	}

	public String getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public void save(int i) {
		this.balance=i;
		
	}

	public void deposit(int i) {
		this.balance-=i;
	}
}
