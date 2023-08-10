package prob05;

public class MyBase extends Base {
	public void service(String text) {
		if(text.equals("낮")) {
			System.out.println("낮에는 열심히 일하자!");
		}else if(text.equals("오후")) {
			System.out.println("오후도 낮과 마찬가지로 일해야 합니다.");
		}else if(text.equals("밤")) {
			super.night();
		}
	}
}
