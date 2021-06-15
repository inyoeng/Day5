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
			

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void loginChk() {
		if (checkID(sql) == true) {

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

			} else {
				result = false;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
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

			} else {
				result = false;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return result;
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
}
