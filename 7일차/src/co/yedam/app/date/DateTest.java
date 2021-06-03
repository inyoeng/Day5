package co.yedam.app.date;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

public class DateTest {

	public static void main(String[] args) {
		
		
		Date date = new Date();
		
		
		Calendar calendar = Calendar.getInstance();
		int year = calendar.get(calendar.YEAR);
		int month = calendar.get(Calendar.MONTH);
		int day = calendar.get(Calendar.DAY_OF_MONTH);
		int day_year = calendar.get(Calendar.DAY_OF_YEAR);
		int min = calendar.get(Calendar.MINUTE);
		System.out.println(year);
		System.out.println(month+1); //month만 1 작게 나옴...
		System.out.println(day);
		System.out.println(day_year);
		System.out.println(min);
		System.out.println(System.currentTimeMillis());
		
		
		//살아온 일수 계산
		Calendar birth = Calendar.getInstance();
		birth.set(1995, 06, 8);
		long dur = calendar.getTimeInMillis() - birth.getTimeInMillis();
		dur = dur/1000/60/60/24;
		System.out.println("일수: "+dur);
		
		
		//기념일 계산
		Calendar my1 = Calendar.getInstance();
		my1.set(2021, 10, 26);
		long my = my1.getTimeInMillis() - calendar.getTimeInMillis();
		my = my/1000/60/60/24;
		System.out.println("생일"+my);
		
		
		//local date
		
		LocalDate currentdate = LocalDate.now();
		System.out.println(currentdate.getYear()+"/"+
				currentdate.getMonthValue()+"/"+
				currentdate.getDayOfMonth());
		
		System.out.println(currentdate.plusDays(100));
		
		
		
		//Date -> String
		SimpleDateFormat df = new SimpleDateFormat("yyyy.MM.dd G 'at' HH:mm:ss z");
		System.out.println(df.format(calendar.getTime()));
		
		
		SimpleDateFormat df2 = new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss Z");
		System.out.println(df2.format(calendar.getTime()));
	}
}
