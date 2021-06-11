package co.board.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import co.board.access.BoardAccess;
import co.board.access.BoardDAO;
import co.board.access.ScannerUtil;
import co.board.model.Board;
import 로그인.MemberAccess;
import 로그인.MemberDAO;

public class BoardApp {
	BoardAccess ba = new BoardDAO(); // 글 작성용
	MemberAccess ma = new MemberDAO(); // 로그인용
	Scanner sc = new Scanner(System.in);

	public void start() {
		int num;

		do {
			// print menu
			menuTitle();
			// select menu
			num = ScannerUtil.readInt();
			switch (num) {
			case 1:
				listAll();
				break;
			case 2:
				submit();
				break;
			case 3:
				edit();
				break;
			case 4:
				delete();
				break;
			case 5:
				search();
				break;
			case 6:
				reply();
				break;
			case 7:
				serchReply();
				break;
			case 8:
				logIn();
				break;

			}
		} while (num != 0);

	}

	public boolean logIn() {

		while (true) {
			// 아이디 받아옴
			System.out.println("id 입력>> ");
			String id = ScannerUtil.readStr();
			ma.checkID(id);
			// 맞으면 비번으로
			if (ma.checkID(id) == true) {
				System.out.println("비밀번호 입력");
				int pw = ScannerUtil.readInt();
				ma.checkpw(pw);
				//비번 맞으면 로긴
				if (ma.checkpw(pw) == true) {
					ba.logIn(id);

				}
				//비번 모르면
				else {
					System.out.println("wrong pw");
					continue;
				}
			} 
			//아이디 틀리면
			else {
				System.out.println("wrong id");
				continue;
			}
			// 비번까지 맞으면 로긴!
			break;
		}
		return false;

	}

	private void serchReply() {
		int b_parent_id = ScannerUtil.readInt();
		ArrayList<Board> b = ba.serachReply(b_parent_id);
		System.out.println(b);
	}

	private void reply() {
		// 댓글 달 글 번호 조회하기
		System.out.println("글 번호 조회");
		int b_id = ScannerUtil.readInt();
		Board b = ba.serach(b_id);
		// 글 번호 == parent id
		int id = b.getB_id();
		System.out.println(b);
		// ========================================
		// option 1, reply 2 return\
		System.out.println("1. 댓글 입력 2. 이전");
		int num = sc.nextInt();
		while (true) {
			if (num == 1) {
				Board br = ScannerUtil.readReply();
				br.setB_parent_id(id);
				ba.reply(br);
				break;
			} else if (num == 2) {
				break;

			} else {
				System.out.println("없는 번호입니다. 다시 입력하세요!!");
				continue;
			}
		}
		start();
	}

	private void search() {
		int b_id = ScannerUtil.readInt();
		Board b = ba.serach(b_id);
		System.out.println(b);
	}

	private void delete() {
		int b_id = ScannerUtil.readInt();
		ba.delete(b_id);
	}

	private void edit() {
		Board b = new Board();
		System.out.println("바꿀 내용의 번호를 입력하세요.");
		int id = ScannerUtil.readInt();
		BoardDAO dao = new BoardDAO();
		if (dao.checkId(id)) {

			b.setB_id(id);

			System.out.println("바꿀 내용을 입력하세요");
			b.setB_content(ScannerUtil.readStr());
			ba.edit(b);
		} else {
			System.out.println("없습니다.!!!");
		}
		;

	}

	private void submit() {
		Board b = ScannerUtil.readBoard();
		ba.submit(b);
	}

	private void listAll() {
		List<Board> list = ba.listAll();
		for (Board b : list) {
			System.out.println(b.showinfo());
		}

	}

	public void menuTitle() {
		System.out.println("====게시판====");
		System.out.println("=1. 전체리스트=");
		System.out.println("=2. 글 등록  =");
		System.out.println("=3. 글 수정  =");
		System.out.println("=4. 글 삭제  =");
		System.out.println("=5. 한건 조회=");
		System.out.println("=6. 덧글    =");
		System.out.println("=7. 댓글 조회=");
		System.out.println("=8. 로그인   =");
		System.out.println("=  0.종료   =");
	}

}// end of class
