package prob04;

public class Depart extends Employee {
	private String part;

	public Depart(String name, int salary,String part) {
		super();
		setName(name);
		setSalary(salary);
		this.part = part;
	}
	public void getInformation() {
		System.out.println( "이름:" + super.getName() + " 연봉:" + super.getSalary()+" 부서:"+part );
	}
	
}
