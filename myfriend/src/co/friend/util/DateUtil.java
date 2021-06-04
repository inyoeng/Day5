package co.friend.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {

	//날짜니까 Static으로 만들면 됨
	static String format = "yyyy-mm-dd";
	
	//Date -> String 으로 바꿔주는 메서드
	public static String dateToStr(Date date) {
		SimpleDateFormat df2 = new SimpleDateFormat(format);
		String s = df2.format(date);
		return s;
	}
	
	//오버로딩
	public static String dateToStr(Date date, String format) {
		SimpleDateFormat df2 = new SimpleDateFormat(format);
		String s = df2.format(date);
		return s;
		
	}
	
	//두 날짜 사이의 일수 계산
	public static int days(String s1, String s2) {
		SimpleDateFormat df = new SimpleDateFormat(format);
		long result = 0;
		try {
			Date d1;
			d1 = df.parse(s1);
	
			Date d2;
			d2 = df.parse(s2);
			
			result = d1.getTime() - d2.getTime();
			result = result/1000/60/60/24;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		

		return (int) Math.abs(result);
	}
	
	//해당 월의 마지막 날
	
	public static int lastDay(int year, int month) {
		
		int result = 0;
		Calendar cal = Calendar.getInstance();
		cal.set(year, month-1,1);
		result = cal.getActualMaximum(Calendar.DATE);
		return result;
	}
	
}
