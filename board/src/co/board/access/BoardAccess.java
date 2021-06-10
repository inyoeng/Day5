package co.board.access;

import java.util.ArrayList;

import co.board.model.Board;

public interface BoardAccess {

	public ArrayList<Board> listAll(); // 글 번호, 제목, 작성자

	public void submit(Board board); //제목, 내용, 작성자 입력(아니면 로그인 아이디),글 번호는 자동증가.
	

	public void edit(Board board);//글 번호 선택 - 글 내용 수정
	

	public void delete(int b_id);  // 글 번호 선택 -> 삭제
	

	// 단건 상세 조회
	public Board serach(int b_id);
	// 글 번호, 제목, 작성자, 내용



	public void reply(Board board);
	// 한건 조회하고 덧글(add?)

	public static void logIn(String b_parent_id) {//아이디, 비밀번호 입력 ,, 자기가 작성한 글만 수정, 삭제 가능.
	}
}
