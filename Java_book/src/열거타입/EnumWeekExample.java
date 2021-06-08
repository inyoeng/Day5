package 열거타입;

import java.util.Scanner;

public class EnumWeekExample {

	public static void main(String[] args) {
		//요일명 저장하는 변수...
		//String week = "Saa"; //요일 명 실수 할 수도 있다.
		//String [] week = ("	Mon", "Tue", "Wed", "Thu", "Fri", "Sat","Sun");
				
		//String today =week[6];		
		
		//좀 더 가독성있도록 만들게enum
		
		Week today = Week.Sun;
		
		Scanner sc = new Scanner(System.in);
		Menu menu = null;
	
		do {
			Menu.print();
			//menu = sc.nextInt();
		int memonum = sc.nextInt();
			menu = Menu.getMenu(memonum);
		switch( menu ) {
			case 등록 : System.out.println("등록"); break;
			case 수정: System.out.println("수정"); break;
			case 삭제 : System.out.println("삭제"); break;
			case 조회 : System.out.println("조회"); break;
		}
		} while( menu != Menu.종료);
		
	}

}
