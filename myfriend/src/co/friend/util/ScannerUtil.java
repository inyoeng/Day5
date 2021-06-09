package co.friend.util;

import java.text.SimpleDateFormat;
import java.util.Scanner;

import co.friend.model.Friend;

public class ScannerUtil {
	static Scanner sc = new Scanner(System.in);

	// 스캔해서 넣은거 while try해서
	public static int readInt(String prompt) {
		System.out.println(prompt + ">");
		return readInt(); // 프렄프트 출력 후 readInt로 가서 값 입력받음.
	}

	// 숫자 넣어라.
	public static int readInt() {
		String s = null;
		int i = 0;

		while (true) {
			try {
				System.out.println("Enter Number: ");
				s = sc.next();
				i = Integer.valueOf(s);
				System.out.println(i);

				// 아니면 그냥 result = sc.nextInt(); 받아도 된다.
				break;
			} catch (Exception e) {
				System.out.println("정수 값을 입력하세요.");
			}
		}
		return i;

	}

	// 문자 넣어라.
	public static String readStr() {
		String s = null;
		int i = 0;

		while (true) {
			try {
				System.out.println("Enter String: ");
				s = sc.next();
				i = Integer.valueOf(s);
				System.out.println("문자 값을 입력하세요.");
			} catch (Exception e) {
				System.out.println(s);
				break;
			}
		}
		return s;

	}

	/*
	 * String result =""; try{ result = sc.next(); /*
	 * 
	 */
	// 날짜 넣으라고 하고. 날짜가 아니면
	public static String readDate() {

		String result = "";
		SimpleDateFormat df = new SimpleDateFormat("yyyymmdd");
		do {
			try {
				System.out.println("날짜 입력: ");
				result = sc.next();
				df.parse(result.trim());// trim 공백제거 parse에서 오류 거름.
				break;
			} catch (Exception e) {
				System.out.println("yyyymmdd 날짜 형식이 아닙니다.");
			}
		} while (true);
		return result;
	}

	public static Friend readFriend() {// Friend 객체 받아와서 한 줄로 넣으면 따로
		while(true) {
		System.out.println("구분, 이름, 전화번호 > ");
		String result = sc.next();
		String[] arr = result.split(",");
		
		Friend friend = new Friend();
		//or Friend friend = new Friend(arr[0], arr[1], arr[2]); or (arr)
		friend.setGubun(arr[0]);
		friend.setName(arr[1]);
		friend.setTel(arr[2]);
		return friend;
		}
		
		}
	
		
		
	

	public static void main(String[] args) {
		System.out.println();
		readInt();
		readStr();
		readDate();
	}
}
