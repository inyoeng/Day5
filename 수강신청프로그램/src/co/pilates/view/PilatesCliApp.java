package co.pilates.view;

import java.util.List;

import co.pilates.access.AccessMember;
import co.pilates.access.MemberDAO;
import co.pilates.access.ScannerUtil;
import co.pilates.model.Course;
import co.pilates.model.Pilates;

public class PilatesCliApp {
	
	public Pilates pilates;
	
	public PilatesCliApp() {
		
	}
	
	public PilatesCliApp(Pilates pilates){
		this.pilates = pilates;
	}
	
	
	AccessMember mem = new MemberDAO(); // 회원용 메뉴

	public void start() {
		int num;

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

	}
	
	private void history() {
		// TODO Auto-generated method stub

	}

	private void update() {
		// 스캐너 받아서 1. 나이 수정 2. 번호 수정 3. 비밀번호 수정
		System.out.println("1. 나이 수정 2. 번호수정 3. 비밀번호 수정");
		int num = ScannerUtil.readInt();
		while (true) {
			if (num == 1) {
				// 나이수정
				
				Pilates p  =new Pilates();
				int newAge = ScannerUtil.readInt();
				p.setAge(newAge);
				mem.updateAge(p);
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
		// TODO Auto-generated method stub

	}

	private void searchAll() {
		List<Course> list = mem.searchAll();
		for(Course c : list) {
			System.out.println(c.toString());
		}
	}

	private void searchLevel() {
		String level = ScannerUtil.readStr();
		List<Course> list = mem.searchLevel(level);
		for(Course c : list) {
			System.out.println(c.toString());
		}
	}

	private void searchDate() {
		String date = ScannerUtil.readStr();
		List<Course> list = mem.searchLevel(date);
		for(Course c : list) {
			System.out.println(c.toString());
		}
	}

	private void searchTeacher() {
		String teacher = ScannerUtil.readStr();
		List<Course> list = mem.searchLevel(teacher);
		System.out.println(list);

	}

	private void enroll() {
		// TODO Auto-generated method stub

	}

	private void logOut() {
		// TODO Auto-generated method stub

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
