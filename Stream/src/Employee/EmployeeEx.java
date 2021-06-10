package Employee;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

public class EmployeeEx {
	
	static PreparedStatement psmt;
	static ResultSet rs;
	static Connection conn;
	
	public static  ArrayList<Employees> getPersonList() {
		ArrayList<Employees> list = new ArrayList<>(); // null값 담긴 객체 생성

		connect(); // 연결객체 사용, 객체 연결 꼭!! 해줘야 함.

		String sql = "select * from employees";
		try {
			// 요 두 개는 공식이라고 생각하자!
			psmt = conn.prepareStatement(sql); // PreparedStatment 쿼리 실행. 결과 받아 옴.
			rs = psmt.executeQuery(); // 쿼리 실행결과 가져오는 부분.
			while (rs.next()) {
				// System.out.println(rs.getInt("id")+","+rs.getString("name"));
				Employees em = new Employees(); // db에서 가져온 컬럼을 person필드에 담으려고 함.
				em.setEmployeeId(rs.getInt("EmployeeId"));
				em.setLastName(rs.getString("lastName"));
				em.setFirstName(rs.getString("FirstName"));
				em.setBirthDate(rs.getString("BirthDate"));
				list.add(em);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return list;

	}

	
	public static void filtering() {
		EmployeeEx ex = new EmployeeEx();
		List<Employees> list = ex.getPersonList();
		
		System.out.println("70년대 이후 출생자들");
		
		Stream<Employees> stream = list.stream();
		stream.filter((t)-> (Integer.parseInt(t.getBirthDate().substring(0,4))> 1970))
		.forEach((t)->System.out.println(t.toString()));
		
	}
	
	
	public static void connect() {
		String url = "jdbc:sqlite:C:/sqlite/db/chinook.db";
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

	public static void main(String[] args) {
		//System.out.println(getPersonList());
		filtering();
	}

}
