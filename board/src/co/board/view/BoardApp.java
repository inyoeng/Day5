package co.board.view;

import java.util.List;

import co.board.access.BoardAccess;
import co.board.access.BoardDAO;
import co.board.access.ScannerUtil;
import co.board.model.Board;

public class BoardApp {
	BoardAccess ba = new BoardDAO();

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

			}
		} while (num != 0);

	}

	private void reply() {
		System.out.println("글 번호 조회");
		ba.serach(ScannerUtil.readInt());
		Board b = ScannerUtil.readBoard();
		ba.reply(b);
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
		System.out.println("=7. 로그인   =");
		System.out.println("=  0.종료   =");
	}

}// end of class
