package co.board.access;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import co.board.model.Board;

public class BoardDAO extends DAO implements BoardAccess {

	static PreparedStatement psmt;
	static ResultSet rs;
	String sql;

	@Override
	public ArrayList<Board> listAll() {
		ArrayList<Board> list = new ArrayList<>();

		connect();

		try {
			psmt = conn.prepareStatement("select * from board");
			rs = psmt.executeQuery();
			while (rs.next()) {
				Board b = new Board();
				b.setB_id(rs.getInt("b_id"));
				b.setB_title(rs.getString("b_title"));
				b.setB_writer(rs.getString("b_writer"));
				list.add(b);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}

		return list;
	}

	@Override
	public void submit(Board board) {
		String sql = "insert into board values(?,?,?,?)";
		connect();
		try {
			System.out.println("번호, 제목, 내용, 작성자를 입력하세요.");
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, board.getB_id());
			psmt.setString(2, board.getB_title());
			psmt.setString(3, board.getB_content());
			psmt.setString(4, board.getB_writer());
			int r = psmt.executeUpdate();
			System.out.println(r + "건 입력되었습니다.");

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}

	}

	@Override
	public void edit(Board board) {
		String sql = " update board set b_content=? where b_id=?";
		connect();
		int r = 0;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(2, board.getB_id());
			psmt.setString(1, board.getB_content());
			r = psmt.executeUpdate();
			System.out.println(r + "건 변경되었습니다. ");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
	}

	public boolean checkId(int b_id) {
		String sql = "select * from board where b_id=?";
		connect();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, b_id);

			rs = psmt.executeQuery();
			if (rs.next()) {
				return true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return false;
	}

	@Override
	public void delete(int b_id) {
		String sql = "delete from board where b_id = ?";
		connect();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, b_id);
			int r = psmt.executeUpdate();
			System.out.println(r + "건 삭제되었습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}

	}

	@Override
	public Board serach(int b_id) {
		connect();

		Board b = null;
		String sql = "select * from board where b_id = ?";

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, b_id);
			rs = psmt.executeQuery();

			if (rs.next()) {
				b = new Board();
				b.setB_id(rs.getInt("b_id"));
				b.setB_title(rs.getString("b_title"));
				b.setB_content(rs.getString("b_content"));
				b.setB_writer(rs.getString("b_writer"));
			} else {
				System.out.println("없는 번호입니다. ");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return b;
	}

	static Connection conn;

	ArrayList<Board> list;

	public static void connect() {
		String url = "jdbc:sqlite:C:/sqlite/db/sample.db";
		try {
			conn = DriverManager.getConnection(url);
			System.out.println("연결성공!!");

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public static void close() { // connect한 후에는 꼭 close 해 줘야 함.
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (psmt != null) {
			try {
				psmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Override
	public void reply(Board board) {
		connect();
	
		System.out.println("1. 덧글 입력  2. 이전메뉴");
		
		Scanner sc = new Scanner(System.in);

		while (true) {
			int num = sc.nextInt();
			if (num == 1) {
				String sql = "insert into board values(?,?,?,?,?)";
				System.out.println("번호, 제목, 내용, 작성자를 입력하세요.");
				try {
					psmt = conn.prepareStatement(sql);
					psmt.setInt(1, board.getB_id());
					psmt.setString(2, board.getB_title());
					psmt.setString(3, board.getB_content());
					psmt.setString(4, board.getB_writer());
					psmt.setString(5, board.getB_parent_id());
					int r = psmt.executeUpdate();
					System.out.println(r + "건 입력되었습니다.");
				} catch (SQLException e) {
					e.printStackTrace();
				}
						
				break;
			} else if (num == 2) {
				
				break;
			} else {
				System.out.println("잘못된 번호를 입력하셨습니다.");
				continue;
			}
		}

	}

}
