package 로그인;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import co.board.access.DAO;
import co.board.model.Board;

public class MemberDAO extends DAO implements MemberAccess{

	static PreparedStatement psmt;
	static ResultSet rs;
	String sql;

	static Connection conn;

	boolean result = true;



	public void loginChk() {
		if(checkID(sql) == true) {
			
		}
	}
	
	
	@Override
	public boolean checkID(String id) {
		String sql = "select * from member where u_id=?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			rs = psmt.executeQuery();
			if (rs.next()) {
				result = true;
			
			}else {
				result = false;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result; 
	}

	@Override
	public boolean checkpw(int pw) {
		String sql = "select * from member where u_pw=?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, pw);
			rs = psmt.executeQuery();
			if (rs.next()) {
				result = true;
				
			}else {
				result = false;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return result; 
		}


	public static void connect() {
		String url = "jdbc:sqlite:C:/sqlite/db/sample.db";
		try {
			conn = DriverManager.getConnection(url);
			System.out.println("연결성공!!");

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	
}
