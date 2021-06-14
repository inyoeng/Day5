package co.pilates.login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import co.pilates.access.DAO;

public class LoginDAO extends DAO implements LoginAccess {
	static PreparedStatement psmt;
	static ResultSet rs;
	String sql;

	static Connection conn;

	boolean result = true;
	
	public static void connect() {
		String url = "jdbc:sqlite:C:/sqlite/db/pilates.db";
		try {
			conn = DriverManager.getConnection(url);
			System.out.println("연결성공!!");

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	
	
	public void loginChk() {
		if(checkID(sql) == true) {
			
		}
	}
	
	@Override
	public boolean checkID(String id) {
		connect();
		String sql = "select * from members where id=?";
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
	public boolean checkpw(String pw) {
		connect();
		String sql = "select * from members where pw=?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, pw);
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

}
