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

public class AdminDAO extends DAO implements AccessAdmin {

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
	public ArrayList<Pilates> memberList() {
		connect();
		ArrayList<Pilates> list = new ArrayList<>();

		String sql = "select * from members";
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while (rs.next()) {
				Pilates p = new Pilates();
				p.setId(rs.getString("id"));
				p.setPw(rs.getString("pw"));
				p.setName(rs.getString("name"));
				p.setPhone(rs.getString("phone"));
				p.setSession(rs.getInt("sessions"));
				p.setAge(rs.getInt("age"));
				list.add(p);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}

		return list;
	}

	@Override
	public void enter(Pilates pilates) {
		connect();
		String sql = "insert into members values (?,?,?,?,?,?)";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, pilates.getId());
			psmt.setString(2, pilates.getPw());
			psmt.setString(3, pilates.getName());
			psmt.setInt(4, pilates.getAge());
			psmt.setString(5, pilates.getPhone());
			psmt.setInt(6, pilates.getSession());
			int r = psmt.executeUpdate();
			System.out.println(r + "건 입력되었습니다. ");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}

	}

	@Override
	public ArrayList<Pilates> nameContains(String word) {
		connect();
		ArrayList<Pilates> list = new ArrayList<>();

		try {
			psmt = conn.prepareStatement("select * from members where name like ?");
			psmt.setString(1, '%' + word + '%');
			rs = psmt.executeQuery();
			while (rs.next()) {
				Pilates p = new Pilates();
				p.setId(rs.getString("id"));
				p.setPw(rs.getString("pw"));
				p.setName(rs.getString("name"));
				p.setAge(rs.getInt("age"));
				p.setPhone(rs.getString("phone"));
				p.setSession(rs.getInt("sessions"));
				list.add(p);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}

		return list;
	}

	@Override
	public ArrayList<Pilates> searchName(String name) {
		connect();
		ArrayList<Pilates> list = new ArrayList<>();
		String sql = "select * from members where name = ?";
		Pilates p = null;

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, name);
			rs = psmt.executeQuery();

			while (rs.next()) {
				p = new Pilates();
				p.setId(rs.getString("id"));
				p.setPw(rs.getString("pw"));
				p.setName(rs.getString("name"));
				p.setAge(rs.getInt("age"));
				p.setPhone(rs.getString("phone"));
				p.setSession(rs.getInt("sessions"));
				list.add(p);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return list;
	}

	@Override
	public void updateSession(Pilates pilates) {
		connect();
		String sql = "update members set sessions = ? where id = ?";

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, pilates.getSession());
			psmt.setString(2, pilates.getId());
			int r = psmt.executeUpdate();
			System.out.println(r + "건 변경되었습니다. ");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}

	}

	@Override
	public void delete(String name) {
		connect();
		String sql = "delete from members where name = ?";

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, name);
			int r = psmt.executeUpdate();
			System.out.println(r + "건 삭제되었습니다.");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}
	}

	@Override
	public ArrayList<Course> courseList() {
		ArrayList<Course> list = new ArrayList<>();
		connect();

		String sql = "select * from course";
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();

			while (rs.next()) {
				Course c = new Course();
				c.setNo(rs.getInt("no"));
				c.setCourse(rs.getString("course"));
				c.setLevel(rs.getString("level"));
				c.setTeacher(rs.getString("teacher"));
				c.setDate(rs.getString("date"));
				list.add(c);
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
	public void enterCourse(Course course) {
		connect();
		String sql = "insert into course values (?,?,?,?,?)";

		try {
			psmt = conn.prepareStatement(sql);
			
			psmt.setInt(1, course.getNo());
			psmt.setString(2, course.getCourse());
			psmt.setString(3, course.getLevel());
			psmt.setString(4, course.getDate());
			psmt.setString(5, course.getTeacher());
			int r = psmt.executeUpdate();
			System.out.println(r + "건 입력되었습니다.");

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}

	}

	@Override
	public ArrayList<Teacher> teacherList() {
		ArrayList<Teacher> list = new ArrayList<>();
		connect();

		try {
			psmt = conn.prepareStatement("select * from Teacher");
			rs = psmt.executeQuery();
			while (rs.next()) {
				Teacher t = new Teacher();
				t.setName(rs.getString("name"));
				t.setAge(rs.getInt("age"));
				t.setExperience(rs.getString("experience"));
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
	public Teacher seachTeacher(String name) {
		connect();
		String sql = "select * from teacher where name = ?";
		Teacher t = null;

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, name);
			rs = psmt.executeQuery();

			while (rs.next()) {
				t = new Teacher();
				t.setName(rs.getString("name"));
				t.setAge(rs.getInt("age"));
				t.setExperience(rs.getString("experience"));
				t.setSpeciality(rs.getString("speciality"));
				t.setPhone(rs.getString("phone"));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return t;
	}

	@Override
	public void inputTeacher(Teacher teacher) {
		connect();
		String sql = "insert into teacher values (?,?,?,?,?)";

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, teacher.getName());
			psmt.setInt(2, teacher.getAge());
			psmt.setString(3, teacher.getExperience());
			psmt.setString(4, teacher.getSpeciality());
			psmt.setString(5, teacher.getPhone());
			int r = psmt.executeUpdate();
			System.out.println(r + "건 입력되었습니다.");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}
	}

	@Override
	public void deleteTeacher(String name) {
		connect();
		String sql = "delete from teacher where name =?";

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, name);
			int r = psmt.executeUpdate();
			System.out.println(r + "건 삭제되었습니다.");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}

	}

	public void deleteCourse(int num) {
		connect();
		String sql = "delete from course where no =?";

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, num);
			int r = psmt.executeUpdate();
			System.out.println(r + "건 삭제되었습니다.");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}

	}
}
