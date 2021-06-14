package co.pilates;

import java.util.Scanner;

import co.pilates.access.AccessMember;
import co.pilates.access.MemberDAO;
import co.pilates.access.ScannerUtil;
import co.pilates.login.LoginAccess;
import co.pilates.login.LoginDAO;
import co.pilates.model.Pilates;
import co.pilates.view.AdminCliApp;
import co.pilates.view.PilatesCliApp;

public class AppMain {

	public static void main(String[] args) {

		LoginAccess lo = new LoginDAO();
		AccessMember am = new MemberDAO();
		AdminCliApp ad = new AdminCliApp();

		// 1. 관리자로 로그인할래? y/n
		System.out.println("관리자로 로그인 하시겠습니까?");
		System.out.println("1.yes 2.no");
		Scanner sc = new Scanner(System.in);
		int f = sc.nextInt();
		
		// 2. y -> admincli
		if (f == 1) {
			//비밀번호 확인!
			
			
			ad.start();
		}
		// 3. n -> pilatescli 가서 로그인
		else if (f == 2) {
			System.out.println("회원 로그인");
			System.out.println("id입력 >> ");
			String id = ScannerUtil.readStr();
			
			if (lo.checkID(id) == true) {
				System.out.println("비밀번호 입력");
				String pw = ScannerUtil.readStr();
				
				// 비번 맞으면 로그인
				if (lo.checkpw(pw) == true) {
					//로그인 정보 저장!
					Pilates pl = am.logIn(id, pw);
					// 4. 로그인 정보가 맞으면 start!
					PilatesCliApp pApp = new PilatesCliApp(pl);
					pApp.start();
				}
			}

		}
	}
}
