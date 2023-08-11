package chapter04;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTest {

	public static void main(String[] args) {
		Date now = new Date();
		System.out.println(now);
		
		printDate01(now);
		printDate02(now);
	}

	private static void printDate02(Date d) {
		//년도(+1900을 해야함)
		int year=d.getYear();
		
		//월(0~11 +1)
		int month = d.getMonth();
		
		//일
		int date = d.getDate();
		
		//시
		int hours = d.getHours();
		
		//분
		int minute = d.getMinutes();
		
		//초
		int seconds = d.getSeconds();
		
		System.out.println(
				(year+1900)+"/"+(month+1)+"/"+date+" "+hours+":"+minute+":"+seconds
				);
	}

	private static void printDate01(Date d) {
		//2023-08-11 15:00:00 으로 출력
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MMdd hh:mm:ss");
		String date= sdf.format(d);
		System.out.println(date);
	}

}
