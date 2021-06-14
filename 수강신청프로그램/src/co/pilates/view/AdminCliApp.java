package co.pilates.view;

import co.pilates.access.AccessAdmin;
import co.pilates.access.AdminDAO;
import co.pilates.access.ScannerUtil;

public class AdminCliApp {

	AccessAdmin adm = new AdminDAO(); // 관리자용 메뉴

	public void start() {
		int num;

		do {
			// print menu
			menuTitle();
			// select menu
			num = ScannerUtil.readInt();
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
		// TODO Auto-generated method stub

	}

	private void menuTitle() {
		// TODO Auto-generated method stub

	}

}
