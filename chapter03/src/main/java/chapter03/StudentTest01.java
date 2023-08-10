package chapter03;

public class StudentTest01 {

	public static void main(String[] args) {
		Student s = new Student();
		
		Person p = s;//Upcasting(암시적, Implicity)
		Student s2=(Student)p;//Downcasting(명시적, Explicity)
	}

}
