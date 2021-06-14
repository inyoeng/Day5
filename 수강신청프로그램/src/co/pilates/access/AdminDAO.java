package co.pilates.access;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import co.pilates.model.Course;
import co.pilates.model.Pilates;

public class AdminDAO extends DAO implements AccessAdmin{
	
	static PreparedStatement psmt;
	static ResultSet rs;
	String sql;
	static Connection conn;

	public static void connect() {
		String url = "jdbc:sqlite:C:/sqlite/db/pilates.db";
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
	public ArrayList<Pilates> memberList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void searchName(Pilates pilates) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<Pilates> nameContains(Pilates pilates) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void enter(Pilates pilates) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateSession(Pilates pilates) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(String name) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<Course> courseList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void enterCourse(Course course) {
		// TODO Auto-generated method stub
		
	}

}
