package co.pilates.view;

import java.util.List;
import java.util.Scanner;

import co.pilates.access.AccessMember;
import co.pilates.access.MemberDAO;
import co.pilates.access.ScannerUtil;
import co.pilates.model.Course;
import co.pilates.model.Pilates;
import co.pilates.model.Teacher;

public class PilatesCliApp {

	Scanner sc = new Scanner(System.in);

	public Pilates pilates;

	public PilatesCliApp(Pilates pilates) {
		this.pilates = pilates;
		System.out.println(pilates);
	}

	AccessMember mem = new MemberDAO(); // 회원용 메뉴
	int num = 0;

	public void start() {

		do {
			// print menu
			menuTitle();
			// select menu
			num = ScannerUtil.readInt();
			switch (num) {
			case 1:
				searchAll();
				break;
			case 2:
				searchLevel();
				break;
			case 3:
				searchDate();
				break;
			case 4:
				searchTeacher();
				break;
			case 5:
				update();
				break;
			case 6:
				enroll();
				break;
			case 7:
				teacherInfo();
				break;
			case 8:
				history();
				break;
			case 9:
				logOut();
				break;
			}
		} while (num != 0);
		System.out.println("The End");
	}

	private void history() {

		System.out.println("----------  수강신청 내역  ----------");
		List<Course> list = mem.history();
		for (Course c : list) {
			System.out.println(c.toString());
		}

	}

	private void update() {
		// 스캐너 받아서 1. 나이 수정 2. 번호 수정 3. 비밀번호 수정
		System.out.println("1. 나이 수정 2. 번호수정 3. 비밀번호 수정");

//		String name = pilates.getName();
//		System.out.println(name);

		int num = ScannerUtil.readInt();
		while (true) {
			if (num == 1) {
				// 나이수정
				int newAge = sc.nextInt();
				pilates.setAge(newAge);
				MemberDAO.updateAge(pilates);
				break;
			} else if (num == 2) {
				// 번호수정

				break;
			} else if (num == 3) {
				// 비밀번호 수정

				break;
			} else {
				System.out.println("다시 입력하세요!!");
				continue;
			}
		}

	}

	private void teacherInfo() {
		List<Teacher> list = mem.teacherInfo();
		for (Teacher c : list) {
			System.out.println(c.toString());
		}
	}

	private void searchAll() {
		List<Course> list = mem.searchAll();
		for (Course c : list) {
			System.out.println(c.toString());
		}
	}

	private void searchLevel() {
		System.out.println("레벨을 입력하세요");
		String level = sc.next();
		List<Course> list = mem.searchLevel(level);
		for (Course c : list) {
			System.out.println(c.toString());
		}
	}

	private void searchDate() {
		System.out.println("yy-mm-dd");
		String date = sc.next();
		List<Course> list = mem.SearchDate(date);
		for (Course c : list) {
			System.out.println(c.toString());
		}
	}

	private void searchTeacher() {
		System.out.println("선생님 이름을 입력하세요");
		String teacher = sc.next();
		List<Course> list = mem.searchTeacher(teacher);
		for (Course c : list) {
			System.out.println(c.toString());
		}
	}

	private void enroll() {
		System.out.println("-----------------------------");
		System.out.println("수강신청 할 강의의 번호를 입력하세요!");
		System.out.println("-----------------------------");
		int no = sc.nextInt();
		// 강좌 불러와서 확인시키기

		System.out.println("수강신청 하시겠습니까?");
		System.out.println("= 1. Yes  2. No =");
		int num = sc.nextInt();

		if (num == 1) {

			mem.enroll(no);

		} else {
			System.out.println("수강신청 취소...");
		}

	}

	private void logOut() {
		mem.logout();
		System.out.println("종료하시겠습니까? >> y/n");
		String a = sc.next();
		if (a.equals("y")) {
			//System.exit(0);
			num = 0;
		}

	}

	private void menuTitle() {
		System.out.println("번호를 입력하세요!");
		System.out.println("=========================================================");
		System.out.println("1) 강의 전체조회 2)레벨로 조회 3)날짜로 조회 4)선생님으로 검색");
		System.out.println("5) 회원정보수정 6)수강신청 7) 선생님 정보 확인 8) 수강신청 이력 조회");
		System.out.println("9)로그아웃");
		System.out.println("=========================================================");
	}

}
