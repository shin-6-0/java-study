package prob2;

public class SmartPhone extends MusicPhone {
	public void execute ( String function ) {
		if(function.equals("음악")) {
			System.out.println("다운로드해서 음악재생");
		}else if(function.equals("앱")) {
			System.out.println("앱실행");
		}else {
			super.execute(function);
		}
	}
}
