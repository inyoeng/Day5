package co.pilates.view;

import java.util.ArrayList;
import java.util.Scanner;

import co.pilates.access.AccessAdmin;
import co.pilates.access.AdminDAO;
import co.pilates.model.Pilates;

public class AdminCliApp {

	AccessAdmin adm = new AdminDAO(); // 관리자용 메뉴
	Scanner sc = new Scanner(System.in);
	
	public void start() {
		int num;

		do {
			// print menu
			menuTitle();
			// select menu
			num = sc.nextInt();
			
			switch (num) {
			case 1:
				memberList();
				break;
			case 2:
				enter();
				break;
			case 3:
				searchName();
				break;
			case 4:
				nameContains();
				break;
			case 5:
				delete();
				break;
			case 6:
				courseList();
				break;
			case 7:
				enterCourse();
				break;
			

			}
		} while (num != 0);

	}



	private void enterCourse() {
		// TODO Auto-generated method stub

	}

	private void courseList() {
		// TODO Auto-generated method stub

	}

	private void delete() {
		// TODO Auto-generated method stub

	}

	private void nameContains() {
		// TODO Auto-generated method stub

	}

	private void searchName() {
		// TODO Auto-generated method stub

	}

	private void enter() {
		// TODO Auto-generated method stub

	}

	private void memberList() {
		ArrayList<Pilates> list = adm.memberList();
		for(Pilates p :list) {
			System.out.println(p);
		}
		
	}

	private void menuTitle() {
		System.out.println("========================================");
		System.out.println("= 1) 전체 회원 검색  2) 조건으로 회원 검색하기 =");
		System.out.println("= 3) 회원 등록      4) 회원 수강권 변경하기  =");
		System.out.println("= 5) 회원 삭제      6) 강사 목록 조회       =");
		System.out.println("=           7) 강의 등록하기              =");
		System.out.println("========================================");
	}

}
