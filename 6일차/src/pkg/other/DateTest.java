package pkg.other;

import java.util.Date;

import pkg.friend.util.DateUtil;

public class DateTest {

	public static void main(String[] args) {

		//오늘날짜: new date하면 나몽
		System.out.println(DateUtil.dateToStr(new Date()));
		System.out.println(DateUtil.dateToStr(new Date(),"yyyy"));
		System.out.println(DateUtil.days("2021-07-01" ,"2021-05-20"));
		System.out.println(DateUtil.lastDay(2021, 7));
		
	}

}
