package co.pilates.view;

import java.util.ArrayList;
import java.util.Scanner;

import co.pilates.access.AccessAdmin;
import co.pilates.access.AdminDAO;
import co.pilates.access.ScannerUtil;
import co.pilates.model.Course;
import co.pilates.model.Pilates;
import co.pilates.model.Teacher;

public class AdminCliApp {

	private static final Pilates Pilates = null;
	AccessAdmin adm = new AdminDAO(); // 관리자용 메뉴
	Scanner sc = new Scanner(System.in);
	
	int num = 0;
	public void start() {

		do {
			// print menu
			menuTitle();
			// select menu
			num = sc.nextInt();
			
			switch (num) {
			case 1:
				memberManage();
				break;
		
			case 2:
				courseManage();
				break;
			case 3:
				teacherManage();
				break;
			case 4:
				ending();
				break;

			}
		} while (num != 0);

	}


	private void ending() {
		System.out.println("종료하시겠습니까? >> y/n");
		String a = sc.next();
		if (a.equals("y")) {
			//System.exit(0);
			num = 0;
		}		
	}


	private void teacherManage() {
		System.out.println("===================  강사 관리   ===================");
		System.out.println("1) 강사 전체 조회 2) 강사 이름조회 3) 강사 등록 4) 강사 삭제");
		System.out.println("==================================================");
		int n = sc.nextInt();
		
		if(n == 1) {
			 teacherList();
		}else if( n==2) {
			searchTeacher();
		}else if( n== 3) {
			enterTeacher();
		}
		else if( n== 4) {
			deleteTeacher();
		}
	}


	private void searchTeacher() {
		System.out.println("찾을 이름을 입력하세요 >>");
		String name = sc.next();
		adm.seachTeacher(name);
	}


	private void deleteTeacher() {
		String name = sc.next();
		adm.deleteTeacher(name);
	}


	private void enterTeacher() {
		Teacher t = ScannerUtil.readTeacher();
		adm.inputTeacher(t);		
	}


	private void courseManage() {
		System.out.println("============   강의 관리   ===========");
		System.out.println("1) 강의 전체 조회 2) 강의 등록 3) 강의 삭제");
		System.out.println("====================================");
		int n = sc.nextInt();
		
		if(n == 1) {
			courseList();
		}else if( n==2) {
			enterCourse();
		}else if( n== 3) {
			deleteCourse();
		}
	}


	private void deleteCourse() {
		String name = sc.next();
		adm.deleteCourse(name);
	}


	//회원관리
	private void memberManage() {
		System.out.println("==================                   회원관리                ========================");
		System.out.println("1) 전체 회원 조회 2) 회원 이름으로 검색 3) 회원 이름 검색 4) 회원 등록 5) 수강권 부여 6) 회원 삭제");
		System.out.println("===================================================================================");
		int mnum = sc.nextInt();
		
		if(mnum == 1) {
			memberList();
		}else if(mnum ==2) {
			searchName();
		}else if(mnum ==3) {
			nameContains();
		} else if(mnum ==4) {
			enter();
		}else if(mnum ==5) {
			 updateSession();
		}else if(mnum ==6) {
			delete();
		}
	}


	public void updateSession() {
		Pilates p = new Pilates();
		System.out.println(" == 수강권을 부여 회원의 아이디를 입력하세요! >> ");
		p.setId(sc.next());
		System.out.println(" == 수강권의 횟수를 입력하세요! >> ");
		p.setSession(sc.nextInt());
		System.out.println(p);
		adm.updateSession(p);
	}
	
	private void enterCourse() {
		Course c = ScannerUtil.readCourse();
		adm.enterCourse(c);
	}
	
	public void teacherList() {
		ArrayList<Teacher> list = adm.teacherList();
		for(Teacher t :list) {
			System.out.println(t);
		}
	}

	private void courseList() {
		ArrayList<Course> list = adm.courseList();
		for(Course c :list) {
			System.out.println(c);
		}
	}

	private void delete() {
		String name = sc.next();
		adm.delete(name);
	}

	private void nameContains() {
		ArrayList<Pilates> p = adm.nameContains(Pilates);
		System.out.println(p);
	}

	private void searchName() {
		System.out.println("찾을 이름을 입력하세요 >>");
		String name = sc.next();
		adm.searchName(name);
	}

	private void enter() {
		Pilates p = ScannerUtil.readPila();
		adm.enter(p);
		
	}

	private void memberList() {
		ArrayList<Pilates> list = adm.memberList();
		for(Pilates p :list) {
			System.out.println(p);
		}
		
	}

	private void menuTitle() {
		System.out.println("===============");
		System.out.println("= 1) 회원 관리  =");
		System.out.println("= 2) 강좌 관리  =");
		System.out.println("= 3) 선생님 관리 =");
		System.out.println("= 4) 종료      =");
		System.out.println("===============");
	}

}
