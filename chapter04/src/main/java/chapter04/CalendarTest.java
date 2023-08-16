package chapter04;

import java.util.Calendar;

public class CalendarTest {

	public final void m() {
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Calendar cal = Calendar.getInstance();
		printDate(cal);
		cal.set(Calendar.YEAR, 2023);
		cal.set(Calendar.MONTH, 11);//12월 세팅
		cal.set(Calendar.DATE, 25);
		printDate(cal);

		cal.set(2021, 8, 6);
		cal.add(Calendar.DATE, 1000);
		printDate(cal);
	}

	private static void printDate(Calendar cal) {
		final String[] DAYS = {"일","월","화","수","목","금","토"};
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH);//0 ~ 11, +1
		int date = cal.get(Calendar.DATE);
		int day = cal.get(Calendar.DAY_OF_WEEK);//1(일) ~ 7(토)
		int hour = cal.get(Calendar.HOUR);
		int minute = cal.get(Calendar.MINUTE);
		int second = cal.get(Calendar.SECOND);
		
		System.out.println(
				year +"/"+(month+1)+"/"+date+" "+DAYS[day-1]+"요일 "+
				hour+":"+minute+":"+second
				);
	}

}
