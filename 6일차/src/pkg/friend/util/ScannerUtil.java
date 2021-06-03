package pkg.friend.util;

import java.util.Scanner;

import pkg.other.Friend;

public class ScannerUtil {
	static Scanner sc= new Scanner(System.in);
	//스캔해서 넣은거 while try해서 
	public static int readInt() {} //숫자 넣어라. 
	public static String readStr() {} // 문자 넣어라.
	public static String readDate() {}// 날짜 넣으라고 하고. 날짜가 아니면
	public static Friend readFriend() {//Friend 객체 받아와서 한 줄로 넣으면 따로
		String result = sc.next();
		String [] arr = result.split(",");
		Friend friend = new Friend();
		friend.setGubun(result);
		
				
		return Friend;
	}
	
	
	

}
