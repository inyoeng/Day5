package co.pilates.access;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import co.pilates.model.Course;
import co.pilates.model.Pilates;
import co.pilates.model.Teacher;

public class MemberDAO extends DAO implements AccessMember{
	
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
	public Pilates logIn(String id, String pw) {
		System.out.println("로그인 성공!!");
		return null;
	}



	

	@Override
	public ArrayList<Course> searchAll() {
		ArrayList<Course> list = new ArrayList<>();
		
		connect();
		try {
			psmt = conn.prepareStatement("select * from course");
			rs = psmt.executeQuery();
			while (rs.next()) {
				Course co = new Course();
				co.setCourse(rs.getString("course"));
				co.setLevel(rs.getString("level"));
				co.setDate(rs.getString("date"));
				co.setTeacher(rs.getString("teacher"));
				co.setStudents(rs.getString("students"));
				list.add(co);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close();
		}
		
	
		return list;
	}

	@Override
	public ArrayList<Course> searchLevel(String level) {
		connect();
		
		
		String sql = "select * from course where level = ?";
		
		ArrayList<Course> list = new ArrayList<>();
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, level);
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				Course co = new Course();
				co.setCourse(rs.getString("course"));
				co.setLevel(rs.getString("level"));
				co.setDate(rs.getString("date"));
				co.setTeacher(rs.getString("teacher"));
				co.setStudents(rs.getString("students"));
				list.add(co);
			}
		} catch (SQLException e) {
			System.out.println("잘못된 형식입니다. -> '초급, 중급, 고급'");
			e.printStackTrace();
		}
		
		
		return list;
		
	}

	@Override
	public ArrayList<Course> SearchDate(String date) {
connect();
		
		
		String sql = "select * from course where date = ?";
		
		ArrayList<Course> list = new ArrayList<>();
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, date);
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				Course co = new Course();
				co.setCourse(rs.getString("course"));
				co.setLevel(rs.getString("level"));
				co.setDate(rs.getString("date"));
				co.setTeacher(rs.getString("teacher"));
				co.setStudents(rs.getString("students"));
				list.add(co);
			}
		} catch (SQLException e) {
			System.out.println("잘못된 날짜 형식입니다. yy-mm-dd");
			e.printStackTrace();
		}
		
		
		return list;
		
	}

	@Override
	public ArrayList<Course> searchTeacher(String teacher) {
connect();
		
		
		String sql = "select * from course where teacher = ?";
		
		ArrayList<Course> list = new ArrayList<>();
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, teacher);
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				Course co = new Course();
				co.setCourse(rs.getString("course"));
				co.setLevel(rs.getString("level"));
				co.setDate(rs.getString("date"));
				co.setTeacher(rs.getString("teacher"));
				co.setStudents(rs.getString("students"));
				list.add(co);
			}
		} catch (SQLException e) {
			System.out.println("잘못된 이름입니다.");
			e.printStackTrace();
		}
		
		
		return list;
	}

	

	@Override
	public void logout() {
		System.out.println("로그아웃되었습니다.");
		System.out.println("종료하려면 0을 누르세요");
		int num = ScannerUtil.readInt();
	}

	@Override
	public void teacherInfo(Teacher teacher) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void enroll(Course course) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Pilates pilates) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<Course> history(Course course) {
		// TODO Auto-generated method stub
		return null;
	}

	//나이 수정
	public void updateAge(Pilates pilates) {
		connect();
		String sql = "update members set age=? where name = ?";
		int r = 0;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, pilates.getAge());
			psmt.setString(2, pilates.getName()); //이름은 로그인할 때 받아옴!!!!
			r = psmt.executeUpdate();
			System.out.println(r+"건이 변경되었습니다.");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//전번 수정
	public void updatePhone(Pilates pilates) {}
	//비번수정
	public void updatePw(Pilates pilates) {}


}
