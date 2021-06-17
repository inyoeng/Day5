package co.pilates.access;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import co.pilates.model.Course;
import co.pilates.model.Pilates;
import co.pilates.model.Teacher;

public class MemberDAO extends DAO implements AccessMember {

	static PreparedStatement psmt;
	static ResultSet rs;
	String sql;
	static Connection conn;

	Scanner sc = new Scanner(System.in);

	public static void connect() {
		String url = "jdbc:sqlite:C:/sqlite/db/pilates.db";
		try {
			conn = DriverManager.getConnection(url);
		

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
		Pilates pl = new Pilates();

		connect();
		try {
			psmt = conn.prepareStatement("select * from members where id=?");
			psmt.setString(1, id);
			// psmt.setString(2, pw);
			rs = psmt.executeQuery();

			if (rs.next()) {
				pl.setId(rs.getString("id"));
				pl.setPw(rs.getString("pw"));
				pl.setName(rs.getString("name"));
				pl.setPhone(rs.getString("phone"));
				pl.setAge(rs.getInt("age"));
				pl.setSession(rs.getInt("sessions"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return pl;
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
				co.setNo(rs.getInt("no"));
				co.setCourse(rs.getString("course"));
				co.setLevel(rs.getString("level"));
				co.setDate(rs.getString("date"));
				co.setTeacher(rs.getString("teacher"));
				
				list.add(co);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
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

			while (rs.next()) {
				Course co = new Course();
				co.setNo(rs.getInt("no"));
				co.setCourse(rs.getString("course"));
				co.setLevel(rs.getString("level"));
				co.setDate(rs.getString("date"));
				co.setTeacher(rs.getString("teacher"));
				list.add(co);
			}
		} catch (SQLException e) {
			System.out.println("잘못된 형식입니다. -> '초급, 중급, 고급'");
			e.printStackTrace();
		} finally {
			close();
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

			while (rs.next()) {
				Course co = new Course();
				co.setNo(rs.getInt("no"));
				co.setCourse(rs.getString("course"));
				co.setLevel(rs.getString("level"));
				co.setDate(rs.getString("date"));
				co.setTeacher(rs.getString("teacher"));
				list.add(co);
			}
		} catch (SQLException e) {
			System.out.println("잘못된 날짜 형식입니다. yy-mm-dd");
			e.printStackTrace();
		} finally {
			close();
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

			while (rs.next()) {
				Course co = new Course();
				co.setNo(rs.getInt("no"));
				co.setCourse(rs.getString("course"));
				co.setLevel(rs.getString("level"));
				co.setDate(rs.getString("date"));
				co.setTeacher(rs.getString("teacher"));
				list.add(co);
			}
		} catch (SQLException e) {
			System.out.println("잘못된 이름입니다.");
			e.printStackTrace();
		} finally {
			close();
		}

		return list;
	}

	@Override
	public void logout() {
		System.out.println("로그아웃되었습니다.");
		

	}

	@Override
	public ArrayList<Teacher> teacherInfo() {
		connect();
		String sql = "select * from teacher";
		ArrayList<Teacher> list = new ArrayList<>();

		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();

			while (rs.next()) {
				Teacher t = new Teacher();
				t.setName(rs.getString("name"));
				t.setExperience(rs.getString("experience"));
				t.setAge(rs.getInt("age"));
				t.setSpeciality(rs.getString("speciality"));
				t.setPhone(rs.getString("phone"));
				list.add(t);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}

		return list;

	}

	@Override
	public void enroll(int no, Pilates p) {

		while (true) {
			//수강권 남아있는지 먼저 조회
			if (p.getSession() == 1) {
				System.out.println("수강권이 1회 남았습니다!");
			}else if(p.getSession() <0 ) {
				System.out.println("수강권이 만료되었습니다. ");
				break;
			}
			
			//수강권 남아있으면 진행
			connect();
			String sql = "insert into enroll values ( ? , ?)";

			try {
				psmt = conn.prepareStatement(sql);
				psmt.setInt(1, no);
				psmt.setString(2, p.getId());
				int r = psmt.executeUpdate();
				System.out.println(r + "건이 수강신청 되었습니다.");
			} catch (SQLException e) {
				e.printStackTrace();
			}

			// sessions -1 하기

			String sql2 = "update members set sessions =? where name =?";
			int session = p.getSession() - 1;
			
			try {
				psmt = conn.prepareStatement(sql2);
				psmt.setInt(1, session);
				psmt.setString(2, p.getName());
				int r = psmt.executeUpdate();
				System.out.println(r + "건이 변경되었습니다.");

			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				close();
			}
			break;
		}
	}

	@Override
	public ArrayList<Course> history(Pilates p) {
		connect();
		
		//아이디 받아옴~!!
		String id = p.getId();
		//System.out.println(id);

		String sql = "select * from course c join enroll e on e.no = c.no where students =?";

		ArrayList<Course> list = new ArrayList<>();

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			rs = psmt.executeQuery();

			while (rs.next()) {
				Course co = new Course();
				co.setNo(rs.getInt("no"));
				co.setCourse(rs.getString("course"));
				co.setLevel(rs.getString("level"));
				co.setDate(rs.getString("date"));
				co.setTeacher(rs.getString("teacher"));
				list.add(co);
			}
		} catch (SQLException e) {
			System.out.println("잘못된 이름입니다.");
			e.printStackTrace();
		} finally {
			close();
		}

		return list;
	}

	// 나이 수정
	public static void updateAge(Pilates pilates) {
		connect();

		String id = pilates.getId();

		String sql = "update members set age=? where id = ?";
		int r = 0;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, pilates.getAge());
			psmt.setString(2, id); // id는 로그인할 때 받아옴!!!!
			r = psmt.executeUpdate();
			System.out.println(r + "건이 변경되었습니다.");
			System.out.println(pilates);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}
	}

	// 전번 수정
	public void updatePhone(String phone,Pilates p) {
		connect();
		String id = p.getId();

		String sql = "update members set phone=? where id = ?";
		int r = 0;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, phone);
			psmt.setString(2, id); // id는 로그인할 때 받아옴!!!!
			r = psmt.executeUpdate();
			System.out.println(r + "건이 변경되었습니다.");
			System.out.println(p);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}

	}

	// 비번수정
	public void updatePw(String pw,Pilates p) {

		connect();
		String id = p.getId();

		String sql = "update members set pw=? where id = ?";
		int r = 0;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, pw);
			psmt.setString(2, id); // id는 로그인할 때 받아옴!!!!
			System.out.println(p);
			r = psmt.executeUpdate();
			System.out.println(r + "건이 변경되었습니다.");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}

	}

	
}
